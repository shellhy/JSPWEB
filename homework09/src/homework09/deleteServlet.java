package homework09;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework09.dbConn;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		dbConn db = new dbConn();
		Connection conn=db.getConnection();
		String sql = "DELETE  FROM register WHERE id=?";// SQL语句
		java.sql.PreparedStatement ps;
		try {
		ps = conn.prepareStatement(sql);
		// 获取PreparedStatement
		String ID[]=request.getParameterValues("delid");		
		if (ID.length>0){
			for(int i=0;i<ID.length;i++){
				ps.setInt(1,Integer.parseInt(ID[i])); 	// 对SQL语句中的第1个参数赋值
				ps.addBatch();	// 添加批处理命令
			}
		}
		ps.executeBatch();	// 执行批处理操作
		ps.close(); // 关闭PreparedStatement
		conn.close(); // 关闭Connection
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		response.sendRedirect("FindServlet"); // 重定向到FindServlet
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
}
