package com.orWeb.server.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.server.dao.OrganizationDao;
import com.server.entity.organization;


/**
 * Servlet implementation class Or_updateOrganization
 */
@WebServlet("/OrganizationWeb/Or_updateOrganization")
public class Or_updateOrganization extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";
    
    //上传文件储存目录及文件名
    private  String UPLOAD_WORK = "";
    private  String UPLOAD_WORKNAME = "";
    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Or_updateOrganization() {
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
		organization or=new organization();
	
    	// 检测是否为多媒体上传
		if (!ServletFileUpload.isMultipartContent(request)) {
		    // 如果不是则停止
		    PrintWriter writer = response.getWriter();
		    writer.println("Error: 表单必须包含 enctype=multipart/form-data");
		    writer.flush();
		    return;
		}
 
        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
         
        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // 中文处理
        upload.setHeaderEncoding("UTF-8"); 

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = request.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
      // ServletContext s1=this.getServletContext();
     //  String uploadPath=s1.getRealPath("/")+ UPLOAD_DIRECTORY;
         
        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
 
        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
 
            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                    	if("file".equals(item.getFieldName())){
                        String fileName = new File(item.getName()).getName();
                        if(fileName.equals(""))
                        	continue;
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        // 在控制台输出文件的上传路径
                        System.out.println(filePath);
                        // 保存文件到硬盘
                        item.write(storeFile);
                     //   request.setAttribute("message",
                     //       "文件上传成功!");
                        UPLOAD_WORK=filePath;
                        UPLOAD_WORKNAME=fileName;
                    }
                    }
                    else
                    {
                    	if("or_name".equals(item.getFieldName()))
                    		or.setOr_name(new String(item.getString().getBytes(
	                				"ISO-8859-1"), "UTF-8"));
                    	if ("or_place".equals(item.getFieldName()))
                    		or.setOr_place(new String(item.getString().getBytes(
	                				"ISO-8859-1"), "UTF-8"));
                    	if ("fonudingtime".equals(item.getFieldName()))
                    		or.setFonudingtime(new String(item.getString().getBytes(
                				"ISO-8859-1"), "UTF-8"));
                    	if ("information".equals(item.getFieldName()))
                    		or.setInformation(new String(item.getString().getBytes(
                				"ISO-8859-1"), "UTF-8"));
                    	if ("seatnumber".equals(item.getFieldName()))
                    		or.setSeatnumber(new String(item.getString().getBytes(
                				"ISO-8859-1"), "UTF-8"));
                    	if ("or_email".equals(item.getFieldName()))
                    		or.setOr_email(new String(item.getString().getBytes(
	                				"ISO-8859-1"), "UTF-8"));
                    	if ("or_officialwebsite".equals(item.getFieldName()))
                    		or.setOr_officialwebsite(new String(item.getString().getBytes(
	                				"ISO-8859-1"), "UTF-8"));
                    	if ("or_wecharnmuber".equals(item.getFieldName()))
                    		or.setOr_wecharnumber(new String(item.getString().getBytes(
	                				"ISO-8859-1"), "UTF-8"));
                    	if ("or_blognumber".equals(item.getFieldName()))
                    		or.setOr_blognumber(new String(item.getString().getBytes(
	                				"ISO-8859-1"), "UTF-8"));
                    	
                    	
                    }
                }
            }
        } catch (Exception ex) {
           // request.setAttribute("message",
             //       "错误信息: " + ex.getMessage());
        }
      //将信息存入 数据库
        response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		or.setOid(Integer.parseInt(request.getSession().getAttribute("oid").toString()));
        or.setOr_logo(UPLOAD_WORKNAME);
        
        boolean flat=new OrganizationDao().updateOrganization(or);
        if (flat==true) {
			request.setAttribute("message",
                    "修改成功!");
		} else {
			request.setAttribute("message",
                    "修改失败!");
		}
        
      //上传完毕后  转发到首页
        request.getServletContext().getRequestDispatcher("/OrganizationWeb/Or_info.jsp").forward(
                request, response);
        out.flush();
		out.close();
	}
	}


