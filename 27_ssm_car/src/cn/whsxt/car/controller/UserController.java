package cn.whsxt.car.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.whsxt.car.pojo.ActiveUser;
import cn.whsxt.car.service.MenuService;
import cn.whsxt.car.service.UserService;
import cn.whsxt.car.vo.EasyTree;
import cn.whsxt.car.vo.PageForList;
import cn.whsxt.car.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;
	
	/**
	 * 跳转到登录界面
	 */
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "main/login";
	}
	
	/**
	 * 登录
	 */
	@RequestMapping("/login")
	public String login(UserVo userVo, HttpSession session) {
		ActiveUser user = userService.queryUserByUsername(userVo);
		if(user != null) {
			session.setAttribute("user", user);
			return "main/main";
		}
		return "main/login";
	}
	
	
	/**
	 * 根据用户加载对应菜单 
	 */
	@RequestMapping("/queryMenuByUserVo")
	@ResponseBody
	public List<EasyTree> queryMenuByUserVo(@RequestParam(value="id", defaultValue="1") Integer id,HttpSession session) {
		ActiveUser user = (ActiveUser) session.getAttribute("user");
		user.setPmid(id);
		List<EasyTree> easyTrees = menuService.queryMenuByUserVo(user);
		return easyTrees;
	}
	
	/**
	 * 加载菜单 
	 */
	@RequestMapping("/queryTree")
	@ResponseBody
	public List<EasyTree> queryTree(@RequestParam(value="id", defaultValue="1") Integer id) {
 		List<EasyTree> easyTrees = menuService.queryEasyTree(id);
		return easyTrees;
	}
	
	
	
	/**
	 * 跳转到用户列表
	 */
	@RequestMapping("/toUserList")
	public String toUserList() {
		return "user/userList";
	}
	
	/**
	 * 查询所有用户信息
	 */
	@RequestMapping("/queryUser")
	@ResponseBody
	public List<UserVo> queryUser() {
		List<UserVo> list = userService.queryUser();
		return list;
	}
	
	/**
	 * 查询所有用户信息(有分页)
	 */
	@RequestMapping("/queryUserOfPage")
	@ResponseBody
	public PageForList queryUserOfPage(UserVo userVo) {
		return userService.queryUserOfPage(userVo);
	}
	
	
	/**
	 * 添加用户
	 */
	@RequestMapping("/saveUser")
	@ResponseBody
	public Object saveUser(UserVo userVo) {
		userService.saveUser(userVo);
		return null;
	}
	
	/**
	 * 修改用户
	 */
	@RequestMapping("/updateUser")
	@ResponseBody
	public Object updateUser(UserVo userVo) {
		userService.updateUser(userVo);
		return null;
	}
	
	/**
	 * 删除用户
	 */
	@RequestMapping("/deleteUser")
	@ResponseBody
	public Object deleteUser(String username) {
		userService.delete(username);
		return null;
	}
	
	/**
	 * 跳转错误提示界面
	 */
	@RequestMapping("/toPromt")
	public String toPromt() {
		return "main/prompt";
	}
	
	/**
	 * 退出登录
	 */
	@RequestMapping("/exit")
	public void exit(HttpSession session) {
		session.invalidate();
	}
}
