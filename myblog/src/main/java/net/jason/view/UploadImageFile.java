package net.jason.view;

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

import com.google.gson.JsonObject;

import net.jason.database.BlogImpl;
import net.jason.database.FileDto;

@WebServlet("/uploadImageFile")
public class UploadImageFile extends HttpServlet {

	//캐릭터셋, 경로, 이미지 최대 용량, 새 파일 이름
	private static final String CHATSET = "utf-8";
	private static final String ATTACHE_DIR = "C:\\Junghyun\\REACT\\myblog\\public\\data\\images";
	private static final int LIMIT_SIZE = 1024 * 1024 * 100;
	private static String nfilename = "h" + Integer.toString((int)System.currentTimeMillis() / 1000);

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
		
		res.setContentType("text/html; charset=utf-8");
		
		try {
			List<FileItem> items = fileUpload.parseRequest(req);
			for(FileItem item : items) {
				
				//원래 파일 이름
				String oname = item.getName();
				//확장자
				String ext = oname.substring(oname.indexOf('.'));
				//새 파일 이름
				String nname = nfilename + ext;
				File uploadedFile = new File(ATTACHE_DIR + File.separator + nname);
				item.write(uploadedFile);
				long filesize = item.getSize();
				
				System.out.printf("파라미터명 : %s, 파일명 : %s, 파일크기 : %s byte, 새 파일명 : %s \n",
						item.getFieldName(), item.getName(), filesize, nname);
				
				fDto.setNewname(nname);
				fDto.setOldname(oname);
				fDto.setFilesize(filesize);
				fDto.setExt(ext);
			
				//JSON 타입으로 리턴
				obj.addProperty("url", "https://localhost:3000/data/images/" + nname);
				nname = null;
				oname = null;
				ext = null;
			}
			
			out.println(obj);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
