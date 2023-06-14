package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class BBSDDL {
	
	public boolean insert(MembersDTO mdto, BBSDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			String query = "insert into bbs"
							+"(userid, userpass, username, useremail, uip, title, content)"
							+"values"
							+"(?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mdto.getUserid());
			pstmt.setString(2, mdto.getUserpass());
			pstmt.setString(3, mdto.getUsername());
			pstmt.setString(4, mdto.getUseremail());
			pstmt.setString(5, mdto.getUip());
			pstmt.setString(6, dto.getTitle());
			pstmt.setString(7, dto.getContent());
			
			flag = pstmt.executeUpdate();
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				}catch(SQLException e) {}
		}
		if(flag > 0) { //success
			return true;
		}else {	//failed
			return false;
		}
	}
	//All select
	public static int getAllSelect() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		int allCount = 0;
		String sql = null;
		sql = "select count(*) from bbs";
		
		try {
			conn = new DBConnect().getConn();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				allCount = rs.getInt(1);
			}
			//System.out.println(allCount);
		}catch(SQLException e) {
			
		}finally {
			try {
				if(rs != null) rs.close();
				if(st != null) st.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
		return allCount;
	}
		
	public static Vector<BBSDTO> getSelect(int limitNum, int listNum){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		sql = "select * from bbs order by num desc limit ?, ?";
		
		Vector<BBSDTO> data = new Vector<>();
		conn = new DBConnect().getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, limitNum);
			pstmt.setInt(2, listNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BBSDTO bb = new BBSDTO();
				bb.setNum(rs.getInt("num"));
				bb.setTitle(rs.getString("title"));
				bb.setUserid(rs.getString("userid"));
				bb.setCount(rs.getInt("count"));
				bb.setWdate(rs.getString("wdate"));
				bb.setReply(rs.getInt("reply"));
				
				data.add(bb);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
		return data;
	}
	
	public int count(int num, int count) {		
		Connection conn = null;
		PreparedStatement pstmt = null;
		count = count + 1;
		int rs = 0;
		
		try {
			conn = new DBConnect().getConn();
			String sql = "update bbs set count="+ count +" where num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				}catch(SQLException e) {}
		}
		return rs;
	}
	
	
	public int reply(int num, int reply) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		reply = reply + 1;
		int rs = 0;
		
		try {
			conn = new DBConnect().getConn();
			String sql = "update bbs set reply="+ reply +" where num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				}catch(SQLException e) {}
		}
		return rs;
	}
}
