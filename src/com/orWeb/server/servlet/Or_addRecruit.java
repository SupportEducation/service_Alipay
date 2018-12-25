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
import com.server.dao.recruitDao;
import com.server.entity.recruit;

/**
 * Servlet implementation class Or_addRecruit
 */
@WebServlet("/OrganizationWeb/Or_addRecruit")
public class Or_addRecruit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 // �ϴ��ļ��洢Ŀ¼
    private static final String UPLOAD_DIRECTORY = "upload";
    
    //�ϴ��ļ�����Ŀ¼���ļ���
    private  String UPLOAD_WORK = "";
    private  String UPLOAD_WORKNAME = "";
    // �ϴ�����
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Or_addRecruit() {
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

			recruit re=new recruit();
			String start="";
			String end="";
		
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
	      // ServletContext s1=this.getServletContext();
	     //  String uploadPath=s1.getRealPath("/")+ UPLOAD_DIRECTORY;
	         
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
	                        if(fileName.equals(""))
	                        	continue;
	                        String filePath = uploadPath + File.separator + fileName;
	                        File storeFile = new File(filePath);
	                        // �ڿ���̨����ļ����ϴ�·��
	                        System.out.println(filePath);
	                        // �����ļ���Ӳ��
	                        item.write(storeFile);
	                     //   request.setAttribute("message",
	                     //       "�ļ��ϴ��ɹ�!");
	                        UPLOAD_WORK=filePath;
	                        UPLOAD_WORKNAME=fileName;
	                    }
	                    }
	                    else
	                    {
	                    	if("re_title".equals(item.getFieldName()))
	                    		re.setRe_title(new String(item.getString().getBytes(
		                				"ISO-8859-1"), "UTF-8"));
	                    	if ("re_deadline".equals(item.getFieldName()))
	                    		re.setRe_deadline(new String(item.getString().getBytes(
		                				"ISO-8859-1"), "UTF-8"));
	                    	if ("re_start".equals(item.getFieldName()))
	                    		start=new String(item.getString().getBytes(
	                				"ISO-8859-1"), "UTF-8");
	                    	if ("re_end".equals(item.getFieldName()))
	                    		end=new String(item.getString().getBytes(
	                				"ISO-8859-1"), "UTF-8");
	                    	if ("re_serviceplace".equals(item.getFieldName()))
	                    		re.setRe_serviceplace(new String(item.getString().getBytes(
	                				"ISO-8859-1"), "UTF-8"));
	                    	if ("re_jobcontent".equals(item.getFieldName()))
	                    		re.setRe_jobcontent(new String(item.getString().getBytes(
		                				"ISO-8859-1"), "UTF-8"));
	                    	if ("re_treatment".equals(item.getFieldName()))
	                    		re.setRe_treatment(new String(item.getString().getBytes(
		                				"ISO-8859-1"), "UTF-8"));
	                    	if ("re_condition".equals(item.getFieldName()))
	                    		re.setRe_condition(new String(item.getString().getBytes(
		                				"ISO-8859-1"), "UTF-8"));
	                    	if ("re_type".equals(item.getFieldName()))
	                    		re.setRe_type(new String(item.getString().getBytes(
		                				"ISO-8859-1"), "UTF-8"));
	                    	if ("re_peoplenumber".equals(item.getFieldName()))
	                    		re.setRe_peopleenumber(new String(item.getString().getBytes(
		                				"ISO-8859-1"), "UTF-8"));
	                    	
	                    }
	                }
	            }
	        } catch (Exception ex) {
	           // request.setAttribute("message",
	             //       "������Ϣ: " + ex.getMessage());
	        }
	      //����Ϣ���� ���ݿ�
	        response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
	        re.setRe_servicetime(start+"--"+end);
	        re.setRe_img(UPLOAD_WORKNAME);
	        re.setOid((int)request.getSession().getAttribute("oid"));
	        
	        boolean flat=new recruitDao().insertRecruit(re);
	        if (flat==true) {
				request.setAttribute("message",
                        "�ļ��ϴ��ɹ�!");
			} else {
				request.setAttribute("message",
                        "�ļ��ϴ�ʧ��!");
			}
	        
	      //�ϴ���Ϻ�  ת������ҳ
	        request.getServletContext().getRequestDispatcher("/OrganizationWeb/Or_release.jsp").forward(
	                request, response);
	        out.flush();
			out.close();
	}

}
