package cn.whsxt.car.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CustomInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		/*//获取请求的名称
		String url = request.getRequestURI();
		//加载openlyUrl(可以公开访问的url路径)文件,获取所有可以公开访问(不要登录就可以访问)的url链接
		List<String> anonymousList = ResourcesUtil.getkeyList("anonymousURL");
		for (String str : anonymousList) {
			//判断url内是否包含公共访问的链接名
			if(url.indexOf(str) != -1 ) {
				return true;
			}
		}
		
		//获取session中的用户对象
		ActiveUser user = (ActiveUser) request.getSession().getAttribute("user");
		//判断userVo是否为空
		if(user != null) {//已经登录
			//判断当前访问权限是否为公开资源(公开资源就是只要登录就可以访问的资源)
			List<String> commonURL = ResourcesUtil.getkeyList("commonURL");
			for (String str : commonURL) {
				if(url.indexOf(str) != -1) {//如果为公共资源就可以访问
					return true;
				}
			}
			
			//如果资源既不是公共的资源,又不是公开的资源,判断用户是否授权该url
			//获取当前用户已授权链接列表
			List<Menu> list = user.getList();
			for (Menu menu : list) {
				if(url.indexOf(menu.getUrl()) != -1) {//该用户有访问权限
					return true;
				}
			}
			//请求转发到登录界面
			request.setAttribute("error", "您没有权限访问");
			request.getRequestDispatcher("toPromt").forward(request, response);
			return false;
		}
		//请求转发到登录界面
		request.getRequestDispatcher("toLogin").forward(request, response);
		return false;*/
		return true;
	}

}
