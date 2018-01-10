package cn.whsxt.car.vo;

import cn.whsxt.car.pojo.Role;

public class RoleVo extends Role {
	//这里的两个词不能更换,要与easyUI匹配
	private Integer page;//当前页
	private Integer rows;//每页显示条数
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
}
