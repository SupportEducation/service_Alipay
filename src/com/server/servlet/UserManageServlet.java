package com.server.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.server.dao.OrganizationDao;
import com.server.dao.accountDao;
import com.server.dao.userDao;
import com.server.entity.organization;
import com.server.entity.user;

/**
 * Servlet implementation class UserManageServlet
 */
@WebServlet("/UserManageServlet")
public class UserManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //Ö¾Ô¸ÕßÒÆ³ý
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String aid=request.getParameter("aid");
	
		boolean result=new userDao().DeleteUserByid(Integer.parseInt(aid));
		boolean result2=new accountDao().DeleteAccountByid(Integer.parseInt(aid));
		if(result&&result2){
			request.setAttribute("message",
                    "ÒÆ³ý³É¹¦£¡£¡¹Ø±Õ¼´¿É£¡");
			}
		else{
			request.setAttribute("message",
                    "ÒÆ³ýÊ§°Ü£¡£¡ÇëÖØÐÂ³¢ÊÔ£¡");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/volunteer.jsp");  
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
