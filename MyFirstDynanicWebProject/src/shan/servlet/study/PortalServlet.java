package shan.servlet.study;
import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PortalServlet
 */
public class PortalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PortalServlet() {
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
        
        out.println("<html><head><title>");
        out.println("µÇÂ¼Ò³ÃæµÇÂ¼Ò³ÃæµÇÂ¼Ò³ÃæµÇÂ¼Ò³ÃæµÇÂ¼Ò³ÃæµÇÂ¼Ò³ÃæµÇÂ¼Ò³ÃæµÇÂ¼Ò³ÃæµÇÂ¼Ò³Ãæ");
        out.println("</title></head><body>");
        out.println("µÇÂ¼Ò³ÃæµÇÂ¼Ò³ÃæµÇÂ¼Ò³ÃæµÇÂ¼Ò³ÃæµÇÂ¼Ò³ÃæµÇÂ¼Ò³ÃæµÇÂ¼Ò³ÃæµÇÂ¼Ò³ÃæµÇÂ¼Ò³Ãæ");
        String name=request.getParameter("user");
        String pwd=request.getParameter("password");
        
        if("zhangsan".equals(name) && "1234".equals(pwd))
        {
        	//out.println("success");
            ServletContext context=getServletContext();
            RequestDispatcher rd=context.getRequestDispatcher("/WelcomeYou");
            rd.forward(request,response);/**/
        }
        else
        {
        	/*out.println("failed");*/
            RequestDispatcher rd=request.getRequestDispatcher("LoginServlet2");
            rd.include(request,response);
        }
        out.println("</body></html>");
        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
