package com.whsxt.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.whsxt.service.CustomerService;
import com.whsxt.service.impl.CustomerServiceImpl;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.CustomerVo;

public class CustomerAction implements ModelDriven<CustomerVo> {

	// 服务层
	CustomerService customerService = new CustomerServiceImpl();

	// 模型驱动
	private CustomerVo customerVo;

	// 对象驱动
	private PageBean pageBean = new PageBean();

	// 属性驱动
	private List<CustomerVo> list;

	/**
	 * 全查询
	 */
	public String query() {

		list = customerService.query(pageBean, customerVo);

		return "query";
	}

	/**
	 * 去添加页面
	 */
	public String toAdd() {
		return "toAdd";
	}

	/**
	 * 添加
	 */
	public String add() {
		customerService.add(customerVo);
		return this.query();
	}

	/**
	 * 去修改页面
	 */
	public String toUpdate() {
		// 查出客户
		int cid = customerVo.getCid();
		customerVo = customerService.queryById(cid);
		return "toUpdate";
	}

	/**
	 * 修改
	 */
	public String update() {
		customerService.update(customerVo);
		return this.query();
	}

	/**
	 * 删除
	 */
	public String del() {
		int cid = customerVo.getCid();
		customerService.del(cid);
		return this.query();

	}

	public CustomerVo getCustomerVo() {
		return customerVo;
	}

	public void setCustomerVo(CustomerVo customerVo) {
		this.customerVo = customerVo;
	}

	@Override
	public CustomerVo getModel() {
		return customerVo = new CustomerVo();
	}

	public List<CustomerVo> getList() {
		return list;
	}

	public void setList(List<CustomerVo> list) {
		this.list = list;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

}
