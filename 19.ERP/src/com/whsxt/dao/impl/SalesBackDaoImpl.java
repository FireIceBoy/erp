package com.whsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.whsxt.dao.SalesBackDao;
import com.whsxt.pojo.Customer;
import com.whsxt.pojo.Goods;
import com.whsxt.pojo.Operator;
import com.whsxt.pojo.SalesBack;
import com.whsxt.utils.DBUtils;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.SalesBackVo;

public class SalesBackDaoImpl implements SalesBackDao {

	/**
	 * 全查询
	 */
	public List<SalesBack> query(PageBean pageBean, SalesBackVo salesBackVo) {
		List<SalesBack> list = new ArrayList<>();
		int totalCount = querySalesCount(salesBackVo);
		// 把总条数设置进分页实体类
		pageBean.setTotalCount(totalCount);
		String sql = "";
		Object[] objs = {};
		// 判断，售货员为空，时间为空，就全查询
		if (salesBackVo.getOperator().getName().equals("")
				&& salesBackVo.getStime().equals("")
				&& salesBackVo.getEtime().equals("")) {
			sql = "SELECT s.*,c.customername,g.goodsname FROM tb_salesback s,tb_customer c,tb_goods g WHERE s.customerid = c.cid and s.goodsid = g.gid limit ?,?";
			Object[] temp = { 
					(pageBean.getCurrentPage() - 1) * pageBean.getPageSize(),
					pageBean.getPageSize() };
			objs = temp;
		} else {
			// 判断时间是否为空,为空，按照售货员查
			if (salesBackVo.getStime().equals("") && salesBackVo.getEtime().equals("")) {
				sql = "SELECT s.*,c.customername,g.goodsname FROM tb_salesback s,tb_customer c,tb_goods g WHERE s.operateperson LIKE ? and s.customerid = c.cid and s.goodsid = g.gid limit ?,?";
				Object[] temp = {
						"%" + salesBackVo.getOperator().getName() + "%",
						(pageBean.getCurrentPage() - 1)
								* pageBean.getPageSize(),
						pageBean.getPageSize() };
				objs = temp;
			} else {
				if (salesBackVo.getOperator().getName().equals("")) { // 判断售货员是否为空，为空，按照时间查
					sql = "SELECT s.*,c.customername,g.goodsname FROM tb_salesback s,tb_customer c,tb_goods g WHERE DATE_FORMAT(s.salesbacktime,'%Y-%m-%d %H:%i:%S') >= ? and DATE_FORMAT(s.salesbacktime,'%Y-%m-%d ') <= ? and s.customerid = c.cid and s.goodsid = g.gid limit ?,?";
					Object[] temp = {
							salesBackVo.getStime()  ,
							salesBackVo.getEtime() ,
							(pageBean.getCurrentPage() - 1)
									* pageBean.getPageSize(),
							pageBean.getPageSize() };
					objs = temp;
				} else { // 都不为空
					sql = "SELECT s.*,c.customername,g.goodsname FROM tb_salesback s,tb_customer c,tb_goods g WHERE DATE_FORMAT(s.salesbacktime,'%Y-%m-%d %H:%i:%S') >= ? and DATE_FORMAT(s.salesbacktime,'%Y-%m-%d ') <= ? and s.operateperson LIKE ? and s.customerid = c.cid and s.goodsid = g.gid limit ?,?";
					Object[] temp = {
							salesBackVo.getStime() ,
							salesBackVo.getEtime() ,
							"%" + salesBackVo.getOperator().getName() + "%",
							(pageBean.getCurrentPage() - 1)
									* pageBean.getPageSize(),
							pageBean.getPageSize() };
					objs = temp;
				}
			}

		}
		Connection conn = DBUtils.getConnection();
		PreparedStatement prep = DBUtils.getPreparedStatement(conn, sql, objs);
		ResultSet rs = DBUtils.getResultSet(prep);
		// 处理结果集
		try {
			while (rs.next()) {
				int id = (int) rs.getObject("id");
				int customerid = (int) rs.getObject("customerid");
				String customername = (String) rs.getObject("customername");
				String paytype = (String) rs.getObject("paytype"); //
				Timestamp salesbacktime = (Timestamp) rs.getObject("salesbacktime"); //
				String name = (String) rs.getObject("operateperson"); //
				int number = (int) rs.getObject("number");
				String comment = (String) rs.getObject("comment"); //
				int goodsid = (int) rs.getObject("goodsid");
				String goodsname = (String) rs.getObject("goodsname");

				// 封装
				Customer customer = new Customer(customerid, customername);
				Goods goods = new Goods(goodsid, goodsname);
				Operator operator = new Operator(name);

				// 封装商品
				SalesBack salesBack = new SalesBack(id, customer, paytype, salesbacktime,
						operator, number, comment, goods);
				list.add(salesBack);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// 关闭连接
		DBUtils.close(rs);
		DBUtils.close(prep);
		DBUtils.close(conn);

		return list;
	}

	/**
	 * 查询条数
	 */
	public int querySalesCount(SalesBackVo salesBackVo) {
		int count = 0;
		String sql = "";
		Object[] objs = {};
		// 判断，售货员为空，时间为空，就全查询
		if (salesBackVo.getOperator().getName().equals("")
				&& salesBackVo.getStime().equals("")
				&& salesBackVo.getEtime().equals("")) {
			sql = "SELECT count(*) FROM tb_salesback s,tb_customer c,tb_goods g WHERE s.customerid = c.cid and s.goodsid = g.gid";
			Object[] temp = { null };
			objs = temp;
		} else {
			// 判断时间是否为空,为空，按照售货员查
			if (salesBackVo.getStime().equals("") && salesBackVo.getEtime().equals("")) {
				sql = "SELECT count(*) FROM tb_salesback s,tb_customer c,tb_goods g WHERE  operateperson like ? and s.customerid = c.cid and s.goodsid = g.gid ";
				Object[] temp = { "%" + salesBackVo.getOperator().getName() + "%" };
				objs = temp;
			} else {
				if (salesBackVo.getOperator().getName().equals("")) { // 判断售货员是否为空，为空，按照时间查
					sql = "SELECT count(*) FROM tb_salesback s,tb_customer c,tb_goods g WHERE DATE_FORMAT(s.salesbacktime,'%Y-%m-%d') >= ? AND DATE_FORMAT(s.salesbacktime,'%Y-%m-%d') <= ? and s.customerid = c.cid and s.goodsid = g.gid";
					Object[] temp = {  salesBackVo.getStime() ,
							salesBackVo.getEtime()  };
					objs = temp;
				} else { // 都不为空
					sql = "SELECT count(*) FROM tb_salesback s,tb_customer c,tb_goods g WHERE DATE_FORMAT(s.salesbacktime,'%Y-%m-%d') >= ? AND DATE_FORMAT(s.salesbacktime,'%Y-%m-%d') <= ? AND s.operateperson like ? and s.customerid = c.cid and s.goodsid = g.gid";
					Object[] temp = {  salesBackVo.getStime() ,
							salesBackVo.getEtime() ,
							"%" + salesBackVo.getOperator().getName() + "%" };
					objs = temp;
				}
			}

		}
		Connection conn = DBUtils.getConnection();
		PreparedStatement prep = DBUtils.getPreparedStatement(conn, sql, objs);
		ResultSet rs = DBUtils.getResultSet(prep);
		try {
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 关闭连接
		DBUtils.close(rs);
		DBUtils.close(prep);
		DBUtils.close(conn);
		return count;
	}

	/**
	 * 添加,
	 */
	public void add(SalesBack salesBack) {
		String sql = "INSERT into tb_salesback(customerid,paytype,salesbacktime,operateperson,number,`comment`,goodsid) VALUES(?,?,?,?,?,?,?)";
		Object[] obj = {salesBack.getCustomer().getCid(),salesBack.getPaytype(),salesBack.getSalesbacktime(),salesBack.getOperator().getName(),salesBack.getNumber(),salesBack.getComment(),salesBack.getGoods().getGid()};
		DBUtils.executeUpdate(sql, obj);
	}

}
