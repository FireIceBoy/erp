package com.whsxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.whsxt.dao.CustomerDao;
import com.whsxt.dao.impl.CustomerDaoImpl;
import com.whsxt.pojo.Customer;
import com.whsxt.service.CustomerService;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.CustomerVo;

/**
 * 客户服务层实现类
 * 
 * @author 金诚
 */
public class CustomerServiceImpl implements CustomerService {

	// dao
	CustomerDao customerDao = new CustomerDaoImpl();

	public void add(Customer customer) {
		customerDao.add(customer);

	}

	@Override
	public void del(int id) {
		customerDao.del(id);
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	public List<CustomerVo> query(PageBean pageBean, CustomerVo customerVo) {
		// 判断当前页是否为0
		if (0 == pageBean.getCurrentPage()) {
			pageBean.setCurrentPage(1);
		}
		// 判断客户姓名是否为空
		if (null == customerVo.getCustomername()) {
			customerVo.setCustomername("");
		}
		// 判断keywords是否为空
		if (null == customerVo.getKeywords()) {
			customerVo.setKeywords("");
		}
		List<Customer> customerList = customerDao.query(pageBean, customerVo);
		List<CustomerVo> customerVoList = new ArrayList<>();
		for (Customer customer1 : customerList) {
			CustomerVo vo = new CustomerVo();
			try {
				BeanUtils.copyProperties(vo, customer1);
				customerVoList.add(vo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return customerVoList;
	}

	@Override
	public CustomerVo queryById(int id) {
		Customer customer = customerDao.queryById(id);
		CustomerVo vo = new CustomerVo();
		try {
			BeanUtils.copyProperties(vo, customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<Customer> query() {
		return customerDao.query();
	}

}
