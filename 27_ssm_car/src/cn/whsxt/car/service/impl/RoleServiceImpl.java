package cn.whsxt.car.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.whsxt.car.mapper.RoleMapper;
import cn.whsxt.car.pojo.Role;
import cn.whsxt.car.pojo.RoleExample;
import cn.whsxt.car.service.RoleService;
import cn.whsxt.car.vo.PageForList;
import cn.whsxt.car.vo.RoleVo;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	/**
	 * 查询所有角色信息
	 */
	@Override
	public List<RoleVo> queryRoleList() {
		RoleExample example = new RoleExample();
		List<Role> list = roleMapper.selectByExample(example);
		List<RoleVo> roleVos = new ArrayList<>();
		if (list != null && !list.isEmpty()) {
			for (Role role : list) {
				RoleVo roleVo = new RoleVo();
				BeanUtils.copyProperties(role, roleVo);
				roleVos.add(roleVo);
			}
		}
		return roleVos;
	}

	/**
	 * 查询所有角色信息 (带分页),返回PageForList
	 */
	@Override
	public PageForList queryRoleListOfPage(RoleVo roleVo) {
		// 设置分页信息
		PageHelper.startPage(roleVo.getPage(), roleVo.getRows());
		// 查询数据
		RoleExample example = new RoleExample();
		List<Role> list = roleMapper.selectByExample(example);
		// 获取总条数,必须在先查询出数据后获取总条数
		PageInfo<Role> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();

		PageForList pageForList = new PageForList();
		pageForList.setRows(list);
		pageForList.setTotal(total);
		return pageForList;
	}

	/**
	 * 查询所有角色信息 (带分页),返回map集合
	 */
	@Override
	public Map<String, Object> queryRoleForMap(RoleVo roleVo) {
		// 设置分页信息
		PageHelper.startPage(roleVo.getPage(), roleVo.getRows());

		RoleExample example = new RoleExample();
		List<Role> list = roleMapper.selectByExample(example);
		// 获取总条数,必须在先查询出数据后获取总条数
		PageInfo<Role> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	
	/**
	 * 添加角色
	 */
	@Override
	public void saveRole(RoleVo roleVo) {
		roleMapper.insert(roleVo);
	}
	
	/**
	 * 修改角色
	 */
	@Override
	public void updateRole(RoleVo roleVo) {
		roleMapper.updateByPrimaryKey(roleVo);
	}

	/**
	 * 删除角色
	 */
	@Override
	public void delete(Integer roleid) {
		roleMapper.deleteByPrimaryKey(roleid);
	}
}
