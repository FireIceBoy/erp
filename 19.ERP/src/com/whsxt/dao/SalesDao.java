package com.whsxt.dao;

import java.util.List;

import com.whsxt.pojo.Sales;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.SalesVo;

/**
 * 销售表，操作数据库接口
 * 
 * @author 金诚
 */
public interface SalesDao {

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
	Sales queryById(int id);
	
	/**
	 * 修改
	 * @param sales
	 */
	void update(Sales sales);

}
