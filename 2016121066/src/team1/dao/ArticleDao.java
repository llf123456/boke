package team1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import team1.model.User;

public class ArticleDao {
	private String jdbcUrl = "jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf-8";
	private String username = "root";
	private String password = "123456";
	
	public  ArticleDao() {
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
}
