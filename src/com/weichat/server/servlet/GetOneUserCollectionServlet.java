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
 * Servlet implementation class GetOneUserCollectionServlet
 * 
 * 我的收藏模块  看一看-》我的关注
 */
@WebServlet("/GetOneUserCollectionServlet")
public class GetOneUserCollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOneUserCollectionServlet() {
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
		List<collection> list =new ArrayList<>();
		List<story>  st_list=new ArrayList<>();
		list=new collectionDao().getOneUserCollection(Integer.parseInt(aid));
		for(collection co:list){
			story st=new story();
			st=new storyDao().getOneStory(co.getS_id());
			st_list.add(st);
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
