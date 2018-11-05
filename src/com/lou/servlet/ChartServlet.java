package com.lou.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lou.javabean.ChartTrun;
import com.lou.javabean.TrunNode;
import com.lou.jstl.Chart;

/*
 * ��ȡ�ִα��ÿ���ڵ��������Ϣ
 * ��ŵ�list
 * ͨ��request����ǰ̨
 * ��ǰ̨ת��������
 */
public class ChartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String number = request.getParameter("number") ;
		//number = (number!= null ?request.getParameter("number"):1);
		if(number==null){
			number = "1";
		}
		System.out.println(number);
		Chart chart = new Chart();
	
		try {
			List<ChartTrun> result = chart.getNode(number);
			ArrayList<Integer> status = new ArrayList<Integer>();
			ArrayList<String> x = new ArrayList<String>();
			ArrayList<String> y = new ArrayList<String>();
			for(int i=0;i<result.size();i++){
				status.add(result.get(i).srand);
				x.add(result.get(i).xcoord+"");
				y.add(result.get(i).ycoord+"");
			}
			
			request.setAttribute("status", status);
			request.setAttribute("x", x);
			request.setAttribute("y", y);
			
			request.setAttribute("tru", number);
			System.out.println("11111111111");
			request.getRequestDispatcher("succChart.jsp").forward(request,
					response);
			
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
