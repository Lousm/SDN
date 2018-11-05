package com.lou.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lou.sql.Controller;

public class ControllerServlet extends HttpServlet {
	Controller cont = new Controller();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//ȡjsp����������
		int Camount = Integer.parseInt(request.getParameter("con_num"));
		System.out.println(Camount);
		//���ɿ������ڵ�
		try {
			cont.contor(Camount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("succ1.jsp").forward(request, response);
	}

}
