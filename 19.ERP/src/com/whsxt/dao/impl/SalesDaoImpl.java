package com.whsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.whsxt.dao.SalesDao;
import com.whsxt.pojo.Customer;
import com.whsxt.pojo.Goods;
import com.whsxt.pojo.Operator;
import com.whsxt.pojo.Sales;
import com.whsxt.utils.DBUtils;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.SalesVo;

public class SalesDaoImpl implements SalesDao {

	/**
	 * 全查询
	 */
	public List<Sales> query(PageBean pageBean, SalesVo salesVo) {
		List<Sales> list = new ArrayList<>();
		int totalCount = querySalesCount(salesVo);
		// 把总条数设置进分页实体类
		pageBean.setTotalCount(totalCount);
		String sql = "";
		Object[] objs = {};
		// 判断，售货员为空，时间为空，就全查询
		if (salesVo.getOperator().getName().equals("")
				&& salesVo.getStime().equals("")
				&& salesVo.getEtime().equals("")) {
			sql = "SELECT s.*,c.customername,g.goodsname FROM tb_sales s,tb_customer c,tb_goods g WHERE s.customerid = c.cid and s.goodsid = g.gid limit ?,?";
			Object[] temp = {
					(pageBean.getCurrentPage() - 1) * pageBean.getPageSize(),
					pageBean.getPageSize() };
			objs = temp;
		} else {
			// 判断时间是否为空,为空，按照售货员查
			if (salesVo.getStime().equals("") && salesVo.getEtime().equals("")) {
				sql = "SELECT s.*,c.customername,g.goodsname FROM tb_sales s,tb_customer c,tb_goods g WHERE s.operateperson LIKE ? and s.customerid = c.cid and s.goodsid = g.gid limit ?,?";
				Object[] temp = {
						"%" + salesVo.getOperator().getName() + "%",
						(pageBean.getCurrentPage() - 1)
								* pageBean.getPageSize(),
						pageBean.getPageSize() };
				objs = temp;
			} else {
				if (salesVo.getOperator().getName().equals("")) { // 判断售货员是否为空，为空，按照时间查
					sql = "SELECT s.*,c.customername,g.goodsname FROM tb_sales s,tb_customer c,tb_goods g WHERE DATE_FORMAT(s.salestime,'%Y-%m-%d %H:%i:%S') >= ? and DATE_FORMAT(s.salestime,'%Y-%m-%d ') <= ? and s.customerid = c.cid and s.goodsid = g.gid limit ?,?";
					Object[] temp = {
							salesVo.getStime(),
							salesVo.getEtime(),
							(pageBean.getCurrentPage() - 1)
									* pageBean.getPageSize(),
							pageBean.getPageSize() };
					objs = temp;
				} else { // 都不为空
					sql = "SELECT s.*,c.customername,g.goodsname FROM tb_sales s,tb_customer c,tb_goods g WHERE DATE_FORMAT(s.salestime,'%Y-%m-%d %H:%i:%S') >= ? and DATE_FORMAT(s.salestime,'%Y-%m-%d ') <= ? and s.operateperson LIKE ? and s.customerid = c.cid and s.goodsid = g.gid limit ?,?";
					Object[] temp = {
							salesVo.getStime(),
							salesVo.getEtime(),
							"%" + salesVo.getOperator().getName() + "%",
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
				Timestamp salestime = (Timestamp) rs.getObject("salestime"); //
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
				Sales sales = new Sales(id, customer, paytype, salestime,
						operator, number, comment, goods);
				list.add(sales);

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
	public int querySalesCount(SalesVo salesVo) {
		int count = 0;
		String sql = "";
		Object[] objs = {};
		// 判断，售货员为空，时间为空，就全查询
		if (salesVo.getOperator().getName().equals("")
				&& salesVo.getStime().equals("")
				&& salesVo.getEtime().equals("")) {
			sql = "SELECT count(*) FROM tb_sales s,tb_customer c,tb_goods g  WHERE  s.customerid = c.cid and s.goodsid = g.gid  ";
			Object[] temp = { null };
			objs = temp;
		} else {
			// 判断时间是否为空,为空，按照售货员查
			if (salesVo.getStime().equals("") && salesVo.getEtime().equals("")) {
				sql = "SELECT count(*) FROM tb_sales s,tb_customer c,tb_goods g where operateperson like ? and s.customerid = c.cid and s.goodsid = g.gid";
				Object[] temp = { "%" + salesVo.getOperator().getName() + "%" };
				objs = temp;
			} else {
				if (salesVo.getOperator().getName().equals("")) { // 判断售货员是否为空，为空，按照时间查
					sql = "SELECT count(*) FROM tb_sales s,tb_customer c,tb_goods g WHERE DATE_FORMAT(s.salestime,'%Y-%m-%d') >= ? AND DATE_FORMAT(s.salestime,'%Y-%m-%d') <= ? and s.customerid = c.cid and s.goodsid = g.gid";
					Object[] temp = { salesVo.getStime(), salesVo.getEtime() };
					objs = temp;
				} else { // 都不为空
					sql = "SELECT count(*) FROM tb_sales s,tb_customer c,tb_goods g WHERE DATE_FORMAT(s.salestime,'%Y-%m-%d') >= ? AND DATE_FORMAT(s.salestime,'%Y-%m-%d') <= ? AND s.operateperson like ? and s.customerid = c.cid and s.goodsid = g.gid";
					Object[] temp = { salesVo.getStime(), salesVo.getEtime(),
							"%" + salesVo.getOperator().getName() + "%" };
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
	public void add(Sales sales) {
		String sql = "INSERT into tb_sales(customerid,paytype,salestime,operateperson,number,`comment`,goodsid) VALUES(?,?,?,?,?,?,?)";
		Object[] obj = { sales.getCustomer().getCid(), sales.getPaytype(),
				sales.getSalestime(), sales.getOperator().getName(),
				sales.getNumber(), sales.getComment(),
				sales.getGoods().getGid() };
		DBUtils.executeUpdate(sql, obj);
	}

	/**
	 * 根据id查出销售信息
	 */
	public Sales queryById(int id) {
		Sales sales = null;
		String sql = "SELECT s.*,c.customername,g.goodsname FROM tb_sales s,tb_customer c,tb_goods g WHERE s.customerid = c.cid and s.goodsid = g.gid and s.id = ?";
		Object[] objs = { id };
		Connection conn = DBUtils.getConnection();
		PreparedStatement prep = DBUtils.getPreparedStatement(conn, sql, objs);
		ResultSet rs = DBUtils.getResultSet(prep);
		// 处理结果集
		try {
			while (rs.next()) {
				int sid = (int) rs.getObject("id");
				int customerid = (int) rs.getObject("customerid");
				String customername = (String) rs.getObject("customername");
				String paytype = (String) rs.getObject("paytype"); //
				Timestamp salestime = (Timestamp) rs.getObject("salestime"); //
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
				sales = new Sales(sid, customer, paytype, salestime, operator,
						number, comment, goods);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// 关闭连接
		DBUtils.close(rs);
		DBUtils.close(prep);
		DBUtils.close(conn);

		return sales;
	}

	@Override
	public void update(Sales sales) {
		String sql = "update tb_sales set customerid=?,paytype=?,salestime=?,operateperson=?,number=?,`comment`=?,goodsid=? where id =?";
		Object[] objs = { sales.getCustomer().getCid(), sales.getPaytype(),
				sales.getSalestime(), sales.getOperator().getName(),
				sales.getNumber(), sales.getComment(),sales.getGoods().getGid(),sales.getId() };
		DBUtils.executeUpdate(sql, objs);
	}

}
