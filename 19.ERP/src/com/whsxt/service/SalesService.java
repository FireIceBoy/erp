package com.whsxt.service;

import java.util.List;

import com.whsxt.pojo.Sales;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.SalesVo;

public interface SalesService {

	/**
	 * 查询销售列表
	 */
	List<Sales> query(PageBean pageBean, SalesVo salesVo);

	/**
	 * 添加销售记录
	 */
	void add(Sales sales);
	
	/**
	 * 根据销售id,查出销售信息
	 */
	SalesVo queryById(int id);
	
	
	/**
	 * 修改
	 * @param sales
	 */
	void update(Sales sales);
}
