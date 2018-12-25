package com.weichat.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.server.dao.recruitDao;
import com.server.dao.teaexprienceDao;
import com.server.entity.recruit;

/**
 * Servlet implementation class GetOneRecruitServlet
 */
@WebServlet("/GetOneRecruitServlet")
public class GetOneRecruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOneRecruitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String rid=new String(request.getParameter("rid").getBytes(
				"ISO-8859-1"), "UTF-8");
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		recruit re=new recruitDao().getOneRecruit(Integer.parseInt(rid));
		JSONArray ja = JSONArray.fromObject(re);
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
