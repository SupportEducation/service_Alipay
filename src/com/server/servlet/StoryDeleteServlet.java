package com.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.server.dao.storyDao;

/**
 * Servlet implementation class StoryDeleteServlet
 */
@WebServlet("/StoryDeleteServlet")
public class StoryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoryDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String s_id=request.getParameter("s_id");
		
		boolean flag=new storyDao().deleteStory(Integer.parseInt(s_id));
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(flag) {
			request.setAttribute("message",
                    "É¾³ý³É¹¦!");
		}else
			request.setAttribute("message",
                    "É¾³ýÊ§°Ü!");
		
		  request.getServletContext().getRequestDispatcher("/storyManage.jsp").forward(
	                request, response);
	        out.flush();
			out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
