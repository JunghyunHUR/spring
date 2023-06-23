package net.jason.view;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.jason.database.BlogDto;
import net.jason.database.BlogImpl;
import net.jason.database.FileDto;
import net.jason.util.Pagination;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//file db에서 blog_num 가 0인 컬럼을 검색
		//해당 파일을 삭제
		//db도 지운다.
		//blog 목록을 검색
		//목록에 맞는 file을 검색
		
		String links = "C:\\Junghyun\\REACT\\myblog\\public\\data\\images\\";	//파일이 있는 경로;
		String fdata;
		String flink;
		String page = req.getParameter("page");
		int pg =1;
		if(page != null) {
			pg = Integer.parseInt(page);
		}
		
		res.setContentType("text/plain;charset=UTF-8");
		
		BlogImpl blog = new BlogImpl();
		PrintWriter out = res.getWriter();
		Pagination pagination = new Pagination();
		
		List<FileDto> flists = blog.fileList(0);
		if(flists.size() > 0) {
			for(FileDto flist : flists) {
				fdata = flist.getNewname();
				flink = links + fdata;
				
				File file = new File(flink);
				if(file.exists()) {
					file.delete();
					System.out.println(flink + "- 삭제 성공");
				}
				blog.fileDelete(flist.getNum());
				System.out.println("db삭제 성공");
			}
		}	//쓰레기 파일 삭제하는 부분
		
		List<BlogDto> lists = blog.bList(pg);
		
		String content = null;
		for(BlogDto list : lists) {
			try {
				content = removeHtmlTag(list.getContent());
				list.setContent(content);
			}catch(Exception e) {
				e.printStackTrace();
			}
			List<FileDto> fdto = blog.fileList(list.getNum());
			if(fdto.size() > 0) {
				String filename = fdto.get(0).getNewname();
				String fileExt = fdto.get(0).getExt();
				int fileSize = (int)fdto.get(0).getFilesize();
				
				list.setFileName(filename);
				list.setFileSize(fileSize);
				list.setFileExt(fileExt);
			}
		}

		int totalCnt = blog.bListCount();
		pagination.setPageInfo(pg, 12, 15, totalCnt);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/list.jsp");
		req.setAttribute("list", lists);
		req.setAttribute("pagination", pagination);
		requestDispatcher.forward(req, res);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public String removeHtmlTag(String html) throws Exception{
		return html.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
	   
	}

}
