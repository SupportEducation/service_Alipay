package com.weichat.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Servlet implementation class GetLocationServlet
 */
@WebServlet("/GetLocationServlet")
public class GetLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLocationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String latitude=new String(request.getParameter("latitude").getBytes(
				"utf-8"), "UTF-8");
		String longitude=new String(request.getParameter("longitude").getBytes(
				"utf-8"), "UTF-8");
		int get_poi=0;
		String location=latitude+","+longitude;
		String key="YHYBZ-53KK6-6GYSR-E4UF2-O4D35-NABOH";
		String url="http://apis.map.qq.com/ws/geocoder/v1/?location="+location+"&key="+key+"&get_poi="+get_poi;
		String result=get(url);
		
		response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		JSONObject  json = JSONObject.fromObject(result);
		out.print(json);
		out.flush();
		out.close();
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public String get(String url){  
        //实例化httpclient  
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        //实例化get方法  
        HttpGet httpget = new HttpGet(url);   
        //请求结果  
        CloseableHttpResponse response = null;  
        String content ="";  
        try {  
            //执行get方法  
            response = httpclient.execute(httpget);  
            if(response.getStatusLine().getStatusCode()==200){  
                content = EntityUtils.toString(response.getEntity(),"utf-8");  
//                System.out.println(content);  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return content;  
    }  
}
