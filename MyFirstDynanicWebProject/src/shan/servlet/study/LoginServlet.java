package shan.servlet.study;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=gb2312");
	        
	        String name=request.getParameter("user");
	        String pwd=request.getParameter("password");
	        
	        if(name!=null && pwd!=null && name.equals("zhangsan") && 
	           pwd.equals("12345"))
	        {
	        	response.sendRedirect("success.html");
	        }
	        else
	        {
	        	response.sendRedirect("LoginServlet2");
	        	//response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE,"服务器忙，请稍后再登录!");
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
