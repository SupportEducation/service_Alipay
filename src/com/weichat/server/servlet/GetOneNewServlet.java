package com.weichat.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.server.dao.NewsDao;
import com.server.dao.accountDao;
import com.server.dao.teaexprienceDao;
import com.server.entity.account;
import com.server.entity.news;
import com.server.entity.teaexprience;

/**
 * Servlet implementation class GetOneNewServlet
 */
@WebServlet("/GetOneNewServlet")
public class GetOneNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOneNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String nid=new String(request.getParameter("nid").getBytes(
				"utf-8"), "UTF-8");
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		
		news ne=new NewsDao().getOneNews(Integer.parseInt(nid));
		JSONArray ja = JSONArray.fromObject(ne);
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
