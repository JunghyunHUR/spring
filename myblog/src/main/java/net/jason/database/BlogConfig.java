package net.jason.database;

import java.util.List;

public interface BlogConfig {

	public int bListCount();
	public List<BlogDto> bList();
	public BlogDto bView(Integer num);
	public int bUpdate(BlogDto blogDto);
	public int bInsert(BlogDto blogDto);
	public int bDelete(Integer num);
	
}
