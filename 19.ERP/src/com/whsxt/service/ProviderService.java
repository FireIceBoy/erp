package com.whsxt.service;

import java.util.List;

import com.whsxt.pojo.Provider;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.ProviderVo;

public interface ProviderService {
	void add(Provider provider);

	void del(int id);

	void update(Provider provider);

	List<Provider> query(PageBean pageBean, ProviderVo providerVo);

	ProviderVo queryById(int id);
}
