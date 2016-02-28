package shan.servlet.study;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CounterServlet
 */
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
ServletContext context=getServletContext();
        
        Integer count=(Integer)context.getAttribute("counter");
        if(null==count)
        {
            count=new Integer(1);
        }
        else
        {
            count=new Integer(count.intValue()+1);
        }
        
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out=response.getWriter();
        
        out.println("<html><head>");
        out.println("<title>页面访问统计</title>");
        out.println("</head><body>");
        out.println("该页面已被访问了"+"<b>"+count+"</b>"+"次");
        out.println("</body></html>");
        context.setAttribute("counter",count);
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
