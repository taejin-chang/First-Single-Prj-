package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbcon.Dbconn;
import dto.ManagerDTO;

public class ManagerDAO extends Dbconn {

	private static ManagerDAO dao;
	private ManagerDAO() {}
	static {
		dao=new ManagerDAO();
	}
	public static ManagerDAO getDao() {
		 return dao;
	}
	
	//show
	public List<ManagerDTO> showManager() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ManagerDTO> managerList = new ArrayList<ManagerDTO>();
		
		try {
		con = getConnection();
		
		String sql = "select m_id, m_pw, m_name, m_tel from reserv_manager";
		
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ManagerDTO managerInfo = new ManagerDTO();
				managerInfo.setM_id(rs.getString("m_id"));
				managerInfo.setM_pw(rs.getString("m_pw"));
				managerInfo.setM_name(rs.getString("m_name"));
				managerInfo.setM_tel(rs.getString("m_tel"));
			}
 			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return managerList;
	}
}

