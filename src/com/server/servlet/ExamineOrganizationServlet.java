package com.server.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.server.dao.OrganizationDao;
import com.server.entity.organization;

/**
 * Servlet implementation class ExamineOrganizationServlet
 */
@WebServlet("/ExamineOrganizationServlet")
public class ExamineOrganizationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamineOrganizationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //组织申请审核
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flat=request.getParameter("check");
		String oid=request.getParameter("oid");
		organization or=new organization();
		or.setOid(Integer.parseInt(oid));
		or.setOr_flat(Integer.parseInt(flat));
		boolean result=new OrganizationDao().ExamineOrganization(or);
		if(result){
			request.setAttribute("message",
                    "操作成功！！关闭即可！");
			}
		else{
			request.setAttribute("message",
                    "操作失败！！请重新尝试！");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/organizationEdit.jsp");  
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
