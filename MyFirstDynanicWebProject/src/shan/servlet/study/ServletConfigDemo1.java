package shan.servlet.study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Enumeration;
import javax.servlet.ServletConfig;

public class ServletConfigDemo1 extends HttpServlet {
	/**
	* ����ServletConfig�������������õĳ�ʼ������
	*/
	private ServletConfig config;
	/**
	    * ��servlet�����˳�ʼ��������web�����ڴ���servletʵ������ʱ��
	    * ���Զ�����Щ��ʼ��������װ��ServletConfig�����У����ڵ���servlet��init����ʱ��
	    * ��ServletConfig���󴫵ݸ�servlet������������Աͨ��ServletConfig����Ϳ���
	    * �õ���ǰservlet�ĳ�ʼ��������Ϣ��
	    */
	@Override
	public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//this.config = config;
		//��ȡ��web.xml�����õĳ�ʼ������
		// String paramVal = this.config.getInitParameter("name");//��ȡָ���ĳ�ʼ������
	    // response.getWriter().print(paramVal);	        
	    // response.getWriter().print("<hr/>");
	     //��ȡ���еĳ�ʼ������
	     Enumeration<String> e = config.getInitParameterNames();
	     while(e.hasMoreElements()){
	         String name = e.nextElement();
	         String value = config.getInitParameter(name);
	         response.getWriter().print(name + "=" + value + "<br/>");
	     }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}

}
