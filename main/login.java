package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbcon.Dbconn;

public class login extends Dbconn {

	public int findIdPw(String m_id, String m_pw) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		con = getConnection();
		
		try {
			String sql = "select * from reserv_manager where m_id = ? and m_pw = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m_id);
			pstmt.setString(2, m_pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return 1;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return -1;
	}
}
