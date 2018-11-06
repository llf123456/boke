package team1.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.jasper.tagplugins.jstl.core.Out;

import team1.dao.userDao;
import team1.model.*;
/**
 * Servlet implementation class register
 */
@WebServlet("/register.do")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				
				PrintWriter out = response.getWriter();
				
				User user = new User();
				userDao userdao = new userDao();
				
				String goodName = request.getParameter("Name");
//				goodName = new String(goodName.getBytes("ISO-8859-1"),"utf-8");
				
				user.setName(goodName);
				user.setPassword(request.getParameter("password"));
				user.setEmail(request.getParameter("Email"));
				user.setQq(request.getParameter("QQ"));
				user.setTel(request.getParameter("Tel"));
				String goodinfo = request.getParameter("Info");
				user.setInfo(goodinfo);
				
				
				
				
				userdao.setuser(user);
				
				out.println("注册成功,请登录");
				response.setHeader("Refresh", "1;url=http://localhost:8080/2016121066/login.jsp");
				
				
	}

}
