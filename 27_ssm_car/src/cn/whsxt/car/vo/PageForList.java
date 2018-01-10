package cn.whsxt.car.vo;

import java.util.List;

public class PageForList {
	private Long total;//总条数
	private List<?> rows;//展示数据
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}
