package homework09;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class insertServlet
 */
@WebServlet("/insertServlet")
public class insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("username");	//获取用户名参数
		String password = request.getParameter("password");	//获取用户输入的密码参数
		String email = request.getParameter("email");	//获取用户输入的邮箱
		String birthday = request.getParameter("birthday");	//获取用户输入出生日期
		String degree = request.getParameter("degree");	//获取用户输入学历
		String push = request.getParameter("pushInfo");	//获取用户其他信息
		System.out.println(name+"\t"+password+"\t"+email+"\t"+birthday+"\t"+degree+"\t"+push);
		dbConn db = new dbConn();
		Connection conn=db.getConnection();
		System.out.println("Connected!");
		String sql = "insert into register(username,password,email,birthday,degree,pushInfo)"
				+ "values(?,?,?,?,?,?)";// 更新SQL语句
		java.sql.PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
		// 获取PreparedStatement
			 ps.setString(1, name);  
	         ps.setString(2, password);  
	         ps.setString(3, email);  
	         ps.setString(4, birthday);  
	         ps.setString(5, degree); 
	         ps.setString(6,push);
	         ps.addBatch();
		     ps.executeBatch();	// 执行批处理操作
		     ps.close(); // 关闭PreparedStatement
		     conn.close(); // 关闭Connection
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		response.sendRedirect("findServlet"); // 重定向到FindServlet
	}

}
