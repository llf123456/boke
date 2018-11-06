package team1.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * Application Lifecycle Listener implementation class ListenerTest
 *
 */
@WebListener
public class ListenerTest implements ServletContextListener, HttpSessionListener, ServletRequestListener {

	/**
     * Default constructor. 
     */
    public ListenerTest() {
        // TODO Auto-generated constructor stub
    }
    
 	// 加载 context
 	public void contextInitialized(ServletContextEvent sce) {
 		ServletContext servletContext = sce.getServletContext();
 		System.out.println("即将启动" + servletContext.getContextPath());
 	}
  
 	// 卸载 context
 	public void contextDestroyed(ServletContextEvent sce) {
 		ServletContext servletContext = sce.getServletContext();
 		System.out.println("即将关闭" + servletContext.getContextPath());
 	}
 	
    // 创建 session
 	public void sessionCreated(HttpSessionEvent se) {
 		HttpSession session = se.getSession();
 		System.out.println("新创建一个session, ID为: " + session.getId());
 	}
  
 	// 销毁 session
 	public void sessionDestroyed(HttpSessionEvent se) {
 		HttpSession session = se.getSession();
 		System.out.println("销毁一个session, ID为: " + session.getId());
 	}

  
 	// 创建 request
 	public void requestInitialized(ServletRequestEvent sre) {
  
 		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
  
 		String uri = request.getRequestURI();
 		uri = request.getQueryString() == null ? uri : (uri + "?" + request.getQueryString());
  
 		request.setAttribute("dateCreated", System.currentTimeMillis());
  
 		System.out.println("IP " + request.getRemoteAddr() + " 请求 " + uri);
 	}
  
 	// 销毁 request
 	public void requestDestroyed(ServletRequestEvent sre) {
  
 		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
  
 		long time = System.currentTimeMillis() - (Long) request.getAttribute("dateCreated");
  
 		System.out.println(request.getRemoteAddr() + "请求处理结束, 用时" + time + "毫秒. ");
 	}
	
}
