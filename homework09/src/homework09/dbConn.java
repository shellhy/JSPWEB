package homework09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import homework09.peopleBean;

public class dbConn {
	/**
	 * 获取数据库连接
	 * 
	 * @return Connection对象
	 */
	public Connection getConnection() {
		Connection conn = null; // 数据库连接
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载数据库驱动，注册到驱动管理器
			// 数据库连接字符串
			String url = "jdbc:mysql://localhost:3306/homework09";
			String username = "root"; // 数据库用户名
			String password = "hy920602"; // 数据库密码
			// 创建Connection连接
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("数据库连接成功！");
		return conn; // 返回数据库连接
	}

	/**
	 * 分页查询所有用户信息
	 * 
	 * @param page
	 *            页数
	 * @return List<Book>
	 */

	public List<peopleBean> find (int page) {
		List<peopleBean> list = new ArrayList<>(); // 创建List
		Connection conn = getConnection(); // 获取数据库连接
		// 分页查询的SQL语句
		String sql = "select * from register order by id desc limit ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql); // 获取PreparedStatement
			ps.setInt(1, (page - 1) * peopleBean.PAGE_SIZE); // 对SQL语句中的第1个参数赋值
			ps.setInt(2, peopleBean.PAGE_SIZE); // 对SQL语句中的第2个参数赋值
			ResultSet rs = ps.executeQuery(); // 执行查询操作
			while (rs.next()) { // 光标向后移动，并判断是否有效
				peopleBean b = new peopleBean(); // 实例化
				b.setId(rs.getInt("id"));
				b.setUserName(rs.getString("username")); // 对id属性赋值
				b.setPassword(rs.getString("password")); 
				b.setEmail(rs.getString("email")); 
				b.setBirthday(rs.getDate("birthday")); 
				b.setDegree(rs.getString("degree"));
				b.setPushInfo(rs.getString("pushInfo")); 
				list.add(b); // 将BookBean添加到List集合中
			}
			rs.close(); // 关闭ResultSet
			ps.close(); // 关闭PreparedStatement
			conn.close(); // 关闭Connection
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询总记录数
	 * 
	 * @return 总记录数
	 */
	public int findCount() {
		int count = 0; // 总记录数
		Connection conn = getConnection(); // 获取数据库连接
		String sql = "select count(*) from register"; // 查询总记录数SQL语句
		try {
			Statement stmt = conn.createStatement(); // 创建Statement
			ResultSet rs = stmt.executeQuery(sql); // 查询并获取ResultSet
			if (rs.next()) { // 光标向后移动，并判断是否有效
				count = rs.getInt(1); // 对总记录数赋值
			}
			rs.close(); // 关闭ResultSet
			conn.close(); // 关闭Connection
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count; // 返回总记录数
	}

}
