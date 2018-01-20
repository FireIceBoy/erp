package com.whsxt.dao;

import java.util.List;

import com.whsxt.pojo.Goods;
import com.whsxt.utils.bean.PageBean;

public interface GoodsDao {

	/**
	 * 添加
	 */
	void add(Goods goods);

	/**
	 * 删除
	 */
	void del(int id);

	/**
	 * 修改
	 */
	void update(Goods goods);

	/**
	 * 全查询,分页
	 */
	List<Goods> query(PageBean pageBean,Goods goods);

	/**
	 * 根据id查询一个
	 */
	Goods queryById(int id);
	
	/**
	 * 根据供应商id查询
	 */
	List<Goods> queryByPid(int id);
	
	/**
	 * 全查询
	 */
	List<Goods> query();
}
