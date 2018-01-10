package cn.whsxt.car.service;

import java.util.List;

import cn.whsxt.car.pojo.ActiveUser;
import cn.whsxt.car.vo.PageForList;
import cn.whsxt.car.vo.UserVo;

public interface UserService {
	ActiveUser queryUserByUsername(UserVo userVo);
	
	List<UserVo> queryUser();
	
	void updateUser(UserVo userVo);
	
	void saveUser(UserVo userVo);
	
	void delete(String username);
	
	PageForList queryUserOfPage(UserVo userVo);
}
