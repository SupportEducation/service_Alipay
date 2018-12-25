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

import com.server.dao.collectionDao;
import com.server.dao.storyDao;
import com.server.entity.collection;
import com.server.entity.story;

/**
 * Servlet implementation class GetAllStoryServlet
 */
@WebServlet("/GetAllStoryServlet")
public class GetAllStoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllStoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String aid=new String(request.getParameter("aid").getBytes(
				"ISO-8859-1"), "UTF-8");
		
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		List<story>  st_list=new ArrayList<>();
		st_list=new storyDao().getAllStory();  
		for(story st:st_list) {
			collection co=new collection();
			co.setAid(Integer.parseInt(aid));
			co.setS_id(st.getS_id());
			st.setCflag(new collectionDao().checkCollection(co));
		}
		
		JSONArray ja = JSONArray.fromObject(st_list);
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
