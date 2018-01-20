package com.whsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.whsxt.dao.ProviderDao;
import com.whsxt.pojo.Provider;
import com.whsxt.utils.DBUtils;
import com.whsxt.utils.bean.PageBean;

public class ProviderDaoImpl extends BaseDaoImpl<Provider> implements
		ProviderDao {

	@Override
	public void add(Provider provider) {
		String sql = "insert into tb_provider(providername,zip,address,telephone,connectionperson,phone,bank,account,email,fax,available ) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] objs = { provider.getProvidername(), provider.getZip(),
				provider.getAddress(), provider.getTelephone(),
				provider.getConnectionperson(), provider.getPhone(),
				provider.getBank(), provider.getAccount(), provider.getEmail(),
				provider.getFax(), provider.getAvailable() };
		DBUtils.executeUpdate(sql, objs);
	}

	@Override
	public void del(int id) {
		String sql = "delete from tb_provider where pid = ?";
		Object[] objs = { id };
		DBUtils.executeUpdate(sql, objs);
	}

	@Override
	public void update(Provider provider) {
		String sql = "update tb_provider set providername= ?,zip= ?,address= ?,telephone= ?,connectionperson= ?,phone= ?,bank= ?,account= ?,email= ?,fax= ?,available= ? where pid = ?";
		Object[] objs = { provider.getProvidername(), provider.getZip(),
				provider.getAddress(), provider.getTelephone(),
				provider.getConnectionperson(), provider.getPhone(),
				provider.getBank(), provider.getAccount(), provider.getEmail(),
				provider.getFax(), provider.getAvailable(), provider.getPid() };
		DBUtils.executeUpdate(sql, objs);
	}

	@Override
	public List<Provider> query(PageBean pageBean, Provider provider) {
		pageBean.setTotalCount(this.getTotalCount(provider));
		String sql = "";
		Object[] objs = {};
		// 判断available是否选择,当值为8表示不做状态查询
		if (8 == provider.getAvailable()) {
			sql = "select * from tb_provider where providername like ? and (telephone like ?  or phone like ?  or connectionperson like ?) limit ?,? ";
			Object[] temp = { "%" + provider.getProvidername() + "%",
					"%" + provider.getTelephone() + "%",
					"%" + provider.getPhone() + "%",
					"%" + provider.getConnectionperson() + "%",
					(pageBean.getCurrentPage() - 1) * pageBean.getPageSize(),
					pageBean.getPageSize() };
			objs = temp;
		} else {
			sql = "select * from tb_provider where providername like ? and (telephone like ?  or phone like ?  or connectionperson like ?) and available = ? limit ?,? ";
			Object[] temp = { "%" + provider.getProvidername() + "%",
					"%" + provider.getTelephone() + "%",
					"%" + provider.getPhone() + "%",
					"%" + provider.getConnectionperson() + "%",
					provider.getAvailable(),
					(pageBean.getCurrentPage() - 1) * pageBean.getPageSize(),
					pageBean.getPageSize() };
			objs = temp;
		}

		return this.getList(sql, objs, Provider.class);
	}

	/**
	 * 查询数据总条数
	 */
	public int getTotalCount(Provider provider) {
		int totalCount = 0;
		String sql = "";
		Object[] objs = {};
		// 判断available是否选择,当值为8表示不做状态查询
		if (8 == provider.getAvailable()) {
			sql = "select count(*) from tb_provider where providername like ? and (telephone like ?  or phone like ?  or connectionperson like ?)";
			Object[] temp = { "%" + provider.getProvidername() + "%",
					"%" + provider.getTelephone() + "%",
					"%" + provider.getPhone() + "%",
					"%" + provider.getConnectionperson() + "%" };
			objs = temp;
		} else {
			sql = "select count(*) from tb_provider where providername like ? and (telephone like ?  or phone like ?  or connectionperson like ?) and available = ?";
			Object[] temp = { "%" + provider.getProvidername() + "%",
					"%" + provider.getTelephone() + "%",
					"%" + provider.getPhone() + "%",
					"%" + provider.getConnectionperson() + "%",
					provider.getAvailable() };
			objs = temp;
		}

		Connection conn = DBUtils.getConnection();
		PreparedStatement ps = DBUtils.getPreparedStatement(conn, sql, objs);
		ResultSet rs = DBUtils.getResultSet(ps);
		try {
			if (rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		return totalCount;

	}

	@Override
	public Provider queryById(int id) {
		String sql = "select * from tb_provider where pid = ?";
		Object[] objs = { id };
		return this.getBean(sql, objs, Provider.class);
	}
}
