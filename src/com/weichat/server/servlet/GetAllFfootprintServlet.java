package com.weichat.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.server.dao.recruitDao;
import com.server.dao.storyDao;
import com.server.dao.vorecruitDao;
import com.server.entity.footprint;
import com.server.entity.recruit;
import com.server.entity.story;
import com.server.entity.vorecruit;

/**
 * Servlet implementation class GetAllFfootprintServlet
 */
@WebServlet("/GetAllFfootprintServlet")
public class GetAllFfootprintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllFfootprintServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String aid=new String(request.getParameter("aid").getBytes(
				"ISO-8859-1"), "UTF-8");
		List<vorecruit> vc=new vorecruitDao().getOneVoRecruitByAid(Integer.parseInt(aid));
		List<footprint> fpList=new ArrayList<>(); 
		
		for(vorecruit vo:vc){
			recruit re=new recruitDao().getOneRecruit(vo.getRid());
			footprint fp=new footprint();
			fp.setTitle(re.getRe_title());
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
			String dstr="2008-4-24";  
			try {
				java.util.Date date=sdf.parse(dstr);
				fp.setTime(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			fp.setImg(re.getRe_img());
			fp.setPlace(re.getRe_serviceplace());
			fp.setType("参加了1次支教活动");
			fpList.add(fp);
		}
		List<story> stList=new storyDao().getOneUserStory(Integer.parseInt(aid));
		for(story st:stList){
			footprint fp=new footprint();
			fp.setPlace(st.getS_place());
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
			String dstr=st.getS_time();  
			try {
				java.util.Date date=sdf.parse(dstr);
				fp.setTime(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			fp.setImg(st.getS_img());
			fp.setTitle(st.getS_title());
			fp.setType("发布了1次个人故事");
			fpList.add(fp);
		}
		
		Collections.sort(fpList, new Comparator<footprint>(){

			@Override
			public int compare(footprint o1, footprint o2) {
				// TODO Auto-generated method stub
				if (o1.getTime().getTime() < o2.getTime().getTime()) 
					return 1;
				else
					return -1;
			}
			
			
		});  
		
		
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		JSONArray ja = JSONArray.fromObject(fpList);
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
