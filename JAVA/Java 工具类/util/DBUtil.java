package com.dezhong.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.dezhong.util.propertiesmanager.JdbcProperties;

public class DBUtil {

	private static Logger logger=Logger.getLogger(DBUtil.class); 
	
	private static String driverClass = null;
	private static String url = null;
	private static String userName = null;
	private static String password = null;
	
	static {
			
			driverClass = JdbcProperties.getConfig("jdbc.driverClass");
			url = JdbcProperties.getConfig("jdbc.url");
			userName = JdbcProperties.getConfig("jdbc.userName");
			password = JdbcProperties.getConfig("jdbc.password");
	}

	public static Connection getConn() {
	   try {   
		    Class.forName(driverClass);  
		    Connection conn = DriverManager.getConnection(url, userName, password );
		    return conn;
	    } catch(ClassNotFoundException e) {   
	    	e.printStackTrace();   
			
			String logxml = "<异常>";
				logxml += "<时间>" + GlobalMethod.getNowDateTimeStr() + "</时间>"; 
				logxml += "<出错地点>" + DBUtil.class + "</出错地点>"; 
				logxml += "<错误>加载JDBC驱动类出错</错误>"; 
				logxml += "<出错说明>" + e + "</出错说明>"; 
				logxml += "</异常>";	
	    	logger.error(logxml);
	    } catch (SQLException e) {
			e.printStackTrace();
			
			String logxml = "<异常>";
				logxml += "<时间>" + GlobalMethod.getNowDateTimeStr() + "</时间>"; 
				logxml += "<出错地点>" + DBUtil.class + "</出错地点>"; 
				logxml += "<错误>初始化JDBC链接出错</错误>"; 
				logxml += "<出错说明>" + e + "</出错说明>"; 
				logxml += "</异常>";	
				logger.error(logxml);
		}
		
	    return null;
	}
	
	
	public static void closeConn(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs){

		if(rs != null) {   // 关闭记录集   
			try {   
	            rs.close();   
	        } catch(SQLException e) {   
	            e.printStackTrace();   
	        } finally {
	        	rs = null;
	        }
	    }   
		
	    if(stmt != null) {   // 关闭声明   
	        try {   
	            stmt.close();   
	        } catch(SQLException e) {   
	            e.printStackTrace();   
	        } finally {
	        	stmt = null;
	        }  
	    }  
		
	    if(pstmt != null) {   // 关闭声明   
	        try {   
	            pstmt.close();   
	        } catch(SQLException e) {   
	            e.printStackTrace();   
	        } finally {
	        	pstmt = null;
	        }  
	    }   

	    if(conn != null) {  // 关闭连接对象   
	         try {   
	            conn.close();   
	         } catch(SQLException e) {   
	            e.printStackTrace();   
	         } finally {
	        	 conn = null;
	        }
	    }  
	}
	
	
	public static void closeConn(Connection conn, List<Statement> stmtList, List<PreparedStatement> pstmtList, List<ResultSet> rsList){

		for (ResultSet rs : rsList) {
			if(rs != null) {   // 关闭记录集   
				try {   
					rs.close();   
				} catch(SQLException e) {   
					e.printStackTrace();   
				} finally {
					rs = null;
				}
			}   
		}
		
		for (Statement stmt : stmtList) {
			if(stmt != null) {   // 关闭声明   
				try {   
					stmt.close();   
				} catch(SQLException e) {   
					e.printStackTrace();   
				} finally {
					stmt = null;
				}  
			}   
		}
		
		for (PreparedStatement pstmt : pstmtList) {
			if(pstmt != null) {   // 关闭声明   
				try {   
					pstmt.close();   
				} catch(SQLException e) {   
					e.printStackTrace();   
				} finally {
					pstmt = null;
				}  
			}   
		}

	    if(conn != null) {  // 关闭连接对象   
	         try {   
	            conn.close();   
	         } catch(SQLException e) {   
	            e.printStackTrace();   
	         } finally {
	        	 conn = null;
	        }
	    }  
	}
	
	public static void main(String[] args) {
		Connection conn = getConn();
		System.out.println("测试JDBC连接" + conn);
	}
	
}
