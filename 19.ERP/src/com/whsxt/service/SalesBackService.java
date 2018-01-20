package com.whsxt.service;

import java.util.List;

import com.whsxt.pojo.SalesBack;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.SalesBackVo;

public interface SalesBackService {

	/**
	 * 查询销售列表
	 */
	List<SalesBack> query(PageBean pageBean, SalesBackVo salesBackVo);

	/**
	 * 添加销售记录
	 */
	void add(SalesBack SalesBack);
	
	
	
}
