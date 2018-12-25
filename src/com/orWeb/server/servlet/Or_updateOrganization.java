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
             //       "������Ϣ: " + ex.getMessage());
        }
      //����Ϣ���� ���ݿ�
        response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		or.setOid(Integer.parseInt(request.getSession().getAttribute("oid").toString()));
        or.setOr_logo(UPLOAD_WORKNAME);
        
        boolean flat=new OrganizationDao().updateOrganization(or);
        if (flat==true) {
			request.setAttribute("message",
                    "�޸ĳɹ�!");
		} else {
			request.setAttribute("message",
                    "�޸�ʧ��!");
		}
        
      //�ϴ���Ϻ�  ת������ҳ
        request.getServletContext().getRequestDispatcher("/OrganizationWeb/Or_info.jsp").forward(
                request, response);
        out.flush();
		out.close();
	}
	}


