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

import com.server.dao.userDao;
import com.server.entity.user;

/**
 * Servlet implementation class userInfoEditServlet1
 */
@WebServlet("/userInfoEditServlet1")
public class userInfoEditServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	// �ϴ��ļ��洢Ŀ¼
    private static final String UPLOAD_DIRECTORY = "upload";
    
    //�ϴ��ļ�����Ŀ¼���ļ���
    private  String UPLOAD = "";
  
    // �ϴ�����
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userInfoEditServlet1() {
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
		user us=new user();
		
		// ����Ƿ�Ϊ��ý���ϴ�
				if (!ServletFileUpload.isMultipartContent(request)) {
				    // ���������ֹͣ
				    PrintWriter writer = response.getWriter();
				    writer.println("Error: ��������� enctype=multipart/form-data");
				    writer.flush();
				    return;
				}
				// �����ϴ�����
		        DiskFileItemFactory factory = new DiskFileItemFactory();
		        // �����ڴ��ٽ�ֵ - �����󽫲�����ʱ�ļ����洢����ʱĿ¼��
		        factory.setSizeThreshold(MEMORY_THRESHOLD);
		        // ������ʱ�洢Ŀ¼
		        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		 
		        ServletFileUpload upload = new ServletFileUpload(factory);
		         
		        // ��������ļ��ϴ�ֵ
		        upload.setFileSizeMax(MAX_FILE_SIZE);
		         
		        // �����������ֵ (�����ļ��ͱ�����)
		        upload.setSizeMax(MAX_REQUEST_SIZE);

		        // ���Ĵ���
		        upload.setHeaderEncoding("UTF-8"); 

		        // ������ʱ·�����洢�ϴ����ļ�
		        // ���·����Ե�ǰӦ�õ�Ŀ¼
		        String uploadPath = request.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
		       
		         
		        // ���Ŀ¼�������򴴽�
		        File uploadDir = new File(uploadPath);
		        if (!uploadDir.exists()) {
		            uploadDir.mkdir();
		        }
		        
		        try {
		            // ���������������ȡ�ļ�����
		            @SuppressWarnings("unchecked")
		            List<FileItem> formItems = upload.parseRequest(request);
		 
		            if (formItems != null && formItems.size() > 0) {
		                // ����������
		                for (FileItem item : formItems) {
		                    // �����ڱ��е��ֶ�
		                    if (!item.isFormField()) {
		                    	if("file".equals(item.getFieldName())){
		                        String fileName = new File(item.getName()).getName();
		                        String filePath = uploadPath + File.separator + fileName;
		                        File storeFile = new File(filePath);
		                        // �ڿ���̨����ļ����ϴ�·��
		                        System.out.println(filePath);
		                        // �����ļ���Ӳ��
		                        item.write(storeFile);
		                     //   request.setAttribute("message",
		                     //       "�ļ��ϴ��ɹ�!");
		                        
		                       // UPLOAD_P=uploadPath + File.separator+fileName.substring(0, (fileName.length() - 3))+"htm";
		                       // wth.change(filePath, uploadPath);
		                        UPLOAD=fileName;
		                    }	
		                    }
		                    else
		                    {
		                    	if("name".equals(item.getFieldName()))
		                    		us.setName(new String(item.getString().getBytes(
			                				"ISO-8859-1"), "UTF-8"));
		                    	if ("borndate".equals(item.getFieldName()))
		                    		us.setBorndate(new String(item.getString().getBytes(
			                				"ISO-8859-1"), "UTF-8"));
		                    	if ("area".equals(item.getFieldName()))
		                    		us.setArea(new String(item.getString().getBytes(
			                				"ISO-8859-1"), "UTF-8"));
		                    	if ("nation".equals(item.getFieldName()))
		                    		us.setNation(new String(item.getString().getBytes(
			                				"ISO-8859-1"), "UTF-8"));
		                    	if ("sex".equals(item.getFieldName()))
		                    		us.setSex(new String(item.getString().getBytes(
			                				"ISO-8859-1"), "UTF-8"));
		                    	if ("phonenumber".equals(item.getFieldName()))
		                    		us.setPhonenumber(new String(item.getString().getBytes(
			                				"ISO-8859-1"), "UTF-8"));
		                    	if ("email".equals(item.getFieldName()))
		                    		us.setEmail(new String(item.getString().getBytes(
			                				"ISO-8859-1"), "UTF-8"));
		                    	if ("idnumber".equals(item.getFieldName()))
		                    		us.setIdnumber(new String(item.getString().getBytes(
			                				"ISO-8859-1"), "UTF-8"));
		                    	if ("userid".equals(item.getFieldName()))
		                    		us.setUserid(Integer.parseInt(new String(item.getString().getBytes(
			                				"ISO-8859-1"), "UTF-8")));
		                    }
		                }
		            }
		        } catch (Exception ex) {
		           // request.setAttribute("message",
		             //       "������Ϣ: " + ex.getMessage());
		        }
		        
		        System.out.println(us.getPhonenumber());
		        boolean flat = false;
		        us.setLifephoto(UPLOAD);
		        response.setContentType("text/html;charset=UTF8");
				PrintWriter out = response.getWriter();
				user use=new userDao().getOneUser(us.getUserid());
				if(use.getUserid()==0){
				flat=new userDao().insertUser1(us);
				}else{
					flat=new userDao().updateUser1(us);
				}
				JSONArray ja = JSONArray.fromObject(flat);
				out.print(ja);
				out.flush();
				out.close();
	}

}
