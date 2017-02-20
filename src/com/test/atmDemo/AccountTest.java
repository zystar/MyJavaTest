package com.test.atmDemo;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



/**
 * @author STAR
 * 模拟银行转账(操作事务)
 * 参考：http://blog.csdn.net/caidie_huang/article/details/52639220
 */
public class AccountTest {
	
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		try{
			//查询A账户余额有无够10000
			String sql = "select * from account where name=? and balance >=?";
			conn = DBUtils.getConnection();
			//将事务设置为手动提交
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, "A");
			ps.setInt(2, 10000);
			result = ps.executeQuery();
			if(!result.next()){
				throw new RuntimeException("您的余额不足");
			}
			
			//扣除A账户10000
			sql = "updata account set balance = balance - ? where name = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 10000);
			ps.setString(2, "A");
			ps.executeUpdate();
			
			//模拟中途断电异常
			System.out.println(1/0);
			
			//B账户增加10000
			sql = "updata account set balance = balance + ? where name = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 10000);
			ps.setString(2, "B");
			ps.executeUpdate();
			
			conn.commit();//提交（要整个事务都完成才能提交，因为提交之后就不能改变了）
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}
		DBUtils.close(conn, ps, result);
	}
	
}

class DBUtils{
	private static Properties p = new Properties();
	
	static{
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream in = loader.getResourceAsStream("db.properties");
			p.load(in);
			Class.forName(p.getProperty("driverClassName"));//加载注册驱动只需加载一次，因而用静态代码块
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//获取连接对象
	public static Connection getConnection(){
		try{
			return DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection conn, Statement state, ResultSet result){
		try{
			if(result != null){
				result.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(conn != null){
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				try{
					if(state != null){
						state.close();
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		
	}
	
}

