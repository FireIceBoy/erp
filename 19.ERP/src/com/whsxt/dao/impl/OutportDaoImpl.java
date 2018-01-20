package com.whsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.whsxt.dao.OutportDao;
import com.whsxt.pojo.Goods;
import com.whsxt.pojo.Outport;
import com.whsxt.pojo.Provider;
import com.whsxt.utils.DBUtils;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.OutportVo;

public class OutportDaoImpl implements OutportDao {

	/**
	 * 进货
	 */
	@Override
	public void add(Outport outport) {
		String sql = "insert into tb_outport(providerid, paytype, outputtime, operateperson, number, comment, goodsid) values(?, ? , ? , ? , ? , ? , ?)";
		Object[] objs = { outport.getProvider().getPid(), outport.getPaytype(),
				outport.getOutputtime(), outport.getOperateperson(),
				outport.getNumber(), outport.getComment(),
				outport.getGoods().getGid() };
		DBUtils.executeUpdate(sql, objs);
	}

	@Override
	public void del(int id) {
		String sql = "delete from tb_outport where id = ?";
		Object[] objs = { id };
		DBUtils.executeUpdate(sql, objs);
	}

	@Override
	public List<Outport> query(PageBean pageBean, OutportVo outportVo) {
		pageBean.setTotalCount(this.getTotalCount(outportVo));
		List<Outport> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder(
				"select i.*, g.goodsname, p.providername  from tb_outport i, tb_goods g, tb_provider p where i.goodsid = g.gid and i.providerid = p.pid and (p.providername like ? or g.goodsname like ? or i.operateperson like ?)");
		Object[] objs = new Object[7];
		objs[0] = "%" + outportVo.getKeywords() + "%";
		objs[1] = "%" + outportVo.getKeywords() + "%";
		objs[2] = "%" + outportVo.getKeywords() + "%";
		if (null != outportVo.getBegintime()) {
			// 填写了起始时间
			sql.append(" and i.outputtime > ? ");
			objs[3] = outportVo.getBegintime();
			if (null != outportVo.getEndtime()) {
				// 填写了截止时间
				sql.append(" and i.outputtime < ? ");
				objs[4] = outportVo.getBegintime();
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
			if (null != outportVo.getEndtime()) {
				// 填写了截止时间
				sql.append(" and i.outputtime < ? ");
				objs[3] = outportVo.getBegintime();
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
				Timestamp outputtime = rs.getTimestamp("outputtime");
				String operateperson = rs.getString("operateperson");
				int number = rs.getInt("number");
				String comment = rs.getString("comment");
				int goodsid = rs.getInt("goodsid");
				String goodsname = rs.getString("goodsname");
				String providername = rs.getString("providername");
				list.add(new Outport(id, paytype, outputtime, operateperson,
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
	public int getTotalCount(OutportVo outportVo) {
		int totalCount = 0;
		StringBuilder sql = new StringBuilder(
				"select count(*)  from tb_outport i, tb_goods g, tb_provider p where i.goodsid = g.gid and i.providerid = p.pid and (p.providername like ? or g.goodsname like ? or i.operateperson like ?)");
		Object[] objs = new Object[5];
		objs[0] = "%" + outportVo.getKeywords() + "%";
		objs[1] = "%" + outportVo.getKeywords() + "%";
		objs[2] = "%" + outportVo.getKeywords() + "%";
		if (null != outportVo.getBegintime()) {
			// 填写了起始时间
			sql.append(" and i.outputtime > ? ");
			objs[3] = outportVo.getBegintime();
			if (null != outportVo.getEndtime()) {
				// 填写了截止时间
				sql.append(" and i.outputtime < ? ");
				objs[4] = outportVo.getBegintime();
			}
		} else {
			// 未填写起始时间
			if (null != outportVo.getEndtime()) {
				// 填写了截止时间
				sql.append(" and i.outputtime < ? ");
				objs[3] = outportVo.getBegintime();
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
	public List<Outport> queryByGid(int gid) {
		List<Outport> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder(
				"select o.id, o.number, o.outputtime from tb_outport o where o.goodsid = ?");
		Object[] objs = {gid};
		Connection conn = DBUtils.getConnection();
		PreparedStatement ps = DBUtils.getPreparedStatement(conn,
				sql.toString(), objs);
		ResultSet rs = DBUtils.getResultSet(ps);
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				Timestamp outputtime = rs.getTimestamp("outputtime");
				int number = rs.getInt("number");
				list.add(new Outport(id, outputtime, number));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
