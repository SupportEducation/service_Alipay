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
import com.server.dao.teaexprienceDao;
import com.server.entity.eduexp;
import com.server.entity.teaexprience;

/**
 * Servlet implementation class TeaexEditServlet
 */
@WebServlet("/TeaexEditServlet")
public class TeaexEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeaexEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String aid=new String(request.getParameter("aid").getBytes(
				"ISO-8859-1"), "UTF-8");
		String organizationname=new String(request.getParameter("organizationname").getBytes(
				"ISO-8859-1"), "UTF-8");
		String activityname=new String(request.getParameter("activityname").getBytes(
				"ISO-8859-1"), "UTF-8");
		String teaplace=new String(request.getParameter("teaplace").getBytes(
				"ISO-8859-1"), "UTF-8");
		String teadescribe=new String(request.getParameter("teadescribe").getBytes(
				"ISO-8859-1"), "UTF-8");
		
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		
		teaexprience tea=new teaexprienceDao().getOneteae(Integer.parseInt(aid));
		
		teaexprience teae=new teaexprience();
		teae.setActivityname(activityname);
		teae.setOrganizationname(organizationname);
		teae.setTeadescribe(teadescribe);
		teae.setTeaplace(teaplace);
		teae.setUserid(Integer.parseInt(aid));
		
		boolean flat=false;
		if(tea.getUserid()==0){
			flat=new teaexprienceDao().insertTeaex(teae);
			}else{
				flat=new teaexprienceDao().updateTeaex(teae);
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
