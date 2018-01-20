package com.whsxt.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.whsxt.pojo.Customer;
import com.whsxt.pojo.Goods;
import com.whsxt.pojo.Operator;
import com.whsxt.pojo.SalesBack;
import com.whsxt.service.CustomerService;
import com.whsxt.service.GoodsService;
import com.whsxt.service.SalesBackService;
import com.whsxt.service.SalesService;
import com.whsxt.service.impl.CustomerServiceImpl;
import com.whsxt.service.impl.GoodsServiceImpl;
import com.whsxt.service.impl.SalesBackServiceImpl;
import com.whsxt.service.impl.SalesServiceImpl;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.CustomerVo;
import com.whsxt.vo.GoodsVo;
import com.whsxt.vo.SalesBackVo;
import com.whsxt.vo.SalesVo;

public class SalesBackAction implements ModelDriven<SalesBackVo> {

	private SalesBackVo salesBackVo;

	private SalesVo salesVo;

	private GoodsVo goodsVo = new GoodsVo();

	private CustomerVo customerVo = new CustomerVo();

	private PageBean pageBean = new PageBean();

	private List<SalesBack> list;
	private List<Customer> customerList;
	private List<Goods> goodsList;

	SalesBackService salesBackService = new SalesBackServiceImpl();
	SalesService salesService = new SalesServiceImpl();
	GoodsService goodsService = new GoodsServiceImpl();
	CustomerService customerService = new CustomerServiceImpl();

	/**
	 * 查询
	 * 
	 * @return
	 */
	public String query() {
		// 判断操作员的姓名是否为空
		if (salesBackVo.getOperator() == null) {
			salesBackVo.setOperator(new Operator(""));
		}
		list = salesBackService.query(pageBean, salesBackVo);
		return "query";
	}

	/**
	 * 去添加
	 */
	public String toAdd() {
		// 根据id查出销售信息
		salesVo = salesService.queryById(salesVo.getId());
		// 查出所有的商品

		return "toAdd";
	}

	/**
	 * 添加
	 */
	public String add() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Operator operator = (Operator) session.get("operator");
		salesBackVo.setOperator(new Operator(operator.getName()));

		// 添加退货记录时，修改商品数量
		// 先根据id 查出商品信息
		goodsVo = goodsService.queryById(salesVo.getGoods().getGid());
		// 查出销售信息
		salesVo = salesService.queryById(salesVo.getId());

		salesBackVo.setCustomer(new Customer(salesVo.getCustomer().getCid()));
		salesBackVo.setGoods(new Goods(goodsVo.getGid()));
		
		// 减少销售里的商品数量
		salesVo.setNumber(salesVo.getNumber() - salesBackVo.getNumber());
		salesService.update(salesVo);
		// 增加商品数量
		goodsVo.setNumber(goodsVo.getNumber() + salesBackVo.getNumber());
		goodsService.update(goodsVo);
		

		salesBackService.add(salesBackVo);
		return this.query();
	}

	@Override
	public SalesBackVo getModel() {
		return salesBackVo = new SalesBackVo();
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
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

	public SalesBackVo getSalesBackVo() {
		return salesBackVo;
	}

	public void setSalesBackVo(SalesBackVo salesBackVo) {
		this.salesBackVo = salesBackVo;
	}

	public List<SalesBack> getList() {
		return list;
	}

	public void setList(List<SalesBack> list) {
		this.list = list;
	}

	public SalesVo getSalesVo() {
		return salesVo;
	}

	public void setSalesVo(SalesVo salesVo) {
		this.salesVo = salesVo;
	}

}
