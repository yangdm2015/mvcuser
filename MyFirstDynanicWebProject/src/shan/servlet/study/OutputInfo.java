package shan.servlet.study;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
/**
 * Servlet implementation class OutputInfo
 */
public class OutputInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutputInfo() {
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
        
        Enumeration headNames=request.getHeaderNames();
        
        out.println("<html><head>");
        out.println("<title>Info Page</title>");
        out.println("</head>");
        out.println("<body><center>");

        
        out.println("<table border=1 align=center>");
        out.println("<caption>Servlet接收到的HTTP消息报头的信息</caption>");
        out.println("<tr bgcolor=#999999>");
        out.println("<th>消息报头的名字</th>");
        out.println("<th>消息报头的值</th>");
        out.println("</tr>");
        
        while(headNames.hasMoreElements())
        {
            String name=(String)headNames.nextElement();
            String value=request.getHeader(name);
            out.println("<tr>");
            out.println("<td>"+name+"</td>");
            out.println("<td>"+value+"</td>");
            out.println("</tr>");
        }
        
        out.println("</table><p>");
        
        out.println("<table border=1 align=center>");
        out.println("<caption>其它访问信息</caption>");
        
        out.println("<tr>");
        out.println("<td>客户端的IP地址</td>");
        out.println("<td>"+request.getRemoteAddr()+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>客户端的端口号</td>");
        out.println("<td>"+request.getRemotePort()+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>服务器端的IP地址</td>");
        out.println("<td>"+request.getLocalAddr()+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>服务器端的端口号</td>");
        out.println("<td>"+request.getLocalPort()+"</td>");
        out.println("</tr>");
        
        out.println("</table>");
        
        out.println("</center></body></html>");
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
