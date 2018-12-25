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
import com.server.entity.account;
import com.server.entity.organization;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("userName");
		String pwd=request.getParameter("password");
		account acc=new account();
		acc.setAflat(0);
		acc.setUsername(name);
		acc.setPassword(pwd);
		
		account ac=new account();
		ac=new accountDao().checkaccount(acc);
		if(ac.getAid()!=0){
			response.sendRedirect("index.jsp");
			}
		else{
			request.setAttribute("message",
                    "用户名或密码错误!");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");  
		try {  
		    rd.forward(request, response);  
		         return;  
		}catch(Exception e){}
	}
		
	

}
