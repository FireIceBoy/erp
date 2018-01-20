package com.whsxt.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库工具类[可以公用]
 * @author Administrator
 *
 */
public class DBUtils {
	

	//使用C3PO
	private static ComboPooledDataSource ds=new ComboPooledDataSource("mysql");
	/**
	 * 获取连接对象 
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn=null;
		try {
			conn=ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("得到连接失败");
		}
		return conn;
	}
	
	/**
	 * 从连接里面获取发送sql的对象 
	 * @param conn
	 * @return
	 */
	public static PreparedStatement getPreparedStatement(Connection conn,String sql,Object [] objs){
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			if(objs!=null&&objs.length>0){
				for (int i = 0; i < objs.length; i++) {
					if(null != objs[i]){
						pstmt.setObject(i+1, objs[i]);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	
	/**
	 * 封装执行添加，修改，删除的方法
	 */
	public static void executeUpdate(String sql ,Object [] objs){
		Connection conn=getConnection();
		PreparedStatement pstmt=getPreparedStatement(conn, sql, objs);
		try {
			int i = pstmt.executeUpdate();
			if(i>0){
				System.out.println("操作成功");
			}else{
				System.out.println("操作失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DBUtils.close(pstmt);
		DBUtils.close(conn);
	}
	
	/**
	 * 得到结果集
	 * @param pstmt
	 * @return
	 */
	public static ResultSet getResultSet(PreparedStatement pstmt){
		ResultSet rs=null;
		try {
			rs=pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 数据库关闭的方法
	 * @param closeable
	 */
	public static void close(AutoCloseable closeable){
		try {
			if(null!=closeable){
				closeable.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
