package shan.servlet.study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet2
 */
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=gb2312");
        
        PrintWriter out=response.getWriter();

        out.println("<form method=post action=PortalServlet>");
        
        out.println("<table>");
        
        out.println("<tr>");
        out.println("<td>请输入用户名</td>");
        out.println("<td><input type=text name=user></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>请输入密码</td>");
        out.println("<td><input type=password name=password></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td><input type=reset value=重填></td>");
        out.println("<td><input type=submit value=登录></td>");
        out.println("</tr>");
        
        out.println("</table>");
        
        out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
