package cn.whsxt.car.vo;

import cn.whsxt.car.pojo.User;

public class UserVo extends User {
	// 这里的两个词不能更换,要与easyUI匹配
	private Integer page;// 当前页
	private Integer rows;// 每页显示条数
	private Integer pmid;

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

	public Integer getPmid() {
		return pmid;
	}

	public void setPmid(Integer pmid) {
		this.pmid = pmid;
	}
}
