package com.whsxt.dao.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import com.whsxt.utils.DBUtils;

public class BaseDaoImpl<T> {

	/**
	 * 把rs对象 转成集合
	 * 
	 * @param sql
	 * @param objs
	 * @param cls
	 * @return
	 */
	public List<T> getList(String sql, Object[] objs, Class<T> cls) {
		List<T> list = new ArrayList<>();
		Connection conn = DBUtils.getConnection();
		PreparedStatement ps = DBUtils.getPreparedStatement(conn, sql, objs);
		ResultSet rs = DBUtils.getResultSet(ps);
		try {
			// ResultSetMetaData getMetaData()
			// 获取此 ResultSet 对象的列的编号、类型和属性。
			ResultSetMetaData md = rs.getMetaData();
			while (rs.next()) {
				// T newInstance() 创建此 Class 对象所表示的类的一个新实例。
				T obj = cls.newInstance();
				// getColumnCount() 返回此 ResultSet 对象中的列数。
				for (int i = 0; i < md.getColumnCount(); i++) {
					// getColumnLabel(int column) 获取指定列的列名。toLowerCase() 转小写
					String columnName = md.getColumnLabel(i + 1).toLowerCase();
					Object value = rs.getObject(i + 1);
					// 如果值为空，则不必取了
					if (value == null) {
						continue;// 结束本次循环
					}
					Field field = obj.getClass().getDeclaredField(columnName);
					String type = value.getClass().getSimpleName();
					switch (type) {
					case "int":
					case "Integer":
					case "BigDecimal":
						value = rs.getInt(i + 1);
						break;
					}
					// 去掉访问修饰的限制
					field.setAccessible(true);
					// 设置值
					field.set(obj, value);
				}
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs);
			DBUtils.close(ps);
			DBUtils.close(conn);
		}
		return list;
	}

	/**
	 * 把RS转成对象
	 */
	public T getBean(String sql, Object[] objs, Class<T> cls) {
		T t = null;
		Connection conn = DBUtils.getConnection();
		PreparedStatement ps = DBUtils.getPreparedStatement(conn, sql, objs);
		ResultSet rs = DBUtils.getResultSet(ps);
		try {
			ResultSetMetaData md = rs.getMetaData();
			if (rs.next()) {
				t = cls.newInstance();
				for (int i = 0; i < md.getColumnCount(); i++) {
					String columnName = md.getColumnLabel(i + 1).toLowerCase();
					Object value = rs.getObject(i + 1);
					// 如果值为空，则不必取了
					if (value == null) {
						continue;// 结束本次循环
					}
					String type = value.getClass().getSimpleName();
					switch (type) {
					case "int":
					case "Integer":
					case "BigDecimal":
						value = rs.getInt(i + 1);
						break;
					}
					Field field = t.getClass().getDeclaredField(columnName);
					// 去掉访问修饰的限制
					field.setAccessible(true);
					// 设置值
					field.set(t, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs);
			DBUtils.close(ps);
			DBUtils.close(conn);
		}
		return t;
	}

}
