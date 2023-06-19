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
	public int bUpdate(BlogDto blogDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int bInsert(BlogDto blogDto) {
		return dao.bInsert(blogDto);
	}

	@Override
	public int bDelete(Integer num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int fileInsert(FileDto fileDto) {
		
		return dao.fileInsert(fileDto);
	}

	@Override
	public int fileUpdate(FileDto fileDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int fileDelete(Integer num) {
		// TODO Auto-generated method stub
		return 0;
	}

}
