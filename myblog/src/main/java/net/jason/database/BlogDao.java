package net.jason.database;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BlogDao implements BlogConfig {
	
	private static BlogDao dao;
	private BlogDao() {};
	
	public static BlogDao getInterface() {
		if(dao == null) dao = new BlogDao();
		return dao;
	}
	
	//SQL 세션 열기
	SqlSessionFactory sft = SqlMapSessionFactory.getSqlSessionFactory();
	
	@Override
	public int bListCount() {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Bupdate(BlogDto blogDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Binsert(BlogDto blogDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Bdelete(Integer num) {
		// TODO Auto-generated method stub
		return 0;
	}

}
