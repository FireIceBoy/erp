package cn.whsxt.car.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.whsxt.car.mapper.MenuMapperVo;
import cn.whsxt.car.mapper.UserMapper;
import cn.whsxt.car.pojo.ActiveUser;
import cn.whsxt.car.pojo.Menu;
import cn.whsxt.car.pojo.User;
import cn.whsxt.car.pojo.UserExample;
import cn.whsxt.car.pojo.UserExample.Criteria;
import cn.whsxt.car.service.UserService;
import cn.whsxt.car.utils.MD5;
import cn.whsxt.car.vo.PageForList;
import cn.whsxt.car.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private MenuMapperVo menuMapperVo;

	/**
	 * 根据用户名查询用户对象
	 */
	@Override
	public ActiveUser queryUserByUsername(UserVo userVo) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(userVo.getUsername());
		List<User> list = userMapper.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			// 判断密码是否正确
			MD5 md5 = new MD5();
			//将前段传来的密码先做加密,在跟数据库对比(MD5加密后解密难度非常大,基本不可逆向,但是同一个字符串加密结果相同)
			if (list.get(0).getUserpwd().equals(md5.getMD5ofStr(userVo.getUserpwd()))) {
				ActiveUser activeUser = new ActiveUser();
				BeanUtils.copyProperties(list.get(0), activeUser);
				//查询可以访问的url
				List<Menu> menuUrlList = menuMapperVo.queryMenuUrlByUserVo(activeUser);
				activeUser.setList(menuUrlList);
				return activeUser;
			}
		}
		return null;
	}

	/**
	 * 查询所有用户信息
	 */
	@Override
	public List<UserVo> queryUser() {
		List<User> list = userMapper.selectByExample(null);
		List<UserVo> userVos = new ArrayList<>();
		if (list != null && !list.isEmpty()) {
			for (User user : list) {
				UserVo userVo = new UserVo();
				BeanUtils.copyProperties(user, userVo);
				userVos.add(userVo);
			}
			return userVos;
		}
		return null;
	}

	/**
	 * 更新用户信息
	 */
	@Override
	public void updateUser(UserVo userVo) {
		userMapper.updateByPrimaryKey(userVo);
		
	}

	/**
	 * 添加用户信息
	 */
	@Override
	public void saveUser(UserVo userVo) {
		//密码在保存数据库之前先做加密
		userVo.setUserpwd(new MD5().getMD5ofStr(userVo.getUserpwd()));
		userMapper.insert(userVo);
	}

	/**
	 * 删除用户
	 */
	@Override
	public void delete(String username) {
		userMapper.deleteByPrimaryKey(username);
	}

	@Override
	public PageForList queryUserOfPage(UserVo userVo) {
		PageHelper.startPage(userVo.getPage(), userVo.getRows());
		UserExample example = new UserExample();
		List<User> list = userMapper.selectByExample(example );
		PageInfo<User> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		PageForList pageForList = new PageForList();
		pageForList.setTotal(total);
		pageForList.setRows(list);
		return pageForList;
	}

}
