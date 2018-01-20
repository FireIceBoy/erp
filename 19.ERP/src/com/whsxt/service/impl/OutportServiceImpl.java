package com.whsxt.service.impl;

import java.util.List;

import com.whsxt.dao.GoodsDao;
import com.whsxt.dao.OutportDao;
import com.whsxt.dao.impl.GoodsDaoImpl;
import com.whsxt.dao.impl.OutportDaoImpl;
import com.whsxt.pojo.Goods;
import com.whsxt.pojo.Inport;
import com.whsxt.pojo.Outport;
import com.whsxt.service.InportService;
import com.whsxt.service.OutportService;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.OutportVo;

public class OutportServiceImpl implements OutportService {

	private OutportDao outportDao = new OutportDaoImpl();
	private GoodsDao goodsDao = new GoodsDaoImpl();
	private Goods goods = new Goods();
	private InportService inportService = new InportServiceImpl();
	private Inport inport = new Inport();

	@Override
	public void add(Outport outport, int outportId) {
		// 进货需要修改商品表内的数量
		goods = goodsDao.queryById(outport.getGoods().getGid());
		goods.setNumber(goods.getNumber() - outport.getNumber());
		goodsDao.update(goods);
		//修改进货表内的进货数量
		inport = inportService.queryById(outportId);
		inport.setNumber(inport.getNumber()-outport.getNumber());
		inportService.update(inport);
		outport.setGoods(goods);
		outport.setProvider(goods.getProvider());
		outportDao.add(outport);
	}

	@Override
	public void del(int id) {
		outportDao.del(id);
	}

	@Override
	public List<Outport> query(PageBean pageBean, OutportVo outportVo) {
		if (null == outportVo.getKeywords()) {
			outportVo.setKeywords("");
		}
		// 判断当前页是否为0
		if (0 == pageBean.getCurrentPage()) {
			pageBean.setCurrentPage(1);
		}
		return outportDao.query(pageBean, outportVo);
	}

	@Override
	public List<Outport> queryByGid(int gid) {
		return outportDao.queryByGid(gid);
	}

}
