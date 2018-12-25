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

import com.server.dao.recruitDao;
import com.server.entity.recruit;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class GetOneRecruitServlet
 */
@WebServlet("/GetAllRecruitFromConServlet")
public class GetAllRecruitFromConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllRecruitFromConServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String condition=new String (request.getParameter("condition").getBytes(
				"ISO-8859-1"), "UTF-8");
		String convalue=new String (request.getParameter("convalue").getBytes(
				"ISO-8859-1"), "UTF-8");
		System.out.println(condition+"   "+convalue);
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		
		List<recruit> re = new ArrayList();
		
		if(condition.equals("re_serviceplace")){
			 re=new recruitDao().getAllRecruitFromPlace(convalue);
		}else{
			 re=new recruitDao().getAllRecruitFromCondition(condition, convalue);
		}	
		
		
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
