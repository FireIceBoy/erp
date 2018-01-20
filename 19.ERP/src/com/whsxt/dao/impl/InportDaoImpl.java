package com.whsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.whsxt.dao.InportDao;
import com.whsxt.pojo.Goods;
import com.whsxt.pojo.Inport;
import com.whsxt.pojo.Provider;
import com.whsxt.utils.DBUtils;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.InportVo;

public class InportDaoImpl implements InportDao {

	/**
	 * 进货
	 */
	@Override
	public void add(Inport inport) {
		String sql = "insert into tb_inport(providerid, paytype, inporttime, operateperson, number, comment, goodsid) values(?, ? , ? , ? , ? , ? , ?)";
		Object[] objs = { inport.getProvider().getPid(), inport.getPaytype(),
				inport.getInporttime(), inport.getOperateperson(),
				inport.getNumber(), inport.getComment(),
				inport.getGoods().getGid() };
		DBUtils.executeUpdate(sql, objs);
	}

	@Override
	public void del(int id) {
		String sql = "delete from tb_inport where id = ?";
		Object[] objs = { id };
		DBUtils.executeUpdate(sql, objs);
	}

	@Override
	public void update(Inport inport) {
		String sql = "update tb_inport set providerid=?, paytype=?, inporttime=?, operateperson=?, number=?, comment=?, goodsid=? where id = ?";
		Object[] objs = { inport.getProvider().getPid(), inport.getPaytype(),
				inport.getInporttime(), inport.getOperateperson(),
				inport.getNumber(), inport.getComment(),
				inport.getGoods().getGid(), inport.getId() };
		DBUtils.executeUpdate(sql, objs);
	}

	/**
	 * 根据商品编号查询进货记录
	 */
	@Override
	public List<Inport> queryByGid(int gid) {
		List<Inport> list = new ArrayList<>();
		String sql = "select i.id, i.inporttime, i.number from tb_inport i where i.goodsid=?";
		Object[] objs = { gid };
		Connection conn = DBUtils.getConnection();
		PreparedStatement ps = DBUtils.getPreparedStatement(conn,
				sql.toString(), objs);
		ResultSet rs = DBUtils.getResultSet(ps);
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				Timestamp inporttime = rs.getTimestamp("inporttime");
				int number = rs.getInt("number");
				list.add(new Inport(id, inporttime, number));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Inport> query(PageBean pageBean, InportVo inportVo) {
		pageBean.setTotalCount(this.getTotalCount(inportVo));
		List<Inport> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder(
				"select i.*, g.goodsname, p.providername  from tb_inport i, tb_goods g, tb_provider p where i.goodsid = g.gid and i.providerid = p.pid and (p.providername like ? or g.goodsname like ? or i.operateperson like ?)");
		Object[] objs = new Object[7];
		objs[0] = "%" + inportVo.getKeywords() + "%";
		objs[1] = "%" + inportVo.getKeywords() + "%";
		objs[2] = "%" + inportVo.getKeywords() + "%";
		if (null != inportVo.getBegintime()) {
			// 填写了起始时间
			sql.append(" and i.inporttime > ? ");
			objs[3] = inportVo.getBegintime();
			if (null != inportVo.getEndtime()) {
				// 填写了截止时间
				sql.append(" and i.inporttime < ? ");
				objs[4] = inportVo.getBegintime();
				objs[5] = (pageBean.getCurrentPage() - 1)
						* pageBean.getPageSize();
				objs[6] = pageBean.getPageSize();
			} else {
				// 未填写了截止时间
				objs[4] = (pageBean.getCurrentPage() - 1)
						* pageBean.getPageSize();
				objs[5] = pageBean.getPageSize();
			}
		} else {
			// 未填写起始时间
			if (null != inportVo.getEndtime()) {
				// 填写了截止时间
				sql.append(" and i.inporttime < ? ");
				objs[3] = inportVo.getBegintime();
				objs[4] = (pageBean.getCurrentPage() - 1)
						* pageBean.getPageSize();
				objs[5] = pageBean.getPageSize();
			} else {
				// 未填写了截止时间
				objs[3] = (pageBean.getCurrentPage() - 1)
						* pageBean.getPageSize();
				objs[4] = pageBean.getPageSize();
			}
		}
		sql.append(" limit ?, ?");
		Connection conn = DBUtils.getConnection();
		PreparedStatement ps = DBUtils.getPreparedStatement(conn,
				sql.toString(), objs);
		ResultSet rs = DBUtils.getResultSet(ps);
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				int providerid = rs.getInt("providerid");
				int paytype = rs.getInt("paytype");
				Timestamp inporttime = rs.getTimestamp("inporttime");
				String operateperson = rs.getString("operateperson");
				int number = rs.getInt("number");
				String comment = rs.getString("comment");
				int goodsid = rs.getInt("goodsid");
				String goodsname = rs.getString("goodsname");
				String providername = rs.getString("providername");
				list.add(new Inport(id, paytype, inporttime, operateperson,
						number, comment,
						new Provider(providerid, providername), new Goods(
								goodsid, goodsname)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询数据条数
	 */
	public int getTotalCount(InportVo inportVo) {
		int totalCount = 0;
		StringBuilder sql = new StringBuilder(
				"select count(*)  from tb_inport i, tb_goods g, tb_provider p where i.goodsid = g.gid and i.providerid = p.pid and (p.providername like ? or g.goodsname like ? or i.operateperson like ?)");
		Object[] objs = new Object[5];
		objs[0] = "%" + inportVo.getKeywords() + "%";
		objs[1] = "%" + inportVo.getKeywords() + "%";
		objs[2] = "%" + inportVo.getKeywords() + "%";
		if (null != inportVo.getBegintime()) {
			// 填写了起始时间
			sql.append(" and i.inporttime > ? ");
			objs[3] = inportVo.getBegintime();
			if (null != inportVo.getEndtime()) {
				// 填写了截止时间
				sql.append(" and i.inporttime < ? ");
				objs[4] = inportVo.getBegintime();
			}
		} else {
			// 未填写起始时间
			if (null != inportVo.getEndtime()) {
				// 填写了截止时间
				sql.append(" and i.inporttime < ? ");
				objs[3] = inportVo.getBegintime();
			}
		}
		Connection conn = DBUtils.getConnection();
		PreparedStatement ps = DBUtils.getPreparedStatement(conn,
				sql.toString(), objs);
		ResultSet rs = DBUtils.getResultSet(ps);
		try {
			while (rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCount;
	}

	@Override
	public Inport queryById(int id) {
		Inport inport = null;
		String sql = "select i.*, g.goodsname, p.providername  from tb_inport i, tb_goods g, tb_provider p where i.goodsid = g.gid and i.providerid = p.pid and id = ?";
		Object[] objs = { id };
		Connection conn = DBUtils.getConnection();
		PreparedStatement ps = DBUtils.getPreparedStatement(conn, sql, objs);
		ResultSet rs = DBUtils.getResultSet(ps);
		try {
			if (rs.next()) {
				int providerid = rs.getInt("providerid");
				int paytype = rs.getInt("paytype");
				Timestamp inporttime = rs.getTimestamp("inporttime");
				String operateperson = rs.getString("operateperson");
				int number = rs.getInt("number");
				String comment = rs.getString("comment");
				int goodsid = rs.getInt("goodsid");
				String goodsname = rs.getString("goodsname");
				String providername = rs.getString("providername");
				inport = new Inport(id, paytype, inporttime, operateperson,
						number, comment,
						new Provider(providerid, providername), new Goods(
								goodsid, goodsname));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inport;
	}

}
