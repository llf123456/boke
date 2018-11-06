package team1.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team1.dao.userDao;
import team1.model.User;

/**
 * Servlet implementation class login
 */
@WebServlet("/login.do")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ServletContext context = request.getServletContext();
		
		PrintWriter out = response.getWriter();
		String name = request.getParameter("Name");
		String pwd = request.getParameter("pwd");
		
		userDao User = new userDao();
		String realpwd = User.checkuser(name);
		
		if(pwd.equals(realpwd))
		{
			HttpSession session = request.getSession();
			session.setAttribute("Name",name );
			
			List<User> users = User.getUsers((String)session.getAttribute("Name"));
			
			context.setAttribute("users", users);
			request.setAttribute("users", context.getAttribute("users"));
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		else
		{
			out.println("登录失败，请检查您的用户名和密码");
			response.setHeader("Refresh", "3;http://localhost:8080/2016121066/login.jsp");
		}
	}

}
