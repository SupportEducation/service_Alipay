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

import com.server.dao.accountDao;
import com.server.dao.followDao;
import com.server.dao.vorecruitDao;
import com.server.entity.account;
import com.server.entity.follow;
import com.server.entity.friends;

/**
 * Servlet implementation class GetAllFansServlet
 */
@WebServlet("/GetAllFansServlet")
public class GetAllFansServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllFansServlet() {
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
		List<follow> foList=new followDao().getOtherUserFollow(Integer.parseInt(aid));
		List<friends> friList=new ArrayList<>();

		for(follow fo:foList){
			friends fri=new friends();
			account ac=new accountDao().getOneAccount(fo.getAid());
			fri.setAaid(fo.getAid());
			fri.setHeadimg(ac.getHeadimg());
			fri.setNickname(ac.getNickname());
			fri.setFansum(new followDao().getByFollowSum(fo.getAid()));
			fri.setTeasum(new vorecruitDao().getFlat1NumByaid(fo.getAid()));
			follow fo2=new follow();
			fo2.setAaid(fo.getAid());
			fo2.setAid(fo.getAaid());
			fri.setFlag(new followDao().checkFollow(fo2));
			friList.add(fri);
		}
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		
		JSONArray ja = JSONArray.fromObject(friList);
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
