package com.whsxt.service.impl;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.whsxt.dao.GoodsDao;
import com.whsxt.dao.InportDao;
import com.whsxt.dao.impl.GoodsDaoImpl;
import com.whsxt.dao.impl.InportDaoImpl;
import com.whsxt.pojo.Goods;
import com.whsxt.pojo.Inport;
import com.whsxt.service.InportService;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.InportVo;

public class InportServiceImpl implements InportService {

	private InportDao inportDao = new InportDaoImpl();
	private GoodsDao goodsDao = new GoodsDaoImpl();
	private Goods goods = new Goods();

	@Override
	public void add(Inport inport) {
		// 进货需要修改商品表内的数量
		goods = goodsDao.queryById(inport.getGoods().getGid());
		goods.setNumber(goods.getNumber() + inport.getNumber());
		goodsDao.update(goods);
		inportDao.add(inport);
	}

	@Override
	public void del(int id) {
		inportDao.del(id);
	}
	
	@Override
	public void update(Inport inport) {
		inportDao.update(inport);
	}

	@Override
	public List<Inport> query(PageBean pageBean, InportVo inportVo) {
		if (null == inportVo.getKeywords()) {
			inportVo.setKeywords("");
		}
		// 判断当前页是否为0
		if (0 == pageBean.getCurrentPage()) {
			pageBean.setCurrentPage(1);
		}
		/*
		 * Inport inport = new Inport();
		 * //注册sql.date的转换器，即允许BeanUtils.copyProperties时的源目标的sql类型的值允许为空
		 * ConvertUtils.register(new SqlTimeConverter(null), Timestamp.class);
		 * try { //用BeanUtils复制Timestamp属性时如果为null 会导致No value specified异常。
		 * BeanUtils.copyProperties(inport, inportVo); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
		return inportDao.query(pageBean, inportVo);
	}

	@Override
	public InportVo queryById(int id) {
		InportVo inportVo = new InportVo();
		try {
			BeanUtils.copyProperties(inportVo, inportDao.queryById(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inportVo;
	}

	@Override
	public List<Inport> queryByGid(int gid) {
		return inportDao.queryByGid(gid);
	}

}
