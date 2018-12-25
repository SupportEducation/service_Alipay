package com.weichat.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.server.dao.OrganizationDao;
import com.server.dao.vorecruitDao;
import com.server.entity.organization;
import com.server.entity.recruit;
import com.server.entity.vorecruit;

/**
 * Servlet implementation class VolunteerSetUpServlet
 */
@WebServlet("/VolunteerSetUpServlet")
public class VolunteerSetUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolunteerSetUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String rid=new String(request.getParameter("rid").getBytes(
				"ISO-8859-1"), "UTF-8");
		String aid=new String(request.getParameter("aid").getBytes(
				"ISO-8859-1"), "UTF-8");
		
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		
		String result="";
		boolean flat=false;
		vorecruit vo =new vorecruitDao().getOneVorecruit(rid,aid);
		if(vo.getVid()!=0)
			result="again";
		else{
			flat=new vorecruitDao().insertVorecruit(Integer.parseInt(rid), Integer.parseInt(aid));
		if(flat==true)
			result="true";
		else
			result="false";
		}
	
		out.print(result);
		
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
