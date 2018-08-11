package com.bdi.erp.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bdi.erp.service.UserService;
import com.bdi.erp.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("uri : " + uri);
		if(cmd.equals("login")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			boolean isLogin = us.login(id,  pwd);
			if(isLogin) {
				out.println("로그인 성공!!");
			}else {
				out.println("로그인 실패");
			}
		}else if(cmd.equals("join")) {
			out.println("회원가입입니다.");
		}else if(cmd.equals("list")) {
			Map<String, String[]> name = new HashMap<String,String[]>();
			name = request.getParameterMap();
			List<Map<String,String>> userList = us.getUserList(name);
			RequestDispatcher rd = request.getRequestDispatcher("/views" + uri);
			request.setAttribute("userlist",userList);
			rd.forward(request, response);
		}
		else {
			out.println("알수없는 요청");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
