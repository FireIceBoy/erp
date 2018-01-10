package cn.whsxt.car.service;

import java.util.List;
import java.util.Map;

import cn.whsxt.car.vo.PageForList;
import cn.whsxt.car.vo.RoleVo;

public interface RoleService {
	List<RoleVo> queryRoleList();

	PageForList queryRoleListOfPage(RoleVo roleVo);

	Map<String, Object> queryRoleForMap(RoleVo roleVo);
	
	void saveRole(RoleVo roleVo);
	
	void updateRole(RoleVo roleVo);
	
	void delete(Integer roleid);
}
