package com.orWeb.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.server.dao.recruitDao;

/**
 * Servlet implementation class Or_deleteRecruit
 */
@WebServlet("/OrganizationWeb/Or_deleteRecruit")
public class Or_deleteRecruit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Or_deleteRecruit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rid = Integer.parseInt(new String(request.getParameter("rid")
				.getBytes("ISO-8859-1"), "UTF-8"));
		String page=new String(request.getParameter("page").getBytes("ISO-8859-1"), "UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		boolean flat = new recruitDao().DeleteRecruit(rid);
		if (flat == true) {
			request.setAttribute("message", "删除成功!");
		} else {
			request.setAttribute("message", "删除失败!");
		}

		// 上传完毕后 转发到首页
		request.getServletContext()
				.getRequestDispatcher("/OrganizationWeb/"+page+".jsp")
				.forward(request, response);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
