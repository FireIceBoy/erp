package com.whsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.whsxt.dao.GoodsDao;
import com.whsxt.pojo.Goods;
import com.whsxt.pojo.Provider;
import com.whsxt.utils.DBUtils;
import com.whsxt.utils.bean.PageBean;

/**
 * 商品操作数据库，实体类
 * 
 * @author 金诚
 * 
 */
public class GoodsDaoImpl extends BaseDaoImpl<Goods> implements GoodsDao {

	public void add(Goods goods) {
		String sql = "INSERT INTO tb_goods(goodsname,produceplace,size,gpackage,productcode,promitcode,description,price,providerid,available,number) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] objs = { goods.getGoodsname(), goods.getProduceplace(),
				goods.getSize(), goods.getGpackage(), goods.getProductcode(),
				goods.getPromitcode(), goods.getDescription(),
				goods.getPrice(), goods.getProvider().getPid(),
				goods.getAvailable(), goods.getNumber() };
		DBUtils.executeUpdate(sql, objs);
	}

	@Override
	public void del(int id) {
		String sql = "DELETE from tb_goods where gid = ?";
		Object[] objs = { id };
		DBUtils.executeUpdate(sql, objs);

	}

	@Override
	public void update(Goods goods) {
		String sql = "UPDATE tb_goods as g SET g.goodsname=?,g.produceplace=?,g.size=?,g.gpackage=?,g.productcode=?,g.promitcode=?,g.description=?,g.price=?,g.providerid=?,g.available=?,g.number=? WHERE g.gid = ?";
		Object[] objs = { goods.getGoodsname(), goods.getProduceplace(),
				goods.getSize(), goods.getGpackage(), goods.getProductcode(),
				goods.getPromitcode(), goods.getDescription(),
				goods.getPrice(), goods.getProvider().getPid(),
				goods.getAvailable(), goods.getNumber(), goods.getGid() };
		DBUtils.executeUpdate(sql, objs);
	}

	@Override
	public List<Goods> query() {
		List<Goods> list = new ArrayList<>();
		String sql = "select g.*, p.providername from tb_goods g,tb_provider p where g.providerid = p.pid";
		Connection conn = DBUtils.getConnection();
		PreparedStatement prep = DBUtils.getPreparedStatement(conn, sql, null);
		ResultSet rs = DBUtils.getResultSet(prep);
		// 处理结果集
		try {
			while (rs.next()) {
				int gid = (int) rs.getObject("gid");
				String goodsname = (String) rs.getObject("goodsname");
				String produceplace = (String) rs.getObject("produceplace");
				String size = (String) rs.getObject("size");
				String gpackage = (String) rs.getObject("gpackage");
				String productcode = (String) rs.getObject("productcode");
				String promitcode = (String) rs.getObject("promitcode");
				String description = (String) rs.getObject("description");
				double price = (double) rs.getObject("price");
				int providerid = (int) rs.getObject("providerid");
				int available = (int) rs.getObject("available");
				int number = (int) rs.getObject("number");
				String providername = (String) rs.getObject("providername");

				// 封装供应商
				Provider provider = new Provider(providerid, providername);

				// 封装商品
				Goods goodss = new Goods(gid, goodsname, produceplace, size,
						gpackage, productcode, promitcode, description, price,
						provider, available, number);
				list.add(goodss);

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

	@Override
	public List<Goods> query(PageBean pageBean, Goods goods) {
		List<Goods> list = new ArrayList<>();
		int totalCount = queryCustomerCount(goods);
		// 把总条数设置进分页实体类
		pageBean.setTotalCount(totalCount);
		String sql = "";
		Object[] objs = {};
		// 判断available是否选择,当值为8表示不做状态查询
		if (8 == goods.getAvailable()) {
			sql = "SELECT g.*,p.providername FROM tb_goods g,tb_provider p WHERE g.goodsname like ? and g.produceplace like ? and (g.providerid = p.pid) LIMIT ?,?";
			Object[] temp = { "%" + goods.getGoodsname() + "%",
					"%" + goods.getProduceplace() + "%",
					(pageBean.getCurrentPage() - 1) * pageBean.getPageSize(),
					pageBean.getPageSize() };
			objs = temp;
		} else {
			sql = "SELECT g.*,p.providername FROM tb_goods g,tb_provider p WHERE g.goodsname like ? and g.produceplace like ? and (g.available = ?) and (g.providerid = p.pid) LIMIT ?,?";
			Object[] temp = { "%" + goods.getGoodsname() + "%",
					"%" + goods.getProduceplace() + "%", goods.getAvailable(),
					(pageBean.getCurrentPage() - 1) * pageBean.getPageSize(),
					pageBean.getPageSize() };
			objs = temp;
		}

		Connection conn = DBUtils.getConnection();
		PreparedStatement prep = DBUtils.getPreparedStatement(conn, sql, objs);
		ResultSet rs = DBUtils.getResultSet(prep);

		// 处理结果集
		try {
			while (rs.next()) {
				int gid = (int) rs.getObject("gid");
				String goodsname = (String) rs.getObject("goodsname");
				String produceplace = (String) rs.getObject("produceplace"); //
				String size = (String) rs.getObject("size"); //
				String gpackage = (String) rs.getObject("gpackage"); //
				String productcode = (String) rs.getObject("productcode"); //
				String promitcode = (String) rs.getObject("promitcode");
				String description = (String) rs.getObject("description");
				double price = (double) rs.getObject("price");
				int providerid = (int) rs.getObject("providerid"); //
				int available = (int) rs.getObject("available");
				int number = (int) rs.getObject("number");
				String providername = (String) rs.getObject("providername");

				// 封装供应商
				Provider provider = new Provider(providerid, providername);

				// 封装商品
				Goods goodss = new Goods(gid, goodsname, produceplace, size,
						gpackage, productcode, promitcode, description, price,
						provider, available, number);
				list.add(goodss);

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
	 * 查商品总条数
	 */
	public int queryCustomerCount(Goods goods) {
		int count = 0;
		String sql = "";
		Object[] objs = {};
		// 判断available是否选择,当值为8表示不做状态查询
		if (8 == goods.getAvailable()) {
			sql = "SELECT COUNT(*) FROM tb_goods where goodsname like ?  and produceplace like ?";
			Object[] temp = { "%" + goods.getGoodsname() + "%",
					"%" + goods.getProduceplace() + "%" };
			objs = temp;
		} else {
			sql = "SELECT COUNT(*) FROM tb_goods where goodsname like ?  and produceplace like ? and available = ? ";
			Object[] temp = { "%" + goods.getGoodsname() + "%",
					"%" + goods.getProduceplace() + "%", goods.getAvailable() };
			objs = temp;
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
	 * 查询一个
	 */
	public Goods queryById(int id) {
		Goods goods = null;
		String sql = "SELECT * FROM tb_goods where gid = ?";
		Object[] objs = { id };
		Connection conn = DBUtils.getConnection();
		PreparedStatement prep = DBUtils.getPreparedStatement(conn, sql, objs);
		ResultSet rs = DBUtils.getResultSet(prep);

		// 处理结果集
		try {
			if (rs.next()) {
				int gid = (int) rs.getObject("gid");
				String goodsname = (String) rs.getObject("goodsname");
				String produceplace = (String) rs.getObject("produceplace"); //
				String size = (String) rs.getObject("size"); //
				String gpackage = (String) rs.getObject("gpackage"); //
				String productcode = (String) rs.getObject("productcode"); //
				String promitcode = (String) rs.getObject("promitcode");
				String description = (String) rs.getObject("description");
				double price = (double) rs.getObject("price");
				int providerid = (int) rs.getObject("providerid"); //
				int available = (int) rs.getObject("available");
				int number = (int) rs.getObject("number");
				// String providername = (String) rs.getObject("providername");

				// 封装供应商
				Provider provider = new Provider(providerid);

				// 封装商品
				goods = new Goods(gid, goodsname, produceplace, size, gpackage,
						productcode, promitcode, description, price, provider,
						available, number);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// 关闭连接
		DBUtils.close(rs);
		DBUtils.close(prep);
		DBUtils.close(conn);

		return goods;
	}

	/**
	 * 根据供应商id查询
	 */
	public List<Goods> queryByPid(int id) {
		String sql = "SELECT gid, goodsname FROM tb_goods where providerid = ?";
		Object[] objs = { id };
		return this.getList(sql, objs, Goods.class);
	}
}
