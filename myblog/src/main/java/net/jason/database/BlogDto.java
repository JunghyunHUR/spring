package net.jason.database;

import java.sql.Timestamp;

import lombok.Data;

/*
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
 */
public class BlogDto {
   
	private int num;
	private String title;
	private String content;
    int imgct;
    private String writer;
    private Timestamp wdate;
    private String categorya;
    private String categoryb;
    private int imname;
    
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getImgct() {
		return imgct;
	}
	public void setImgct(int imgct) {
		this.imgct = imgct;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Timestamp getWdate() {
		return wdate;
	}
	public void setWdate(Timestamp wdate) {
		this.wdate = wdate;
	}
	public String getCategorya() {
		return categorya;
	}
	public void setCategorya(String categorya) {
		this.categorya = categorya;
	}
	public String getCategoryb() {
		return categoryb;
	}
	public void setCategoryb(String categoryb) {
		this.categoryb = categoryb;
	}
	public int getImname() {
		return imname;
	}
	public void setImname(int imname) {
		this.imname = imname;
	}
	
}
