package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class MemberDDL {
	
	//Method for insert at the table name of Members
	public boolean insert(MembersDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			//conn = DBConnect.initConnection(); // get conn from Object "Connection"
			conn = new DBConnect().getConn();
			String query = "insert into members"
							+"(userid, userpass, username, useremail, postcode, addr, detailaddr, tel, uip)"
							+"values"
							+"(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getUserpass());
			pstmt.setString(3, dto.getUsername());
			pstmt.setString(4, dto.getUseremail());
			pstmt.setInt(5, dto.getPostcode());
			pstmt.setString(6, dto.getAddr());
			pstmt.setString(7, dto.getDetailaddr());
			pstmt.setString(8, dto.getTel());
			pstmt.setString(9, dto.getUip());
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
	
	//update Member method
	public boolean update(MembersDTO dto, String user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			String query = "";
			String userpass = (String) dto.getUserpass();
			if(userpass == null || userpass.isEmpty()) {
				query = "update members set username=?, useremail=?, postcode=?, addr=?, detailaddr=?, tel=?, uip=?, wdate=? where userid=?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, dto.getUsername());
				pstmt.setString(2, dto.getUseremail());
				pstmt.setInt(3, dto.getPostcode());
				pstmt.setString(4, dto.getAddr());
				pstmt.setString(5, dto.getDetailaddr());
				pstmt.setString(6, dto.getTel());
				pstmt.setString(7, dto.getUip());
				pstmt.setString(8, dto.getWdate());
				pstmt.setString(9, user);
			}else {
				query = "update members set userpass=?, username=?, useremail=?, postcode=?, addr=?, detailaddr=?, tel=?, uip=?, wdate=? where userid=?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, dto.getUserpass());
				pstmt.setString(2, dto.getUsername());
				pstmt.setString(3, dto.getUseremail());
				pstmt.setInt(4, dto.getPostcode());
				pstmt.setString(5, dto.getAddr());
				pstmt.setString(6, dto.getDetailaddr());
				pstmt.setString(7, dto.getTel());
				pstmt.setString(8, dto.getUip());
				pstmt.setString(9, dto.getWdate());
				pstmt.setString(10, user);
			}
//			System.out.println(pstmt);
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
	
	//overload update Member method
	public int update(int level, int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			String sql = "update members set level = ? where num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, level);
			pstmt.setInt(2, num);
			flag = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
			return flag;
	}
	
	//All select
	public static int getAllSelect() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		int allCount = 0;
		String sql = null;
		sql = "select count(*) from members";
		
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
	
	//select
	public static Vector<MembersDTO> getSelect(String str){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from members where userid=?";
		
		Vector<MembersDTO> data = new Vector<>();
		conn = new DBConnect().getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MembersDTO mb = new MembersDTO();
				mb.setNum(rs.getInt("num"));
				mb.setUserid(rs.getString("userid"));
				mb.setUserpass(rs.getString("userpass"));
				mb.setUsername(rs.getString("username"));
				mb.setUseremail(rs.getString("useremail"));
				mb.setPostcode(rs.getInt("postcode"));
				mb.setAddr(rs.getString("addr"));
				mb.setDetailaddr(rs.getString("detailaddr"));
				mb.setTel(rs.getString("tel"));
				mb.setLevel(rs.getInt("level"));
				mb.setUip(rs.getString("uip"));
				mb.setWdate(rs.getString("wdate"));
				data.add(mb);
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
	
	//select overload
	public static Vector<MembersDTO> getSelect(String str1, String str2, int opt){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		if(opt == 1) {
			sql = "select userid, userpass from members where username=? and useremail = ?";			
		}else if(opt == 2){
			sql = "select userid, userpass from members where userid = ? and useremail = ?";
		}
		
		Vector<MembersDTO> data = new Vector<>();
		conn = new DBConnect().getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str1);
			pstmt.setString(2, str2);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MembersDTO mb = new MembersDTO();
				mb.setUserid(rs.getString("userid"));
				mb.setUserpass(rs.getString("userpass"));
				data.add(mb);
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
	
	//목록 select overload
	public static Vector<MembersDTO> getSelect(int limitNum, int listNum){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		sql = "select * from members order by num desc limit ?, ?";
		
		Vector<MembersDTO> data = new Vector<>();
		conn = new DBConnect().getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, limitNum);
			pstmt.setInt(2, listNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MembersDTO mb = new MembersDTO();
				mb.setNum(rs.getInt("num"));
				mb.setUserid(rs.getString("userid"));
				mb.setUserpass(rs.getString("userpass"));
				mb.setUsername(rs.getString("username"));
				mb.setUseremail(rs.getString("useremail"));
				mb.setPostcode(rs.getInt("postcode"));
				mb.setAddr(rs.getString("addr"));
				mb.setDetailaddr(rs.getString("detailaddr"));
				mb.setTel(rs.getString("tel"));
				mb.setLevel(rs.getInt("level"));
				mb.setUip(rs.getString("uip"));
				mb.setWdate(rs.getString("wdate"));
				data.add(mb);
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
	
	
	//login success or failed
	public int checkLogin(MembersDTO dto) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int checkUser = 0;
		String sql = "select * from members where userid = ? and userpass = ?";
		try {
			//conn = DBConnect.initConnection(); //get conn from Connection Object
			conn = new DBConnect().getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUserid());
			ps.setString(2, dto.getUserpass());
			rs = ps.executeQuery();
			if(rs.next()) {
				checkUser = rs.getInt("level");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
		return checkUser;
	}
	
//	//find id or password
//	public String findId(String username, String useremail) {
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		String sql = "", id = "";
//		
//		sql = "select userid from members where username = ? and useremail = ?";
//		try {
//			conn = new DBConnect().getConn();
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, username);
//			ps.setString(2, useremail);
//			rs = ps.executeQuery();
//			if(rs.next()) {
//				id = rs.getString("userid");
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(rs != null) rs.close();
//				if(ps != null) ps.close();
//				if(conn != null) conn.close();
//			}catch(SQLException e) {}
//		}
//		return id;
//	}
//	
//	public String findPwd(String username, String userid, String useremail) {
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		String sql = "", pwd = "";
//		
//		sql = "select userpass from members where username = ? and userid = ? and useremail = ?";
//		try {
//			conn = new DBConnect().getConn();
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, username);
//			ps.setString(2, userid);
//			ps.setString(3, useremail);
//			rs = ps.executeQuery();
//			if(rs.next()) {
//				pwd = rs.getString("userpass");
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(rs != null) rs.close();
//				if(ps != null) ps.close();
//				if(conn != null) conn.close();
//			}catch(SQLException e) {}
//		}
//		return pwd;
//	} 
}