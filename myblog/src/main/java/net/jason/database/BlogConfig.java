package net.jason.database;

import java.util.List;

public interface BlogConfig {
	
	public int bListCount();
	public List<BlogDto> bList();
	public BlogDto bView(Integer num);
	public int Bupdate(BlogDto blogDto);
	public int Binsert(BlogDto blogDto);
	public int Bdelete(Integer num);
	
}
