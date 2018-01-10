package cn.whsxt.car.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.whsxt.car.service.RoleService;
import cn.whsxt.car.vo.PageForList;
import cn.whsxt.car.vo.RoleVo;
@Controller
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	/**
	 * 跳转角色列表界面
	 */
	@RequestMapping("/toRoleList")
	public String toRoleList() {
		return "role/roleList";
	}
	
	/**
	 * 查询所有角色信息 (不带分页)
	 */
	@RequestMapping("/queryRoleList")
	@ResponseBody
	public List<RoleVo> queryRoleList() {
		return roleService.queryRoleList();
	}
	
	/**
	 * 查询所有角色信息 (带分页),返回PageForList
	 */
	@RequestMapping("/queryRoleListOfPage")
	@ResponseBody
	public PageForList queryRoleListOfPage(RoleVo roleVo) {
		return roleService.queryRoleListOfPage(roleVo);
	}
	
	/**
	 * 查询所有角色信息 (带分页),分会PageForList
	 */
	@RequestMapping("/queryRoleForMap")
	@ResponseBody
	public Map<String, Object> queryRoleForMap(RoleVo roleVo) {
		return roleService.queryRoleForMap(roleVo);
	}
	
	/**
	 * 添加角色
	 */
	@RequestMapping("/saveRole")//如果没有返回值,就会把saveRole返回前台,springmvc会把saveRole当做一个html文件名,前台报异常
	@ResponseBody
	public Object saveRole(RoleVo roleVo) {
		roleService.saveRole(roleVo);
		return null;
	}
	
	/**
	 * 修改角色
	 */
	@RequestMapping("updateRole")
	@ResponseBody
	public Object updateRole(RoleVo roleVo) {
		roleService.updateRole(roleVo);
		return null;
	}

	/**
	 * 删除角色
	 */
	@RequestMapping("deleteRole")
	@ResponseBody
	public Object delete(Integer roleid) {
		roleService.delete(roleid);
		return null;
	}
}
