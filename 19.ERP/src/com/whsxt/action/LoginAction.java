package com.whsxt.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.whsxt.pojo.Operator;
import com.whsxt.service.OperatorService;
import com.whsxt.service.impl.OperatorServiceImpl;
import com.whsxt.vo.OperatorVo;

public class LoginAction implements ModelDriven<OperatorVo> {

	private OperatorVo operatorVo;

	// 服务层
	OperatorService operatorService = new OperatorServiceImpl();

	/**
	 * 登陆
	 * @return
	 */
	public String login() {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		// 系统产生的验证码
		String trueCode = (String) request.getSession().getAttribute("code");

		String username = "", password = "";
		// 获取请求头里面cookie对象
		Cookie[] cookies = request.getCookies();
		// 判断cookies是否为空,如果不为空,则在cookies取出账号密码,如果为空,就去表单取账号密码
		if (null != cookies) {
			// cookie.getName()取值key
			// cookie.getValue()取到value
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					username = cookie.getValue();
				} else if (cookie.getName().equals("password")) {
					password = cookie.getValue();
				}
			}
		}

		boolean isLogin = false;// 判断是否在表单内取出账号和密码
		// 判断cookies是否存有账号密码
		if (null == username || "".equals(username)) {
			//判断登录的验证码是否为空
			if(null != operatorVo.getCode()){
				//判断验证码是否正确
				if (trueCode.equalsIgnoreCase(operatorVo.getCode())) {
					isLogin = true;
				} else {
					request.setAttribute("arr", "验证码输入错误");
					return "error";
				}
			}else{
				//没有产生验证码
				return "error";
			}
			
		}else{
			//cookies取出来的账号或是密码不为空或是空字符
			operatorVo.setUsername(username);
			operatorVo.setPassword(password);
		}

		Operator operator = operatorService.query(operatorVo);
		// 判断账号密码是否正确
		if (null != operator) {
			// 当密码从表单取出,同时选择了记住密码
			if (isLogin && "on".equals(operatorVo.getMemory())) {
				// 创建一个cookie对象,把账号和密码存放到cookie内,并设置存放时间
				Cookie depositusername = new Cookie("username", operatorVo.getUsername());
				Cookie depositpassword = new Cookie("password", operatorVo.getPassword());
				// 设置存放时间,单位是秒
				depositusername.setMaxAge(60*60*60*24*7);
				depositpassword.setMaxAge(60*60*60*24*7);
				// 响应给页面
				response.addCookie(depositusername);
				response.addCookie(depositpassword);
			}

			// 使用session作用域,目的为了修改密码等信息
			HttpSession session = request.getSession();
			session.setAttribute("operator", operator);
			return Action.SUCCESS;
		} else {
			System.out.println("账号或密码错误");
			request.setAttribute("arr", "账号或密码错误");
			return "error";
		}
	}

	public OperatorVo getOperatorVo() {
		return operatorVo;
	}

	public void setOperatorVo(OperatorVo operatorVo) {
		this.operatorVo = operatorVo;
	}

	@Override
	public OperatorVo getModel() {
		return operatorVo = new OperatorVo();
	}

}
