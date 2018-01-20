package com.whsxt.service;

import java.util.List;

import com.whsxt.pojo.Customer;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.CustomerVo;

public interface CustomerService {
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
	List<CustomerVo> query(PageBean pageBean,CustomerVo customerVo);

	/**
	 * 根据id查询一个
	 */
	CustomerVo queryById(int id);
	
	
	/**
	 * 全查询
	 */
	List<Customer> query();

}
