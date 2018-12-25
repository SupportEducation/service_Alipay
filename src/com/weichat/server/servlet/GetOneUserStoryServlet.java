package com.weichat.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.server.dao.recruitDao;
import com.server.dao.storyDao;
import com.server.entity.recruit;
import com.server.entity.story;

/**
 * Servlet implementation class GetOneUserStoryServlet
 * 获取个人故事列表
 */
@WebServlet("/GetOneUserStoryServlet")
public class GetOneUserStoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOneUserStoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String aid=new String (request.getParameter("aid").getBytes(
				"ISO-8859-1"), "UTF-8");
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		
		List<story> st = new ArrayList();
		
		st=new storyDao().getOneUserStory(Integer.parseInt(aid));
		
		
		JSONArray ja = JSONArray.fromObject(st);
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
