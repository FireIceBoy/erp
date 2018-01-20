package com.whsxt.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.whsxt.pojo.Customer;
import com.whsxt.pojo.Goods;
import com.whsxt.pojo.Operator;
import com.whsxt.pojo.Sales;
import com.whsxt.service.CustomerService;
import com.whsxt.service.GoodsService;
import com.whsxt.service.SalesService;
import com.whsxt.service.impl.CustomerServiceImpl;
import com.whsxt.service.impl.GoodsServiceImpl;
import com.whsxt.service.impl.SalesServiceImpl;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.CustomerVo;
import com.whsxt.vo.GoodsVo;
import com.whsxt.vo.SalesVo;

public class SalesAction implements ModelDriven<SalesVo> {

	private SalesVo salesVo;

	private GoodsVo goodsVo = new GoodsVo();

	private CustomerVo customerVo = new CustomerVo();

	private PageBean pageBean = new PageBean();

	private List<Sales> list;
	private List<Customer> customerList;
	private List<Goods> goodsList;

	SalesService salesService = new SalesServiceImpl();
	GoodsService goodsService = new GoodsServiceImpl();
	CustomerService customerService = new CustomerServiceImpl();

	/**
	 * 查询
	 * 
	 * @return
	 */
	public String query() {
		if (salesVo.getOperator() == null) {
			salesVo.setOperator(new Operator(""));
		}
		list = salesService.query(pageBean, salesVo);
		return "query";
	}

	/**
	 * 去添加
	 */
	public String toAdd() {
		// 查出所有的客户
		customerList = customerService.query();
		// 查出所有的商品
		goodsList = goodsService.query();
		return "toAdd";
	}

	/**
	 * 添加
	 */
	public String add() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Operator operator = (Operator) session.get("operator");
		salesVo.setOperator(new Operator(operator.getName()));

		// 添加销售记录时，修改商品数量
		// 先根据id 查出商品信息
		goodsVo = goodsService.queryById(salesVo.getGoods().getGid());
		// 根据前台信息，修改商品数量
		goodsVo.setNumber(goodsVo.getNumber() - salesVo.getNumber());

		// 设置客户信息
		
		goodsService.update(goodsVo);
		salesService.add(salesVo);
		return this.query();
	}

	@Override
	public SalesVo getModel() {
		return salesVo = new SalesVo();
	}

	public SalesVo getSalesVo() {
		return salesVo;
	}

	public void setSalesVo(SalesVo salesVo) {
		this.salesVo = salesVo;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public List<Sales> getList() {
		return list;
	}

	public void setList(List<Sales> list) {
		this.list = list;
	}

	public GoodsVo getGoodsVo() {
		return goodsVo;
	}

	public void setGoodsVo(GoodsVo goodsVo) {
		this.goodsVo = goodsVo;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	public CustomerVo getCustomerVo() {
		return customerVo;
	}

	public void setCustomerVo(CustomerVo customerVo) {
		this.customerVo = customerVo;
	}

}
