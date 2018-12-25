package com.weichat.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.server.dao.EduExpDao;
import com.server.dao.accountDao;
import com.server.dao.userDao;
import com.server.entity.account;
import com.server.entity.eduexp;
import com.server.entity.user;

/**
 * Servlet implementation class EduExpServlet
 */
@WebServlet("/EduExpServlet")
public class EduExpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EduExpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		String username=new String(request.getParameter("username").getBytes(
				"utf-8"), "UTF-8");
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		account ac=new accountDao().getOneAccountBYusername(username);
		
		eduexp edu=new EduExpDao().getOneEduExp(ac.getAid());
		edu.setUserid(ac.getAid());
		JSONArray ja = JSONArray.fromObject(edu);
		out.print(ja);
		
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
