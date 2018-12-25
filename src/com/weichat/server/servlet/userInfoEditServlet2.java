package com.weichat.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.server.dao.accountDao;
import com.server.dao.userDao;
import com.server.entity.account;
import com.server.entity.user;

/**
 * Servlet implementation class userInfoEditServlet2
 */
@WebServlet("/userInfoEditServlet2")
public class userInfoEditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userInfoEditServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean flat=false;
		request.setCharacterEncoding("utf-8");
		user us=new user();
		
		us.setWorkaddress(new String(request.getParameter("workaddr").getBytes(
				"ISO-8859-1"), "UTF-8"));
		us.setHomeaddress(new String(request.getParameter("homeaddr").getBytes(
				"ISO-8859-1"), "UTF-8"));
		us.setEmergancycontact(new String(request.getParameter("phone").getBytes(
				"ISO-8859-1"), "UTF-8"));
		us.setEmergancyrelationship(new String(request.getParameter("contact").getBytes(
				"ISO-8859-1"), "UTF-8"));
		us.setUserid(Integer.parseInt(new String(request.getParameter("userid").getBytes(
				"ISO-8859-1"), "UTF-8")));
		
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		
		user use=new userDao().getOneUser(us.getUserid());
		if(use.getUserid()==0){
		flat=new userDao().insertUser2(us);
		}else{
			flat=new userDao().updateUser2(us);
		}

		JSONArray ja = JSONArray.fromObject(flat);
		out.print(ja);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean flat=false;
		request.setCharacterEncoding("utf-8");
		user us=new user();
		
		us.setWorkaddress(new String(request.getParameter("workaddr").getBytes(
				"utf-8"), "UTF-8"));
		us.setHomeaddress(new String(request.getParameter("homeaddr").getBytes(
				"utf-8"), "UTF-8"));
		us.setEmergancycontact(new String(request.getParameter("phone").getBytes(
				"utf-8"), "UTF-8"));
		us.setEmergancyrelationship(new String(request.getParameter("contact").getBytes(
				"utf-8"), "UTF-8"));
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		
		user use=new userDao().getOneUser(us.getUserid());
		if(use.getUserid()==0){
		flat=new userDao().insertUser2(us);
		}else{
			flat=new userDao().updateUser2(us);
		}

		JSONArray ja = JSONArray.fromObject(flat);
		out.print(ja);
		out.flush();
		out.close();
	}

}
