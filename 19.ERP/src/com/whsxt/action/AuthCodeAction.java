package com.whsxt.action;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.whsxt.utils.AuthCodeUtils;

public class AuthCodeAction {
	public String authCode() throws IOException {
		String code = AuthCodeUtils.getCode();
		ServletActionContext.getRequest().getSession().setAttribute("code", code);
		HttpServletResponse response = ServletActionContext.getResponse();
		BufferedImage img = AuthCodeUtils.getAuthCodeImg(code);
		ImageIO.write(img, "JPEG", response.getOutputStream());
		return Action.NONE;
	}

}
