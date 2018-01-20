package com.whsxt.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.whsxt.pojo.Operator;
import com.whsxt.service.OperatorService;
import com.whsxt.service.impl.OperatorServiceImpl;

public class OperatorAction implements ModelDriven<Operator> {

	private Operator operator;

	// 服务层
	OperatorService operatorService = new OperatorServiceImpl();

	/**
	 * 去修改
	 */
	public String toUpdate() {
		// 取出session里的管理员信息
		HttpSession session = ServletActionContext.getRequest().getSession();
		operator = (Operator) session.getAttribute("operator");
		return "toUpdate";
	}

	public String update() {
		// 取出session里的管理员信息
		HttpSession session = ServletActionContext.getRequest().getSession();
		Operator oldOperator = (Operator) session.getAttribute("operator");
		
		// 更改密码之后要清除cookie内的账号和密码
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		for (Cookie cookie : cookies) {
			if ("username".equals(cookie.getName()) || "password".equals(cookie.getName())) {
				cookie.setMaxAge(0);
				// 响应给页面
				ServletActionContext.getResponse().addCookie(cookie);
			}
		}

		oldOperator.setPassword(operator.getPassword());
		operatorService.update(oldOperator);
		return Action.NONE;
	}

	public String jump() {
		return "jump";
	}

	@Override
	public Operator getModel() {
		return operator = new Operator();
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

}
