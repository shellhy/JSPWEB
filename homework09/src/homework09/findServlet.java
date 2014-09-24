package homework09;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework09.peopleBean;
import homework09.dbConn;

/**
 * Servlet implementation class findServlet
 */
@WebServlet("/")
public class findServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public findServlet() {
        // TODO Auto-generated constructor stub
    	super();
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
		int currPage = 1; 										// 当前页码
		if(request.getParameter("page") != null){ 				// 判断传递页码是否有效
			currPage = Integer.parseInt(request.getParameter("page"));// 对当前页码赋值
		}
		dbConn db = new dbConn();					// 实例化数据库连接
		List<peopleBean> list = db.find(currPage);			// 查询所有信息
		request.setAttribute("list", list);				// 将list放置到request中
		int pages ; 											// 总页数
		int count =  db.findCount();							// 查询总记录数
		if(count % peopleBean.PAGE_SIZE == 0){ 					// 计算总页数
			pages = count / peopleBean.PAGE_SIZE; 				// 对总页数赋值
		}else{
			pages = count / peopleBean.PAGE_SIZE + 1; 				// 对总页数赋值
		}
		StringBuffer sb = new StringBuffer();					// 实例化StringBuffer
		for(int i=1; i <= pages; i++){							// 通过循环构建分页导航条
			if(i == currPage){ 								// 判断是否为当前页
				sb.append("『" + i + "』");					// 构建分页导航条
			}else{
				// 构建分页导航条
				sb.append("<a href='FindServlet?page=" + i + "'>" + i + "</a>");
			}
			sb.append("　");									// 构建分页导航条
		}
		request.setAttribute("bar", sb.toString());	// 将分页导航条的字符串放置到request中
		request.getRequestDispatcher("findInfo.jsp").forward(request, response);
	}
}
