package net.jason.database;

import java.util.List;

public class BlogImpl implements BlogConfig {

	BlogDao dao = BlogDao.getInterface();
	
	@Override
	public int bListCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BlogDto> bList() {
		return dao.bList();
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
