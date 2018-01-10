package cn.whsxt.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.whsxt.car.service.CustomerService;
import cn.whsxt.car.vo.CustomerVo;
import cn.whsxt.car.vo.PageForList;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	/**
	 * 跳转条件查询界面
	 */
	@RequestMapping("/toQueryCustomer") 
	public String toQueryCustomer() {
		return "customer/customerQueryUI";
	}
	
	/**
	 * 条件分页查询
	 */
	@RequestMapping("/queryCustomer")
	@ResponseBody
	public PageForList queryCustomer(CustomerVo customerVo) {
		return customerService.queryCustomer(customerVo);
	}
	
	/**
	 * 跳转添加用户界面
	 */
	@RequestMapping("/toSaveCustomer") 
	public String toSaveCustomer() {
		return "customer/saveCustomer";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("/saveCustomer")
	@ResponseBody
	public Object saveCustomer(CustomerVo customerVo) {
		customerService.saveCustomer(customerVo);
		return null;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/updateCustomer")
	@ResponseBody
	public Object updateCustomer(CustomerVo customerVo) {
		customerService.updateCustomer(customerVo);
		return null;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/deleteCustomer")
	@ResponseBody
	public Object deleteCustomer(String identity) {
		customerService.deleteCustomer(identity);
		return null;
	}
	
}
