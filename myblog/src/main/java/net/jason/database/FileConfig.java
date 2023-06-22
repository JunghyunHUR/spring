package net.jason.database;

import java.util.List;

public interface FileConfig {
	public int fileInsert(FileDto fileDto);
	public int fileUpdate(FileDto fileDto);
	public int fileDelete(Integer num);
	public List<FileDto> fileList(int blognum);

}
