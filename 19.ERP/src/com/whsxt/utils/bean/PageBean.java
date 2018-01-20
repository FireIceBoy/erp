package com.whsxt.utils.bean;

public class PageBean {
	private int currentPage;// 当前页
	private int pageSize = 5;// 每页显示条数
	private int totalCount;// 总条数
	private int totalPage;// 总页数

	public PageBean() {
		super();
	}

	public PageBean(int currentPage) {
		super();
		this.currentPage = currentPage;
	}

	public PageBean(int currentPage, int pageSize, int totalCount, int totalPage) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.totalPage = (int) Math.ceil(this.totalCount * 1.0 / this.pageSize);
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", pageSize="
				+ pageSize + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + "]";
	}
	
	
}
