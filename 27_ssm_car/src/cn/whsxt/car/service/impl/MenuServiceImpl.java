package cn.whsxt.car.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.whsxt.car.mapper.MenuMapper;
import cn.whsxt.car.mapper.MenuMapperVo;
import cn.whsxt.car.pojo.ActiveUser;
import cn.whsxt.car.pojo.Menu;
import cn.whsxt.car.pojo.MenuExample;
import cn.whsxt.car.pojo.MenuExample.Criteria;
import cn.whsxt.car.service.MenuService;
import cn.whsxt.car.vo.EasyTree;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private MenuMapperVo menuMapperVo;

	/**
	 * 根据父节点查询所有子节点
	 */
	@Override
	public List<EasyTree> queryEasyTree(Integer id) {
		MenuExample example = new MenuExample();
		Criteria criteria = example.createCriteria();
		criteria.andPmidEqualTo(id);
		List<Menu> list = menuMapper.selectByExample(example);
		List<EasyTree> easyTrees = new ArrayList<>();
		if (list != null && !list.isEmpty()) {
			for (Menu menu : list) {
				EasyTree easyTree = new EasyTree();
				easyTree.setId(menu.getMid());
				easyTree.setText(menu.getMname());
				easyTree.setState(menu.getIsparent() == 1 ? "closed" : "open");
				easyTree.setUrl(menu.getUrl());
				easyTrees.add(easyTree);
			}
		}
		return easyTrees;
	}


	/**
	 * 根据用户加载对应菜单 
	 */
	@Override
	public List<EasyTree> queryMenuByUserVo(ActiveUser user) {
		MenuExample example = new MenuExample();
		Criteria criteria = example.createCriteria();
		criteria.andPmidEqualTo(user.getPmid());
		List<Menu> list = menuMapperVo.queryMenuByUserVo(user);
		List<EasyTree> easyTrees = new ArrayList<>();
		if (list != null && !list.isEmpty()) {
			for (Menu menu : list) {
				EasyTree easyTree = new EasyTree();
				easyTree.setId(menu.getMid());
				easyTree.setText(menu.getMname());
				easyTree.setState(menu.getIsparent() == 1 ? "closed" : "open");
				easyTree.setUrl(menu.getUrl());
				easyTrees.add(easyTree);
			}
		}
		return easyTrees;
	}
}
