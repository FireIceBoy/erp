package com.whsxt.dao;

import java.util.List;

import com.whsxt.pojo.Customer;
import com.whsxt.utils.bean.PageBean;

/**
 * 操作数据库接口，客户表
 * @author 金诚
 */
public interface CustomerDao {

	/**
	 * 添加
	 */
	void add(Customer customer);

	/**
	 * 删除
	 */
	void del(int id);

	/**
	 * 修改
	 */
	void update(Customer customer);

	/**
	 * 全查询,分页
	 */
	List<Customer> query(PageBean pageBean,Customer customer);
	
	/**
	 * 根据id查询一个
	 */
	Customer queryById(int id);
	
	/**
	 * 全查询
	 */
	List<Customer> query();
}
