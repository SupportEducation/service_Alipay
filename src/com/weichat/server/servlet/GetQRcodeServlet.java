package com.weichat.server.servlet;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.mysql.cj.log.Log;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetQRcodeServlet
 */
@WebServlet("/GetQRcodeServlet")
public class GetQRcodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetQRcodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String scene=new String(request.getParameter("scene").getBytes(
				"utf-8"), "UTF-8");
		String page=new String(request.getParameter("page").getBytes(
				"utf-8"), "UTF-8");
		String token_url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxcd5f9c6041421fd3&secret=7b37fee259aa3b607bab943819b4c847";
		String token=get(token_url);
//		System.out.println(token);
		
		JSONObject jb = JSONObject.fromObject(token);
		Map<String, Object> map = (Map<String, Object>)jb;
		System.out.println(map.get("access_token"));
		String QRcode_url="https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token="+map.get("access_token");
		Map<String,Object> param = new HashMap<>();
//		param.put("scene",scene);
		param.put("path", page);
		param.put("width", 430);
//        param.put("auto_color", false);
//        Map<String,Object> line_color = new HashMap<>();
//        line_color.put("r", 0);
//        line_color.put("g", 0);
//        line_color.put("b", 0);
//        param.put("line_color", line_color);
        
        JSONObject jsonObject = JSONObject.fromObject(param); 
        String result = jsonObject.toString(); 
		byte [] QRcode = null;
		try {
			QRcode = getQRcode(QRcode_url,result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		InputStream inputStream = null;
        OutputStream outputStream = null;
        inputStream = new ByteArrayInputStream(QRcode);
        
       
        String uploadPath = request.getServletContext().getRealPath("./") + File.separator + "upload\\";
        File file = new File(uploadPath+System.currentTimeMillis()+".jpg");
        System.out.println(uploadPath+System.currentTimeMillis()+".jpg");
        if (!file.exists()){
            file.createNewFile();
        }
        outputStream = new FileOutputStream(file);
        int len = 0;
        byte[] buf = new byte[1024];
        while ((len = inputStream.read(buf, 0, 1024)) != -1) {
            outputStream.write(buf, 0, len);
        }
        outputStream.flush();

        if(inputStream != null){
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(outputStream != null){
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		

//		response.setContentType("text/html;charset=UTF8");
//		PrintWriter out = response.getWriter();
////		JSONObject  json = JSONObject.fromObject("{QR:"+QRcode+"}");
//		out.print(QRcode);
//		out.flush();
//		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
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

    public static byte[] getQRcode(String url, String params) throws Exception {  
        
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        HttpPost httpPost = new HttpPost(url);// 创建httpPost     
        httpPost.setHeader("Accept", "application/json");   
        httpPost.setHeader("Content-Type", "application/json");  
        String charSet = "UTF-8";  
        StringEntity entity = new StringEntity(params, charSet);  
        httpPost.setEntity(entity);          
        CloseableHttpResponse response = null;  
          
        try {  
              
            response = httpclient.execute(httpPost);  
            StatusLine status = response.getStatusLine();  
            int state = status.getStatusCode();  
            if (state == HttpStatus.SC_OK) {  
                HttpEntity responseEntity = response.getEntity();  
//                String jsonString = EntityUtils.toString(responseEntity);  
                byte [] result=EntityUtils.toByteArray(responseEntity);
                return result;
//                return jsonString;  
            }  
            else{  
                 System.out.println("请求返回:"+state+"("+url+")");  
            }  
        }  
        finally {  
            if (response != null) {  
                try {  
                    response.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return null;  
    }
    
    
}
