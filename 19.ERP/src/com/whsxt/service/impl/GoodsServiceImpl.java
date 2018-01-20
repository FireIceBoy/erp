package com.whsxt.service.impl;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.whsxt.dao.GoodsDao;
import com.whsxt.dao.impl.GoodsDaoImpl;
import com.whsxt.pojo.Goods;
import com.whsxt.service.GoodsService;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.GoodsVo;

public class GoodsServiceImpl implements GoodsService {

	// dao
	GoodsDao goodsDao = new GoodsDaoImpl();

	@Override
	public void add(Goods goods) {
		goodsDao.add(goods);

	}

	@Override
	public void del(int id) {
		goodsDao.del(id);
	}

	@Override
	public void update(Goods goods) {
		goodsDao.update(goods);
	}

	@Override
	public List<Goods> query(PageBean pageBean, GoodsVo goodsVo) {
		// 判断当前页是否为0
		if (0 == pageBean.getCurrentPage()) {
			pageBean.setCurrentPage(1);
		}
		// 判断商品名称是否为空
		if (null == goodsVo.getGoodsname()) {
			goodsVo.setGoodsname("");
		}

		// 判断商品产地是否为空
		if (null == goodsVo.getProduceplace()) {
			goodsVo.setProduceplace("");
		}

		return goodsDao.query(pageBean, goodsVo);
	}

	@Override
	public GoodsVo queryById(int id) {
		Goods goods = goodsDao.queryById(id);
		GoodsVo vo = new GoodsVo();
		try {
			BeanUtils.copyProperties(vo, goods);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<Goods> queryByPid(int id) {
		return goodsDao.queryByPid(id);
	}

	@Override
	public List<Goods> query() {
		return goodsDao.query();
	}

}
