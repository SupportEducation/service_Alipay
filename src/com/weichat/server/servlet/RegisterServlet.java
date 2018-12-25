package com.weichat.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.server.dao.EduExpDao;
import com.server.dao.accountDao;
import com.server.dao.teaexprienceDao;
import com.server.dao.userDao;
import com.server.entity.account;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.setCharacterEncoding("utf-8");
		String openid=new String(request.getParameter("openid").getBytes(
				"ISO8859-1"), "UTF-8");
		String headimg=new String(request.getParameter("headimg").getBytes(
				"ISO8859-1"), "UTF-8");
		String nickname=new String(request.getParameter("nickname").getBytes("ISO8859-1"), "UTF-8");


        
		
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		account ac=new accountDao().checkUserWX(openid);
		
		if (ac.getAid()!=0) {
			JSONArray ja = JSONArray.fromObject(ac);
			out.print(ja);
		} else {
			if(new accountDao().insertAccountWX(openid,headimg,nickname))
			{
				account acc=new accountDao().checkUserWX(openid);
				
				account accc=new accountDao().getOneAccountBYusername(openid);
				boolean flat1=new userDao().insertUser(accc.getAid());
				boolean flat2=new EduExpDao().insertEduexpWX(accc.getAid());
				boolean flat3=new teaexprienceDao().insertTeaexWX(accc.getAid());
				
				JSONArray ja = JSONArray.fromObject(acc);
				out.print(ja);
			}
			else
				out.print(0);
		}
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.setCharacterEncoding("utf-8");
//		String openid=new String(request.getParameter("openid").getBytes(
//				"ISO-8859-1"), "UTF-8");
//		String headimg=new String(request.getParameter("headimg").getBytes(
//				"ISO-8859-1"), "UTF-8");
//		String nickname=new String(request.getParameter("nickname").getBytes(
//				"ISO-8859-1"), "UTF-8");
//		
//		response.setContentType("text/html;charset=UTF8");
//		PrintWriter out = response.getWriter();
//		account ac=new accountDao().checkUserWX(openid);
//		
//		if (ac.getAid()!=0) {
//			JSONArray ja = JSONArray.fromObject(ac);
//			out.print(ja);
//		} else {
//			if(new accountDao().insertAccountWX(openid,headimg,nickname))
//			{
//				account acc=new accountDao().checkUserWX(openid);
//				
//				account accc=new accountDao().getOneAccountBYusername(openid);
//				boolean flat1=new userDao().insertUser(accc.getAid());
//				boolean flat2=new EduExpDao().insertEduexpWX(accc.getAid());
//				boolean flat3=new teaexprienceDao().insertTeaexWX(accc.getAid());
//				
//				JSONArray ja = JSONArray.fromObject(acc);
//				out.print(ja);
//			}
//			else
//				out.print(0);
//		}
//		out.flush();
//		out.close();
//		
	}

}
