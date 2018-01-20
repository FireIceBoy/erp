package com.whsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.whsxt.dao.CustomerDao;
import com.whsxt.pojo.Customer;
import com.whsxt.utils.DBUtils;
import com.whsxt.utils.bean.PageBean;

/**
 * 操作数据库实现类，客户表
 * @author 金诚
 */
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements
		CustomerDao {

	/**
	 * 添加
	 */
	public void add(Customer customer) {
		String sql = "INSERT into tb_customer(`customername`,`zip`,`address`,`telephone`,`connectionperson`,`phone`,`bank`,`account`,`email`,`fax`,`available`) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] objs = { customer.getCustomername(), customer.getZip(),
				customer.getAddress(), customer.getTelephone(),
				customer.getConnectionperson(), customer.getPhone(),
				customer.getBank(), customer.getAccount(), customer.getEmail(),
				customer.getFax(), customer.getAvailable() };
		DBUtils.executeUpdate(sql, objs);
	}

	/**
	 * 删除
	 */
	public void del(int id) {
		String sql = "DELETE from tb_customer where cid = ?";
		Object[] objs = { id };
		DBUtils.executeUpdate(sql, objs);
	}

	/**
	 * 修改
	 */
	public void update(Customer customer) {
		String sql = "UPDATE tb_customer AS c SET c.customername=?,c.zip=?,c.address=?,c.telephone=?,c.connectionperson=?,c.phone=?,c.bank=?,c.account=?,email=?,c.fax=?,c.available=? WHERE c.cid=?";
		Object[] objs = { customer.getCustomername(), customer.getZip(),
				customer.getAddress(), customer.getTelephone(),
				customer.getConnectionperson(), customer.getPhone(),
				customer.getBank(), customer.getAccount(), customer.getEmail(),
				customer.getFax(), customer.getAvailable(), customer.getCid() };
		DBUtils.executeUpdate(sql, objs);
	}

	/**
	 * 分页查询，模糊
	 */
	public List<Customer> query(PageBean pageBean, Customer customer) {
		int totalCount = queryCustomerCount(customer);
		// 把总条数设置进分页实体类
		pageBean.setTotalCount(totalCount);
		String sql = "";
		Object[] objs = {};
		// 判断available是否选择,当值为8表示不做状态查询
		if (8 == customer.getAvailable()) {
			sql = "SELECT * FROM tb_customer where customername like ? and (telephone like ?  or phone like ?  or connectionperson like ?)  LIMIT ?,?";
			Object[] temp = { "%" + customer.getCustomername() + "%",
					"%" + customer.getTelephone() + "%",
					"%" + customer.getPhone() + "%",
					"%" + customer.getConnectionperson() + "%",
					(pageBean.getCurrentPage() - 1) * pageBean.getPageSize(),
					pageBean.getPageSize() };
			objs = temp;
		} else {
			sql = "SELECT * FROM tb_customer where customername like ? and (telephone like ?  or phone like ?  or connectionperson like ?) and available = ? LIMIT ?,?";
			Object[] temp = { "%" + customer.getCustomername() + "%",
					"%" + customer.getTelephone() + "%",
					"%" + customer.getPhone() + "%",
					"%" + customer.getConnectionperson() + "%",
					customer.getAvailable(),
					(pageBean.getCurrentPage() - 1) * pageBean.getPageSize(),
					pageBean.getPageSize() };
			objs = temp;
		}
		return this.getList(sql, objs, Customer.class);
	}

	/**
	 * 查客户总条数
	 */
	public int queryCustomerCount(Customer customer) {
		int count = 0;
		String sql = "";
		Object[] objs = {};
		// 判断available是否选择,当值为8表示不做状态查询
		if (8 == customer.getAvailable()) {
			sql = "SELECT COUNT(*) FROM tb_customer where customername like ? and (telephone like ?  or phone like ?  or connectionperson like ?) ";
			Object[] temp = { "%" + customer.getCustomername() + "%",
					"%" + customer.getTelephone() + "%",
					"%" + customer.getPhone() + "%",
					"%" + customer.getConnectionperson() + "%" };
			objs = temp;
		} else {
			sql = "SELECT COUNT(*) FROM tb_customer where customername like ? and (telephone like ?  or phone like ?  or connectionperson like ?) and available = ? ";
			Object[] temp = { "%" + customer.getCustomername() + "%",
					"%" + customer.getTelephone() + "%",
					"%" + customer.getPhone() + "%",
					"%" + customer.getConnectionperson() + "%",
					customer.getAvailable() };
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
	 * 根据id,查询一个客户
	 */
	public Customer queryById(int id) {
		String sql = "SELECT * FROM tb_customer where cid = ?";
		Object[] objs = { id };
		return this.getBean(sql, objs, Customer.class);
	}

	@Override
	public List<Customer> query() {
		String sql = "SELECT * FROM tb_customer";
		return this.getList(sql, null, Customer.class);
	}

}
