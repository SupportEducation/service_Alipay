package com.weichat.server.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.server.dao.storyDao;
import com.server.dao.userDao;
import com.server.entity.story;
import com.server.entity.user;

/**
 * Servlet implementation class InsetStoryServlet
 * 发布个人故事
 */
@WebServlet("/InsetStoryServlet")
public class InsertStoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	// 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";
    
    //上传文件储存目录及文件名
    private  String UPLOAD = "";
  
    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStoryServlet() {
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
		story st=new story();
		
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
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        // 在控制台输出文件的上传路径
                        System.out.println(filePath);
                        // 保存文件到硬盘
                        item.write(storeFile);
                     //   request.setAttribute("message",
                     //       "文件上传成功!");
                        
                       // UPLOAD_P=uploadPath + File.separator+fileName.substring(0, (fileName.length() - 3))+"htm";
                       // wth.change(filePath, uploadPath);
                        UPLOAD=fileName;
                    }	
                    }
                    else
                    {
                    	if("aid".equals(item.getFieldName()))
                    		st.setAid(Integer.parseInt(new String(item.getString().getBytes(
	                				"ISO-8859-1"), "UTF-8")));
                    	if ("s_time".equals(item.getFieldName()))
                    		st.setS_time(new String(item.getString().getBytes(
	                				"ISO-8859-1"), "UTF-8"));
                    	if ("s_title".equals(item.getFieldName()))
                    		st.setS_title(new String(item.getString().getBytes(
	                				"ISO-8859-1"), "UTF-8"));
                    	if ("s_content".equals(item.getFieldName()))
                    		st.setS_content(new String(item.getString().getBytes(
	                				"ISO-8859-1"), "UTF-8"));
                    	if ("s_place".equals(item.getFieldName()))
                    		st.setS_place(new String(item.getString().getBytes(
	                				"ISO-8859-1"), "UTF-8"));
                    }
                }
            }
        } catch (Exception ex) {
           // request.setAttribute("message",
             //       "错误信息: " + ex.getMessage());
        }
        
       
        boolean flat = false;
        st.setS_img(UPLOAD);
        response.setContentType("text/html;charset=UTF8");
		PrintWriter out = response.getWriter();
		
		flat=new storyDao().insertStory(st);
	
		JSONArray ja = JSONArray.fromObject(flat);
		out.print(ja);
		out.flush();
		out.close();
	}

}
