package com.server.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.server.dao.OrganizationDao;
import com.server.dao.recruitDao;
import com.server.entity.organization;

/**
 * Servlet implementation class ExRecruitServlet
 */
@WebServlet("/ExRecruitServlet")
public class ExRecruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExRecruitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //审核招募信息
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flat=request.getParameter("check");
		String rid=request.getParameter("rid");
		
		boolean result=new recruitDao().ExamineRecruit(Integer.parseInt(flat), Integer.parseInt(rid));
		if(result){
			request.setAttribute("message",
                    "操作成功！！关闭即可！");
			}
		else{
			request.setAttribute("message",
                    "操作失败！！请重新尝试！");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/ExRecruitEdit.jsp");  
		try {  
		    rd.forward(request, response);  
		         return;  
		}catch(Exception e){}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
