package com.whsxt.action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.whsxt.pojo.Goods;
import com.whsxt.pojo.Inport;
import com.whsxt.pojo.Outport;
import com.whsxt.service.GoodsService;
import com.whsxt.service.impl.GoodsServiceImpl;
import com.whsxt.service.impl.InportServiceImpl;
import com.whsxt.service.impl.OutportServiceImpl;
import com.whsxt.vo.GoodsVo;
/**
 * json专用
 * @author pc
 */
public class GoodsNameAction {

	// 服务层
	GoodsService goodsService = new GoodsServiceImpl();

	private int pid;
	private List<Goods> list;
	private GoodsVo goodsVo;
	private List<Inport> listInports;
	private List<Outport> listOutports;

	public String query() {
		// 
		list = this.goodsService.queryByPid(pid);
		return Action.SUCCESS;
	}

	// 查询所有商品对象
	public String queryAllGoods() {
		list = goodsService.query();
		return Action.SUCCESS;
	}

	// 根据gid获取商品的进货记录
	public String queryInport() {
		listInports = new InportServiceImpl().queryByGid(goodsVo.getGid());
		return "listInports";
	}
	
	// 根据gid获取商品的出货记录
		public String queryOutport() {
			listOutports = new OutportServiceImpl().queryByGid(goodsVo.getGid());
			return "listOutports";
		}

	public String queryGoods() {
		goodsVo = goodsService.queryById(goodsVo.getGid());
		return "goods";
	}

	public GoodsVo getGoodsVo() {
		return goodsVo;
	}

	public void setGoodsVo(GoodsVo goodsVo) {
		this.goodsVo = goodsVo;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public List<Goods> getList() {
		return list;
	}

	public void setList(List<Goods> list) {
		this.list = list;
	}

	public List<Inport> getListInports() {
		return listInports;
	}

	public void setListInports(List<Inport> listInports) {
		this.listInports = listInports;
	}

	public List<Outport> getListOutports() {
		return listOutports;
	}

	public void setListOutports(List<Outport> listOutports) {
		this.listOutports = listOutports;
	}
	
}
