package net.jason.database;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BlogDao implements BlogConfig, FileConfig {

	private static BlogDao dao;
	private BlogDao() {}
	
	public static BlogDao getInterface() {
		if(dao == null) dao = new BlogDao();
		return dao;
	}
	
	//SQL 세션 열기
	SqlSessionFactory sft = SqlMapSessionFactory.getSqlSessionFactory(); 
	
	@Override
	public int bListCount() {
		SqlSession session = sft.openSession();
		int rs = session.selectOne("net.jason.database.blogMapper.blogCount");
		session.close();
		return rs;
	}

	@Override
	public List<BlogDto> bList() {
        SqlSession session = sft.openSession();
        List<BlogDto> dto = session.selectList("net.jason.database.blogMapper.blogList");
        session.close();
		return dto;
	}

	@Override
	public BlogDto bView(Integer num) {
		SqlSession session = sft.openSession();
		BlogDto dto = session.selectOne("net.jason.database.blogMapper.blogView", num);
		session.close();
		return dto;
	}

	@Override
	public int bUpdate(BlogDto blogDto) {
		SqlSession session = sft.openSession();
		int rs = session.update("net.jason.database.blogMapper.blogUpdate", blogDto);
		session.close();
		return rs;
	}

	@Override
	public int bInsert(BlogDto blogDto) {
		SqlSession session = sft.openSession();
		session.insert("net.jason.database.blogMapper.blogInsert", blogDto);
		session.commit();
		session.close();
		return blogDto.getNum();
	}

	@Override
	public int bDelete(Integer num) {
		SqlSession session = sft.openSession();
		int rs = session.delete("net.jason.database.blogMapper.blogDelete", num);
		session.commit();
		session.close();
		return rs;
	}

	@Override
	public int fileInsert(FileDto fileDto) {
		SqlSession session = sft.openSession();
		session.insert("net.jason.database.fileMapper.insertFile", fileDto);
		session.commit();
		session.close();
		return fileDto.getNum();
	}

	@Override
	public int fileUpdate(FileDto fileDto) {
		SqlSession session = sft.openSession();
		if(fileDto.getBlog_num() > 0) {
			session.insert("net.jason.database.fileMapper.insertAfterUpdateFile", fileDto);
		}else {
			session.insert("net.jason.database.fileMapper.updateFile", fileDto);
		}
		session.commit();
		session.close();
		return fileDto.getNum();
	}

	@Override
	public int fileDelete(Integer num) {
		SqlSession session = sft.openSession();
		int rs = session.delete("net.jason.database.fileMapper.deleteFile", num);
		session.commit();
		session.close();
		return rs;
	}

	@Override
	public List<FileDto> fileList(int blognum) {
		SqlSession session = sft.openSession();
		List<FileDto> fdto = session.selectList("net.jason.database.fileMapper.listFile", blognum);
		session.close();
		return fdto;
	}

}
