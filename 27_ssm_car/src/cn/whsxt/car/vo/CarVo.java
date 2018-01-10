package cn.whsxt.car.vo;

import org.springframework.web.multipart.MultipartFile;

import cn.whsxt.car.pojo.Car;

public class CarVo extends Car {
	private Integer page;
	private Integer rows;
	private MultipartFile file;
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
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
