package com.whsxt.dao;

import java.util.List;
/**
 * 公共类
 * @author pc
 *
 */
public interface BaseDao {
	void add(Object object);

	void del(Object object);

	void update(Object object);

	List<Object> query(Object object);
}
