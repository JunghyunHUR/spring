package net.jason.view;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.JsonObject;

import net.jason.database.BlogImpl;
import net.jason.database.FileDto;

@WebServlet("/uploadImageFile")
public class UploadImageFile extends HttpServlet {

	//ĳ���ͼ�, ���, �̹��� �ִ� �뷮, �� ���� �̸�
	private static final String CHATSET = "utf-8";
	private static final String ATTACHE_DIR = "C:\\Junghyun\\REACT\\myblog\\public\\data\\images";
	private static final int LIMIT_SIZE = 1024 * 1024 * 100;
	private static String nfilename = "h";

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		BlogImpl blogfile = new BlogImpl();
		FileDto fDto = new FileDto();
		PrintWriter out = res.getWriter();
		JsonObject obj = new JsonObject();
		String Filetype = (String) req.getSession().getAttribute("fileType");
		File attacheDir = new File(ATTACHE_DIR);
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		
		fileItemFactory.setRepository(attacheDir);
		fileItemFactory.setSizeThreshold(LIMIT_SIZE);
		ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
		HttpSession session = req.getSession();
		if(session.getAttribute("imname") == null) {
			session.setAttribute("imname", Integer.toString((int)System.currentTimeMillis() / 1000));			
		}
		res.setContentType("text/html; charset=utf-8");
		
		try {
			List<FileItem> items = fileUpload.parseRequest(req);
			for(FileItem item : items) {
				
				//���� ���� �̸�
				String oname = item.getName();
				//Ȯ����
				String ext = oname.substring(oname.indexOf('.'));
				//�� ���� �̸�
				nfilename = "h" + Integer.toString((int) (System.currentTimeMillis()/1000));
				String nname = nfilename + ext;
				File uploadedFile = new File(ATTACHE_DIR + File.separator + nname);
				item.write(uploadedFile);
				int filesize = (int) item.getSize();
				
				System.out.printf("�Ķ���͸� : %s, ���ϸ� : %s, ����ũ�� : %s byte, �� ���ϸ� : %s \n",
						item.getFieldName(), oname, filesize, nname);
				int imname = Integer.parseInt((String)session.getAttribute("imname"));
				
				fDto.setNewname(nname);
				fDto.setOldname(oname);
				fDto.setFilesize(filesize);
				fDto.setExt(ext);
				fDto.setImname(imname);

				int result = blogfile.fileInsert(fDto);
				System.out.println("������Ʈ�� ��ȣ"+result);
				
				//JSON Ÿ������ ����
				obj.addProperty("url", "http://localhost:3000/data/images/" + nname);
				
			}
			
			out.println(obj);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
