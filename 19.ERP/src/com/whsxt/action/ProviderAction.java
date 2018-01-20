package com.whsxt.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.whsxt.pojo.Provider;
import com.whsxt.service.ProviderService;
import com.whsxt.service.impl.ProviderServiceImpl;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.ProviderVo;

public class ProviderAction implements ModelDriven<ProviderVo> {

	private ProviderVo providerVo;
	private ProviderService providerService = new ProviderServiceImpl();

	public String toAdd() {
		return "add";
	}

	public String add() {
		providerService.add(providerVo);
		return Action.NONE;
	}

	public String del() {
		providerService.del(providerVo.getPid());
		this.query();
		return "list";
	}

	public String toUpdate() {
		providerVo = providerService.queryById(providerVo.getPid());
		return "update";
	}

	public String update() {
		providerService.update(providerVo);
		return "list";
	}

	private PageBean pageBean = new PageBean();
	private List<Provider> list = new ArrayList<>();

	public String query() {
		list = providerService.query(pageBean, providerVo);
		return "list";
	}

	@Override
	public ProviderVo getModel() {
		return this.providerVo = new ProviderVo();
	}

	public ProviderVo getProviderVo() {
		return providerVo;
	}

	public void setProviderVo(ProviderVo providerVo) {
		this.providerVo = providerVo;
	}

	public List<Provider> getList() {
		return list;
	}

	public void setList(List<Provider> list) {
		this.list = list;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

}
