package com.weichat.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.server.dao.followDao;
import com.server.dao.storyDao;
import com.server.entity.follow;

/**
 * Servlet implementation class InsertFollowServlet
 */
@WebServlet("/InsertFollowServlet")
public class InsertFollowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFollowServlet() {
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
		String aaid=new String(request.getParameter("aaid").getBytes(
				"ISO-8859-1"), "UTF-8");
		follow fo=new follow();
		fo.setAid(Integer.parseInt(aid));
		fo.setAaid(Integer.parseInt(aaid));
		
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		
		
		JSONArray ja;
		if(new followDao().checkFollow(fo)!=0)
			 out.print("again");
		else{
			boolean result=new followDao().insertFollow(fo);
			 ja = JSONArray.fromObject(result);
			 out.print(ja);
		}
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
