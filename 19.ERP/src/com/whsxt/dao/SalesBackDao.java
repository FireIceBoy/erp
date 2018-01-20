package com.whsxt.dao;

import java.util.List;

import com.whsxt.pojo.SalesBack;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.SalesBackVo;

/**
 * 销售退货表，操作数据库接口
 * 
 * @author 金诚
 */
public interface SalesBackDao {

	/**
	 * 查询退货列表
	 */
	List<SalesBack> query(PageBean pageBean, SalesBackVo salesBackVo);

	/**
	 * 添加退货记录
	 */
	void add(SalesBack sales);

}
