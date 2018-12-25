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
import com.server.entity.organization;

/**
 * Servlet implementation class OrganizationManageServlet
 */
@WebServlet("/OrganizationManageServlet")
public class OrganizationManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrganizationManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //×éÖ¯ÒÆ³ý
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String oid=request.getParameter("oid");
		organization or=new organization();
		or=new OrganizationDao().getOneOrganization(oid);
		
		boolean result=new OrganizationDao().DeleteOrganization(oid);
		boolean result2=new accountDao().DeleteAccount(or.getOr_user());
		if(result&&result2){
			request.setAttribute("message",
                    "ÒÆ³ý³É¹¦£¡£¡¹Ø±Õ¼´¿É£¡");
			}
		else{
			request.setAttribute("message",
                    "ÒÆ³ýÊ§°Ü£¡£¡ÇëÖØÐÂ³¢ÊÔ£¡");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/organization.jsp");  
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
