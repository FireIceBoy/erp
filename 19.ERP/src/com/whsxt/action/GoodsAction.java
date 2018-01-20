package com.whsxt.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.whsxt.pojo.Goods;
import com.whsxt.pojo.Provider;
import com.whsxt.service.GoodsService;
import com.whsxt.service.ProviderService;
import com.whsxt.service.impl.GoodsServiceImpl;
import com.whsxt.service.impl.ProviderServiceImpl;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.GoodsVo;
import com.whsxt.vo.ProviderVo;

public class GoodsAction implements ModelDriven<GoodsVo> {

	// 服务层
	GoodsService goodsService = new GoodsServiceImpl();
	ProviderService providerService = new ProviderServiceImpl();

	// 模型驱动
	private GoodsVo goodsVo;

	// 对象驱动
	private PageBean pageBean = new PageBean();

	private ProviderVo providerVo = new ProviderVo();

	// 属性驱动
	private List<Goods> list;
	private List<Provider> list2;

	/**
	 * 全查询
	 */
	public String query() {
		

		list = goodsService.query(pageBean, goodsVo);

		return "query";
	}
	
	
	

	/**
	 * 去添加页面
	 */
	public String toAdd() {
		// 查询出所有供应商

		list2 = providerService.query(pageBean, providerVo);

		return "toAdd";
	}

	/**
	 * 添加
	 */
	public String add() {
		goodsService.add(goodsVo);
		return this.query();
	}

	/**
	 * 去修改页面
	 */
	public String toUpdate() {
		// 查出商品
		int gid = goodsVo.getGid();
		goodsVo = goodsService.queryById(gid);
		// 查询出所有供应商
		list2 = providerService.query(pageBean, providerVo);
		
		return "toUpdate";
	}
	

	/**
	 * 修改
	 */
	public String update() {
		goodsService.update(goodsVo);
		return this.query();
	}

	/**
	 * 删除
	 */
	public String del() {
		int gid = goodsVo.getGid();
		this.goodsService.del(gid);
		return this.query();

	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public List<Goods> getList() {
		return list;
	}

	public void setList(List<Goods> list) {
		this.list = list;
	}

	@Override
	public GoodsVo getModel() {
		return goodsVo = new GoodsVo();
	}

	public GoodsVo getGoodsVo() {
		return goodsVo;
	}

	public void setGoodsVo(GoodsVo goodsVo) {
		this.goodsVo = goodsVo;
	}

	public ProviderVo getProviderVo() {
		return providerVo;
	}

	public void setProviderVo(ProviderVo providerVo) {
		this.providerVo = providerVo;
	}

	public List<Provider> getList2() {
		return list2;
	}

	public void setList2(List<Provider> list2) {
		this.list2 = list2;
	}

}
