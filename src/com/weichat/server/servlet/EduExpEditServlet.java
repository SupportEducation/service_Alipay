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
import com.server.dao.userDao;
import com.server.entity.eduexp;
import com.server.entity.user;

/**
 * Servlet implementation class EduExpServlet
 */
@WebServlet("/EduExpEditServlet")
public class EduExpEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EduExpEditServlet() {
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
		
		String userid=new String(request.getParameter("userid").getBytes(
				"ISO-8859-1"), "UTF-8");
		String schoolname=new String(request.getParameter("schoolname").getBytes(
				"ISO-8859-1"), "UTF-8");
		String degree=new String(request.getParameter("degree").getBytes(
				"ISO-8859-1"), "UTF-8");
		String major=new String(request.getParameter("major").getBytes(
				"ISO-8859-1"), "UTF-8");

		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		
		eduexp edu=new EduExpDao().getOneEduExp(Integer.parseInt(userid));
		
		eduexp ed=new eduexp();
		ed.setUserid(Integer.parseInt(userid));
		ed.setSchoolname(schoolname);
		ed.setDegree(degree);
		ed.setMajor(major);
		
		if(edu.getUserid()==0){
		flat=new EduExpDao().insertEduexp(ed);
		}else{
			flat=new EduExpDao().updateEduexp(ed);
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
	}

}
