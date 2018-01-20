package com.whsxt.service.impl;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.whsxt.dao.ProviderDao;
import com.whsxt.dao.impl.ProviderDaoImpl;
import com.whsxt.pojo.Provider;
import com.whsxt.service.ProviderService;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.ProviderVo;

public class ProviderServiceImpl implements ProviderService {

	private ProviderDao providerDao = new ProviderDaoImpl();

	@Override
	public void add(Provider provider) {
		providerDao.add(provider);
	}

	@Override
	public void del(int id) {
		providerDao.del(id);
	}

	@Override
	public void update(Provider provider) {
		providerDao.update(provider);
	}

	@Override
	public List<Provider> query(PageBean pageBean, ProviderVo providerVo) {
		// 判断当前页是否为0
		if (0 == pageBean.getCurrentPage()) {
			pageBean.setCurrentPage(1);
		}
		// 判断供应商是否为空
		if (null == providerVo.getProvidername()) {
			providerVo.setProvidername("");
		}
		// 判断keywords是否为空
		if (null == providerVo.getKeywords()) {
			providerVo.setKeywords("");
		}
		return providerDao.query(pageBean, providerVo);
	}

	@Override
	public ProviderVo queryById(int id) {
		ProviderVo providerVo = new ProviderVo();
		try {
			BeanUtils.copyProperties(providerVo, providerDao.queryById(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return providerVo;
	}

}
