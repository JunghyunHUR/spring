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
@Data
public class BlogDto {
   
	private int num;
	private String title;
	private String content;
    int imgct;
    private String writer;
    private Timestamp wdate;
    private String categorya;
    private String categoryb;
	
}
