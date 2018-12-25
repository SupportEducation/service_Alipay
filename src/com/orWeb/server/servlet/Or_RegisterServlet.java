package com.orWeb.server.servlet;

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

/**
 * Servlet implementation class Or_RegisterServlet
 */
@WebServlet("/OrganizationWeb/Or_RegisterServlet")
public class Or_RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Or_RegisterServlet() {
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
		String username=new String(request.getParameter("username").getBytes(
				"ISO-8859-1"), "UTF-8");
		String pwd=new String(request.getParameter("password").getBytes(
				"ISO-8859-1"), "UTF-8");
		account acc=new account();
		acc.setAflat(1);
		acc.setUsername(username);
		acc.setPassword(pwd);
		
		boolean flat=false;
		boolean flat2=false;
		
		account ac=new accountDao().checkUsername(acc);
		
		System.out.println(ac.getAid());
		
		if(ac.getAid()!=0){
			request.setAttribute("message",
                    "用户名已存在!");
		}else{
			flat=new accountDao().insertAccountOR(acc);
			flat2=new OrganizationDao().insertOrganization(username, pwd);
			if(flat&&flat2)
				request.setAttribute("message",
	                    "注册成功！");
			else
				request.setAttribute("message",
	                    "注册失败！");
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/OrganizationWeb/Or_index.jsp");  
		try {  
		    rd.forward(request, response);  
		         return;  
		}catch(Exception e){}
		
	}

}
