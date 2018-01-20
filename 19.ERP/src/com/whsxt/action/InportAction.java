package com.whsxt.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.whsxt.pojo.Inport;
import com.whsxt.pojo.Operator;
import com.whsxt.pojo.Provider;
import com.whsxt.service.InportService;
import com.whsxt.service.ProviderService;
import com.whsxt.service.impl.InportServiceImpl;
import com.whsxt.service.impl.ProviderServiceImpl;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.InportVo;
import com.whsxt.vo.ProviderVo;

public class InportAction implements ModelDriven<InportVo> {
	private InportVo inportVo = new InportVo();
	private InportService inportService = new InportServiceImpl();

	public String toAdd() {
		//所有状态可用的供应商
		ProviderService providerService = new ProviderServiceImpl();
		//全查询都有分页,将每页显示数量设为一个很大的值
		pageBean.setPageSize(100);
		ProviderVo providerVo = new ProviderVo();
		providerVo.setAvailable(1);
		List<Provider> providerList = providerService.query(pageBean, providerVo);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("providerList", providerList);
		return "add";
	}

	public String add() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Operator operator = (Operator) session.get("operator");
		inportVo.setOperateperson(operator.getName());
		inportService.add(inportVo);
		return Action.NONE;
	}

	public String del() {
		inportService.del(inportVo.getId());
		this.query();
		return "list";
	}

	private List<Inport> list = new ArrayList<>();
	private PageBean pageBean = new PageBean();

	public String query() {
		list = inportService.query(pageBean, inportVo);
		return "list";
	}

	public InportVo getInportVo() {
		return inportVo;
	}

	public void setInportVo(InportVo inportVo) {
		this.inportVo = inportVo;
	}

	@Override
	public InportVo getModel() {
		return this.inportVo = new InportVo();
	}

	public List<Inport> getList() {
		return list;
	}

	public void setList(List<Inport> list) {
		this.list = list;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

}
