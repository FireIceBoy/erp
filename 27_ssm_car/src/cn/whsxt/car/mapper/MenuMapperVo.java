package cn.whsxt.car.mapper;

import java.util.List;

import cn.whsxt.car.pojo.ActiveUser;
import cn.whsxt.car.pojo.Menu;

public interface MenuMapperVo {

	/**
	 * 根据用户加载对应菜单(有该菜单的显示权限,但是并不一定有该菜单的访问权限)
	 * 这就是细粒度的访问权限控制,解决了通过角色控制访问权限的弊端
	 * (弊端:比如经理有访问财务信息的菜单权限,但是只能财务的经理访问财务信息权限,这样者通过角色控制菜单权限就无法满足开发需求,通过控制用户是否有该url的访问权限来限制访问)
	 */
	List<Menu> queryMenuByUserVo(ActiveUser user);
	
	/**
	 * 根据用户加载对应的可以访问的url
	 */
	List<Menu> queryMenuUrlByUserVo(ActiveUser user);
	
}