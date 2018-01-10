package cn.whsxt.car.service;

import java.util.List;

import cn.whsxt.car.pojo.ActiveUser;
import cn.whsxt.car.vo.EasyTree;

public interface MenuService {
	List<EasyTree> queryEasyTree(Integer id);

	List<EasyTree> queryMenuByUserVo(ActiveUser user);
}
