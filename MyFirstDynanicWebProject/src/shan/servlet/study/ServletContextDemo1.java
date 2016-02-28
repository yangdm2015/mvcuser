package shan.servlet.study;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextDemo1
 */
public class ServletContextDemo1 extends HttpServlet {
	private ServletConfig config;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletContextDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        super.init(config);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String data = "shan_study";
        /**
         * ServletConfig������ά����ServletContext��������ã�������Ա�ڱ�дservletʱ��
         * ����ͨ��ServletConfig.getServletContext�������ServletContext����
         */
		 ServletContext context = this.getServletContext();
	       
		//ServletContext context = config.getServletContext();//���ServletContext����
        //ServletContext context = this.getServletConfig().getServletContext();//���ServletContext����
        context.setAttribute("data", data);  //��data�洢��ServletContext������
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
