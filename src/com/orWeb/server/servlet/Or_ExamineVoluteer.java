package com.orWeb.server.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.server.dao.vorecruitDao;

/**
 * Servlet implementation class Or_ExamineVoluteer
 */
@WebServlet("/OrganizationWeb/Or_ExamineVoluteer")
public class Or_ExamineVoluteer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Or_ExamineVoluteer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flat=request.getParameter("flat");
		String vid=request.getParameter("vid");
		String page=request.getParameter("page");
		boolean flat1=new vorecruitDao().ExamineVorecruit(Integer.parseInt(vid), Integer.parseInt(flat));
		if(flat1){
			request.setAttribute("message",
                    "操作成功！！关闭即可！");
			}
		else{
			request.setAttribute("message",
                    "操作失败！！请重新尝试！");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/OrganizationWeb/"+page+".jsp");  
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
