package com.whsxt.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.whsxt.pojo.Operator;

/**
 * 处理登陆成功之后的页面组装
 * 
 * @author Administrator
 * 
 */
public class AdminAction {

	public String top() {
		// 为了显示登陆的账户名
		HttpSession session = ServletActionContext.getRequest().getSession();
		Operator operator = (Operator) session.getAttribute("operator");
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("operator", operator);
		return "top";
	}

	public String left() {
		return "left";
	}

	public String footer() {
		return "footer";
	}

	public String index() {
		return "index";
	}

	public String inport() {
		return "inport";
	}
	
	public String outport() {
		return "outport";
	}
	
	public String login() {
		return "login";
	}
	
	
}
