package team1.dao;

import java.io.*;
import java.util.*;


import team1.model.*;

import java.sql.*;

public class userDao implements Serializable{
	private String jdbcUrl = "jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf-8";
	private String username = "root";
	private String password = "123456";
	
	public  userDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public  void setuser(User user) {
		Connection conn = null;
		Statement statement = null;
		SQLException ex = null;
		
		try {
			conn = DriverManager.getConnection(
					jdbcUrl,username,password);
			statement = conn.createStatement();
			statement.executeUpdate(
					"insert into tuser(Name,password,QQ,Tel,Email,Info) "
					+ "values('"+user.getName()+"','"+user.getPassword()+
					"','"+user.getQq()+"','"+user.getTel()+"','"+user.getEmail()+"','"+user.getInfo()+"')"
							);
					
		}catch (SQLException e) {
			ex = e;
		}finally {
			if(statement != null) {
				try {
					statement.close();
				}
				catch(SQLException e) {
					if(ex == null) {
						ex = e;
					}
				}
			}
			if(conn !=null) {
				try {
					conn.close();
				}
				catch(SQLException e) {
					if(ex == null) {
						ex = e;
					}
				}
			}
			if(ex != null) {
				throw new RuntimeException(ex);
			}
		}
		
	}
	public String checkuser(String userName) {
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		SQLException ex = null;
		String pwd = null;
		
		try {
			conn = DriverManager.getConnection(
					jdbcUrl,username,password);
			statement = conn.createStatement();
			result = statement.executeQuery("select *from tuser where Name = '" + userName +"'" );
			while(result.next()) {
			pwd = result.getString("password");
			}
		}catch (SQLException e) {
			ex = e;
		}finally {
			if(statement != null) {
				try {
					statement.close();
				}
				catch(SQLException e) {
					if(ex == null) {
						ex = e;
					}
				}
			}
			if(conn !=null) {
				try {
					conn.close();
				}
				catch(SQLException e) {
					if(ex == null) {
						ex = e;
					}
				}
			}
			if(ex != null) {
				throw new RuntimeException(ex);
			}
		}
		return pwd;
		
	}
	public  List<User> getUsers(String name) {
		Connection conn = null;
		Statement statement = null;
		SQLException ex = null;
		ResultSet result = null;
		List<User> users = null;
		
		
		try {
			conn = DriverManager.getConnection(
					jdbcUrl,username,password);
			statement = conn.createStatement();
			result = statement.executeQuery("select *from tuser where Name = '" + name +"'");
			users = new ArrayList<User>();
			while(result.next()) {
				User user = new User();
				user.setName(result.getString("Name"));
				user.setPassword(result.getString("password"));
				user.setQq(result.getString("QQ"));
				user.setEmail(result.getString("Email"));
				user.setTel(result.getString("Tel"));
				user.setInfo(result.getString("Info"));
				users.add(user);
			}
					
		}catch (SQLException e) {
			ex = e;
		}finally {
			if(statement != null) {
				try {
					statement.close();
				}
				catch(SQLException e) {
					if(ex == null) {
						ex = e;
					}
				}
			}
			if(conn !=null) {
				try {
					conn.close();
				}
				catch(SQLException e) {
					if(ex == null) {
						ex = e;
					}
				}
			}
			if(ex != null) {
				throw new RuntimeException(ex);
			}
		}
		return users;
	}
	
	
	
		
	}
	
	

	

	
