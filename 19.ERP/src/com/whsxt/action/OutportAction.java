package com.whsxt.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.whsxt.pojo.Operator;
import com.whsxt.pojo.Outport;
import com.whsxt.service.OutportService;
import com.whsxt.service.impl.InportServiceImpl;
import com.whsxt.service.impl.OutportServiceImpl;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.InportVo;
import com.whsxt.vo.OutportVo;

public class OutportAction implements ModelDriven<OutportVo> {
	private OutportVo outportVo;
	private OutportService outportService = new OutportServiceImpl();
	//需要退货的进货对象id
	private int outportId;

	public String toAdd() {
		InportVo inportVo = new InportServiceImpl().queryById(outportId);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("inportVo", inportVo);
		request.put("outportId", outportId);
		return "add";
	}

	public String add() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Operator operator = (Operator) session.get("operator");
		outportVo.setOperateperson(operator.getName());
		outportService.add(outportVo,outportId);
		return Action.NONE;
	}

	public String del() {
		outportService.del(outportVo.getId());
		this.query();
		return "list";
	}

	private List<Outport> list = new ArrayList<>();
	private PageBean pageBean = new PageBean();

	public String query() {
		list = outportService.query(pageBean, outportVo);
		return "list";
	}

	@Override
	public OutportVo getModel() {
		return this.outportVo = new OutportVo();
	}

	public OutportVo getOutportVo() {
		return outportVo;
	}

	public void setOutportVo(OutportVo outportVo) {
		this.outportVo = outportVo;
	}

	public List<Outport> getList() {
		return list;
	}

	public void setList(List<Outport> list) {
		this.list = list;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public int getOutportId() {
		return outportId;
	}

	public void setOutportId(int outportId) {
		this.outportId = outportId;
	}

}
