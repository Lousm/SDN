package com.lou.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lou.javabean.BusiBean;
import com.lou.javabean.TrunNode;
import com.lou.jstl.Busi;
import com.lou.jstl.Node;
import com.lou.sql.Business;
import com.lou.sql.ControlTrun;

public class BusinessDistributionServlet extends HttpServlet {
	Business business = new Business();
	ControlTrun cont = new ControlTrun();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String conNum = request.getParameter("con_num");

		String busNum = request.getParameter("bus_num");

		if (conNum == null || busNum == null) {
			// ҵ��ַ����ض��򵽽ڵ�jsp
			System.out.println("�ַ����ǿյģ�����");
			request.getRequestDispatcher("succBusi.jsp").forward(request,
					response);
		}

		else {
			
			System.out.println("�ַ������ǿյģ���������");

			System.out.println("conNum  " + conNum);
			System.out.println("busNum  " + busNum);

			// ����ҵ����buis�ֶ�
			try {
				business.setBusi(conNum, busNum);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// �����ִα��buis�ֶ�
			try {
				cont.setBusi(conNum, busNum);
				//cont.updateEnergy();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			Busi busi = new Busi();
			try {
				List<BusiBean> result = busi.getNode();
				request.setAttribute("result", result);

				request.getRequestDispatcher("succBusi.jsp")
						.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
