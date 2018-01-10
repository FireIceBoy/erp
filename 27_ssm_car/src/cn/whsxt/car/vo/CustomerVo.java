package cn.whsxt.car.vo;

import cn.whsxt.car.pojo.Customers;

public class CustomerVo extends Customers {

	private Integer page = 1;
	private Integer rows = 10;

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
