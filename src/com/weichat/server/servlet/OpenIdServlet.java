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
 * Servlet implementation class OpenIdServlet
 */
@WebServlet("/OpenIdServlet")
public class OpenIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String js_code=new String(request.getParameter("js_code").getBytes(
				"utf-8"), "UTF-8");
		
		String appid="wxcd5f9c6041421fd3";
		String secret= "7b37fee259aa3b607bab943819b4c847";
		String url="https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+js_code+"&grant_type=authorization_code";
		String result=get(url);
		//System.out.println(url);
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
	
	
	 /** 
     * 处理get请求. 
     * @param url  请求路径 
     * @return  json 
     */  
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
