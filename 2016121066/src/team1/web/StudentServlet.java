package team1.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team1.dao.StudentDAO;
import team1.model.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentDAO stuDao = new StudentDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//設置編碼格式
		//request.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html;charset=utf-8");
		//获取调用方法名称
		String method = request.getParameter("method");
		
		if("findOne".equals(method)) {
			String stuId = request.getParameter("id");
			Student stu = null;
			if(stuId != null) {
				stu = stuDao.findStudentByID(Integer.parseInt(stuId));
			}
			request.setAttribute("stu", stu);
			request.getRequestDispatcher("system/studentShow.jsp").forward(request, response);
		} else if("findAll".equals(method)) {
			List<Student> stuList = stuDao.findAll();
			System.out.println("学生信息查询结果： " + stuList.size());
			request.setAttribute("STU_LIST", stuList);			
			request.getRequestDispatcher("system/students.jsp").forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
