package com.bdi.erp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//  public ViewServlet() {
//      super();
//      System.out.println("1.역시 난 생성자");
//  }

//	public void init(ServletConfig config) throws ServletException {
//		System.out.println("2.난 언제 호출");
//	}

//	public void destroy() {
//		System.out.println("4.난호출안됨");
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String rPath = request.getContextPath();
		uri = uri.replace(rPath, "");
		uri = "/WEB-INF" + uri + ".jsp";
	//	String name = request.getParameter("name");
		
	//	request.setAttribute("name", name);
			RequestDispatcher rd = request.getRequestDispatcher(uri);
			rd.forward(request, response);
	} 


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
