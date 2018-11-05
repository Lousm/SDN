package com.lou.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import com.lou.javabean.Set;
import com.lou.javabean.UserBean;
import com.lou.test.Conn;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class LoginServlet extends HttpServlet {
	UserBean userbean = new UserBean();
	Set set = new Set();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*
		 * 1 ��session�л�ȡ��ȷ����֤��
		 * 2 �ӱ��л�ȡ�û���д����֤��
		 * 3 ���бȽ�
		 * 4 �����ͬ���������У����򱣴������Ϣ��request���У���ת����login.jsp
		 */
		String sessioncode = (String) request.getSession().getAttribute("session_vcode");
		String paramcode = request.getParameter("verifyCode");
		
		if(!paramcode.equals(sessioncode)){
			request.setAttribute("msg", "��֤�����");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		String username = null;
		String password = null;
		//������������
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//��ȡ������
		String uname = request.getParameter("username");
		String paw = request.getParameter("password");
		
		System.out.println(uname);
		
		/*
		 * ��ȡ���ݿ�����
		 */
		//��ȡ�û���
		try {
			userbean.setUsername(set.uname());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		username = userbean.getUsername();
		
		//��ȡ����
		try {
			userbean.setPassword(set.paw());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		password= userbean.getPassword();
		
		/*
		 *2.У���û����������Ƿ���ȷ 
		 */
		if (uname.equals(username) && paw.equals(password) ) {//�û���ֻҪ���� itcast����¼�ɹ�
			/*
			 * ��������û������浽cookie�У����͸��ͻ��������
			 * ���´��ٴ�login.jspʱ��login.jsp�л��ȡrequset�е�cookie��������ʾ���û����ı�����
			 */
		/*	Cookie cookie = new Cookie("uname", username);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);*/
			
			/*
			 * 3.����ɹ�
			 *   �������û���Ϣ��session��
			 *   ���ض���succ1.jsp
			 */
			HttpSession session = request.getSession();//��ȡsession
			session.setAttribute("username", username);//�����û���Ϣ ��session����
			response.sendRedirect("/javaweb2/succ1.jsp");
		} else {//��¼ʧ��
			/*
			 *4.���ʧ��
			 *  �����������Ϣ��request��
			 *  ��ת����login.jsp�� 
			 */
			request.setAttribute("msg", "�û������������");  //���������Ϣ��requset����
			RequestDispatcher qr = request.getRequestDispatcher("/login.jsp");
			qr.forward(request, response); //ת��
		}
	}
	
	
	//��ȡrs
	public ResultSet getResultSet() throws Exception{
		ResultSet rs = Conn.getResultSet("select * from user");
		return rs;
	}
	

	@Test
	public void fun1() throws SQLException, Exception{
		userbean.setUsername(set.uname());
		String name = userbean.getUsername();
		System.out.println(name);
		/*System.out.println(getUsername());
		System.out.println(getUserpassword());*/
		userbean.setPassword(set.paw());
		String psw = userbean.getPassword();
		System.out.println(psw);
	
	}

}
