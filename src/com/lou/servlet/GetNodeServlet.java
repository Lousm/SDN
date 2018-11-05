package com.lou.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.lou.javabean.TrunNode;
import com.lou.jstl.Node;

public class GetNodeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("123");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String number = request.getParameter("number");
		if(number==null){
			number="1";
		}
		
			Node node = new Node();

			try {
				List<TrunNode> result = node.getNode(number);
				request.setAttribute("result", result);
				request.setAttribute("tru", number);

				request.getRequestDispatcher("succNode.jsp")
						.forward(request, response);
				// response.sendRedirect("node.jsp");

				// response.getWriter().println(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println(number);
		

	}

}
