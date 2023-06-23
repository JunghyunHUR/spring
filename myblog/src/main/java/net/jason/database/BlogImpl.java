package net.jason.database;

import java.util.List;

public class BlogImpl implements BlogConfig, FileConfig {

	BlogDao dao = BlogDao.getInterface();
	
	@Override
	public int bListCount() {
		// TODO Auto-generated method stub
		return dao.bListCount();
	}

	@Override
	public List<BlogDto> bList(int page) {
		return dao.bList(page);
	}

	@Override
	public BlogDto bView(int num) {
		// TODO Auto-generated method stub
		return dao.bView(num);
	}

	@Override
	public int bUpdate(BlogDto blogDto) {
		// TODO Auto-generated method stub
		return dao.bUpdate(blogDto);
	}

	@Override
	public int bInsert(BlogDto blogDto) {
		return dao.bInsert(blogDto);
	}

	@Override
	public int bDelete(int num) {
		// TODO Auto-generated method stub
		return dao.bDelete(num);
	}

	@Override
	public int fileInsert(FileDto fileDto) {
		
		return dao.fileInsert(fileDto);
	}

	@Override
	public int fileUpdate(FileDto fileDto) {
		return dao.fileUpdate(fileDto);
	}

	@Override
	public int fileDelete(int num) {
		// TODO Auto-generated method stub
		return dao.fileDelete(num);
	}

	@Override
	public List<FileDto> fileList(int blognum) {
		// TODO Auto-generated method stub
		return dao.fileList(blognum);
	}

}
