package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommentDDL {
	
	public boolean insert(CommentDTO cdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			String query = "insert into comment"
							+"(username, userpass, comment, uip, bbsnum)"
							+"values"
							+"(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, cdto.getUsername());
			pstmt.setString(2, cdto.getUserpass());
			pstmt.setString(3, cdto.getComment());
			pstmt.setString(4, cdto.getUip());
			pstmt.setInt(5, cdto.getBbsnum());
			
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
}
