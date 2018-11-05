package com.lou.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lou.jstl.ControllerCharNum;

public class ControllerCharServlet extends HttpServlet {
	ControllerCharNum ccn=new ControllerCharNum();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		try {
			int cid1=ccn.getContorllerNum1();
			int cid2=ccn.getContorllerNum2();
			int cid3=ccn.getContorllerNum3();
			int cid4=ccn.getContorllerNum4();
			request.setAttribute("cid1", cid1);
			request.setAttribute("cid2", cid2);
			request.setAttribute("cid3", cid3);
			request.setAttribute("cid4", cid4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("succCont.jsp")
		.forward(request, response);
	}

}
