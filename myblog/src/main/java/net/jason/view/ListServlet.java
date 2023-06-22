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

@WebServlet("/list")
public class ListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//file db���� blog_num �� 0�� �÷��� �˻�
		//�ش� ������ ����
		//db�� �����.
		//blog ����� �˻�
		//��Ͽ� �´� file�� �˻�
		
		String links = "C:\\Junghyun\\REACT\\myblog\\public\\data\\images\\";	//������ �ִ� ���;
		String fdata;
		String flink;
		
		res.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		BlogImpl blog = new BlogImpl();
		List<FileDto> flists = blog.fileList(0);
		if(flists.size() > 0) {
			for(FileDto flist : flists) {
				fdata = flist.getNewname();
				flink = links + fdata;
				
				File file = new File(flink);
				if(file.exists()) {
					file.delete();
					System.out.println(flink + "- ���� ����");
				}
				blog.fileDelete(flist.getNum());
				System.out.println("db���� ����");
			}
		}	//������ ���� �����ϴ� �κ�
		
		List<BlogDto> lists = blog.bList();
		
		String content = null;
		for(BlogDto list : lists) {
			try {
				content = removeHtmlTag(list.getContent());
				list.setContent(content);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/list.jsp");
		req.setAttribute("list", lists);
		
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
