package net.jason.spbbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import net.jason.spbbs.dto.SpDto;
import net.jason.spbbs.util.Static;
//db 접근 클래스
public class SpDao {

	DataSource dataSource;
	JdbcTemplate template = null;
 
	//생성자에서 DB 접속
	public SpDao() {
		//나중에 다 지움   
		try {
       
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/spbbs");
       
		}catch(NamingException e) {
			e.printStackTrace();
		}
		//여기까지
		template = Static.template;
	}
 
 //글쓰기
	public void write(String uname, String upass, String title, String content) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();

		template.update(new PreparedStatementCreator() {
       
			@Override
			public PreparedStatement createPreparedStatement(Connection con) 
				throws SQLException {
				String sql = "insert into spboard (uname, upass, title, content) values (?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, uname);
				pstmt.setString(2, upass);
				pstmt.setString(3, title);
				pstmt.setString(4, content);
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					groupUpdate(rs.getInt(1));
				}
				return pstmt;
			}
		}, keyHolder);
		int idx = keyHolder.getKey().intValue();
		groupUpdate(idx);
	}
 
	private void groupUpdate(int num) {
		String sql ="update spboard set s_group = ? where num = ?";
		template.update(sql, new PreparedStatementSetter() {
    
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException{
				pstmt.setInt(1, num);
				pstmt.setInt(2, num);
			}
		});    
	}
 
 //답글쓰기
	public SpDto reply(String cNum) {
		int iNum = Integer.parseInt(cNum);
		String sql = "select * from spboard where num = " + iNum;
		return template.queryForObject(sql, new BeanPropertyRowMapper<SpDto>(SpDto.class));
		/*
		SpDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select * from spboard where num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, iNum);
			rs = pstmt.executeQuery();
       
			//dto에 담기
			if(rs.next()) {
				dto = new SpDto();
				int num = rs.getInt("num");
				int s_group = rs.getInt("s_group");
				int s_step = rs.getInt("s_step");
				int s_indent = rs.getInt("s_indent");

				dto.setNum(num);
				dto.setS_group(s_group);
				dto.setS_step(s_step);
				dto.setS_indent(s_indent);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception ee) {}
		}
    
		return dto;
		 */
		}
	//답글 등록하기
	public void replyok(int s_group, int s_step, int s_indent, String uname, String upass, String title, String content) {
		
		String sql = "insert into spboard (s_group, s_step, s_indent, uname, upass, title, content) values (?,?,?,?,?,?,?)";
		template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, s_group);
				ps.setInt(2, s_step);
				ps.setInt(3, s_indent);
				ps.setString(4, uname);
				ps.setString(5, upass);
				ps.setString(6, title);
				ps.setString(7, content);	
			}
		});
		/*
		replyUpdate(s_group, s_step);
    
		String sql = "insert into spboard (s_group, s_step, s_indent, uname, upass, title, content) values (?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, s_group);
			pstmt.setInt(2, s_step);
			pstmt.setInt(3, s_indent);
			pstmt.setString(4, uname);
			pstmt.setString(5, upass);
			pstmt.setString(6, title);
			pstmt.setString(7, content);
			pstmt.executeUpdate();
       
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception ee) {}
		}
		 */
	}
 
	//글 수정하기
	public SpDto update(String cNum) {
		int iNum = Integer.parseInt(cNum);
		String sql = "select * from spboard where num = " + iNum;
		return template.queryForObject(sql, new BeanPropertyRowMapper<SpDto>(SpDto.class));
		
		/*
		SpDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select * from spboard where num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, iNum);
			rs = pstmt.executeQuery();
			
			//dto에 담기
			if(rs.next()) {
				dto = new SpDto();
				int num = rs.getInt("num");
				String uname = rs.getString("uname");
				String upass = rs.getString("upass");
				String title = rs.getString("title");
				String content = rs.getString("content");

				dto.setNum(num);
				dto.setUname(uname);
				dto.setUpass(upass);
				dto.setTitle(title);
				dto.setContent(content);
			}         
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception ee) {}
		}

		return dto;
		 */
	}
 
	public void updateok(String num, String uname, String upass, String title, String content) {

		int iNum = Integer.parseInt(num);
		String sql = "update spboard set uname=?, upass=?, title=?, content=? where num = ?";
		template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, uname);
				ps.setString(2, upass);
				ps.setString(3, title);
				ps.setString(4, content);
				ps.setInt(5, iNum);
			}
		});
		/*
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, upass);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			pstmt.setInt(5, iNum);
			pstmt.executeUpdate();
      
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception ee) {}         
		}

		 */
	}
 /*
	private void replyUpdate(int s_group, int s_step) {
		String sql = "update spboard set s_step = s_step + 1 where s_group = ? and s_step >= ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);         
			pstmt.setInt(1, s_group);
			pstmt.setInt(2, s_step);
			pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception ee) {}
		}
	}
  */
 
	//본문 보기
	public SpDto detail(String cNum) {
    
		int iNum = Integer.parseInt(cNum);
		hitAdd(iNum);  //조회수 증가
		String sql = "select * from spboard where num = " + iNum;
		return template.queryForObject(sql, new BeanPropertyRowMapper<SpDto>(SpDto.class));

	}
 
 //데이터를 받아서 SpDto에 담음
	public ArrayList<SpDto> list(String pg){
    
		int listCount = 10;
		int page = Integer.parseInt(pg);
		int min = ( page -1 ) * listCount;
		String limit = " limit " + min + " , " + listCount;

		String sql = "select * from spboard order by s_group desc, s_step asc" + limit;
		return (ArrayList<SpDto>) template.query(sql, new BeanPropertyRowMapper<SpDto>(SpDto.class));

	} //list
 
	public int totalRecord() {
		String sql = "select count(*) from spboard";
		return template.queryForObject(sql, Integer.class);
	}
 
	public int totalRecord(String where) {
		String sql = "select count(*) from spboard where 1 and " + where;
		return template.queryForObject(sql, Integer.class);
	}
 
	public void delete(String num) {
    
		int iNum = Integer.parseInt(num);
		String sql = "delete from spboard where num = ?";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setInt(1, iNum);
			}
		});
		
		/*
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {         
			conn = dataSource.getConnection();
			String sql = "delete from spboard where num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, iNum);
			pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception eee) {}
		}
		 */
	}
 
//문장보기 hit 업데이트
	private void hitAdd(int num) {
		String sql = "update spboard set hit = hit + 1 where num = ?";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, num);
			}
		});
	}
}