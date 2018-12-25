package com.weichat.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.server.dao.collectionDao;
import com.server.dao.storyDao;
import com.server.entity.collection;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class InsertCollectionServlet
 */
@WebServlet("/InsertCollectionServlet")
public class InsertCollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCollectionServlet() {
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
		String s_id=new String(request.getParameter("s_id").getBytes(
				"ISO-8859-1"), "UTF-8");
		collection co=new collection();
		co.setAid(Integer.parseInt(aid));
		co.setS_id(Integer.parseInt(s_id));
		
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		
		JSONArray ja;
		if(new collectionDao().checkCollection(co)!=0)
			 out.print("again");
		else{
			boolean result=new collectionDao().insertCollection(co);
			int sum=new storyDao().getFollowOneSum(Integer.parseInt(s_id));
			boolean result2=new storyDao().updateLikeNum(sum+1, Integer.parseInt(s_id));
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
