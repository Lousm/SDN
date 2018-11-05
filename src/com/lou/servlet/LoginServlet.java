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
		 * 1 从session中获取正确的验证码
		 * 2 从表单中获取用户填写的验证码
		 * 3 进行比较
		 * 4 如果相同，向下运行，否则保存错误信息到request域中，并转发到login.jsp
		 */
		String sessioncode = (String) request.getSession().getAttribute("session_vcode");
		String paramcode = request.getParameter("verifyCode");
		
		if(!paramcode.equals(sessioncode)){
			request.setAttribute("msg", "验证码错误！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		String username = null;
		String password = null;
		//处理中文乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取表单数据
		String uname = request.getParameter("username");
		String paw = request.getParameter("password");
		
		System.out.println(uname);
		
		/*
		 * 获取数据库数据
		 */
		//获取用户名
		try {
			userbean.setUsername(set.uname());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		username = userbean.getUsername();
		
		//获取密码
		try {
			userbean.setPassword(set.paw());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		password= userbean.getPassword();
		
		/*
		 *2.校验用户名和密码是否正确 
		 */
		if (uname.equals(username) && paw.equals(password) ) {//用户名只要不是 itcast。登录成功
			/*
			 * 附加项：把用户名保存到cookie中，发送给客户端浏览器
			 * 当下次再打开login.jsp时，login.jsp中会读取requset中的cookie，把它显示到用户名文本框中
			 */
		/*	Cookie cookie = new Cookie("uname", username);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);*/
			
			/*
			 * 3.如果成功
			 *   》保存用户信息到session中
			 *   》重定向到succ1.jsp
			 */
			HttpSession session = request.getSession();//获取session
			session.setAttribute("username", username);//保存用户信息 到session域中
			response.sendRedirect("/javaweb2/succ1.jsp");
		} else {//登录失败
			/*
			 *4.如果失败
			 *  》保存错误信息到request中
			 *  》转发到login.jsp中 
			 */
			request.setAttribute("msg", "用户名或密码错误");  //保存错误信息到requset域中
			RequestDispatcher qr = request.getRequestDispatcher("/login.jsp");
			qr.forward(request, response); //转发
		}
	}
	
	
	//获取rs
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
