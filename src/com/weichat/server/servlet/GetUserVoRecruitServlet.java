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
import com.server.dao.vorecruitDao;
import com.server.entity.recruit;
import com.server.entity.vorecruit;

/**
 * Servlet implementation class GetUserVoRecruitServlet
 */
//我的申报列表
@WebServlet("/GetUserVoRecruitServlet")
public class GetUserVoRecruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserVoRecruitServlet() {
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
		List<vorecruit> list=new vorecruitDao().getOneVoRecruitByAid(Integer.parseInt(aid));
		System.out.println(aid);
		List<recruit> list2= new ArrayList();
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i).getRid());
			  list2.add(new recruitDao().getOneRecruit(list.get(i).getRid()));
			  list2.get(i).setRe_flat(list.get(i).getVflat());
			}
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		JSONArray ja = JSONArray.fromObject(list2);
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
