package com.whsxt.dao;

import java.util.List;

import com.whsxt.pojo.Provider;
import com.whsxt.utils.bean.PageBean;

public interface ProviderDao {

	void add(Provider provider);

	void del(int id);

	void update(Provider provider);

	List<Provider> query(PageBean pageBean, Provider provider);

	Provider queryById(int id);
}
