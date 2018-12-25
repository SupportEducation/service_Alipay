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
 * �������˹���
 */
@WebServlet("/InsetStoryServlet")
public class InsertStoryServlet extends HttpServlet {
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
             //       "������Ϣ: " + ex.getMessage());
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
