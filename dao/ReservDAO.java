package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbcon.Dbconn;
import dto.ReservDTO;

public class ReservDAO extends Dbconn {

	private static ReservDAO dao;
	private ReservDAO() {}
	static {
		dao=new ReservDAO();
	}
	public static ReservDAO getDao() {
		 return dao;
	}	
	
	//SelectAll
	public List<ReservDTO> showAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReservDTO> reservList = new ArrayList<ReservDTO>();
		
		try {
		con = getConnection();
		
		String sql = "select r_no, title, r_name, tel, r_loc, open_date, r_grade, r_date, alarm_date from reservation order by r_no";
		
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ReservDTO reservInfo = new ReservDTO();
				reservInfo.setR_no(rs.getInt("r_no"));
				reservInfo.setTitle(rs.getString("title"));
				reservInfo.setR_name(rs.getString("r_name"));
				reservInfo.setTel(rs.getString("tel"));
				reservInfo.setR_loc(rs.getString("r_loc"));
				reservInfo.setOpen_date(rs.getString("open_date").substring(0, 10));
				reservInfo.setR_grade(rs.getString("r_grade"));
				reservInfo.setR_date(rs.getString("r_date").substring(0, 10));
				reservInfo.setAlarm_date(rs.getString("alarm_date").substring(0, 10));
				reservList.add(reservInfo);
			}
 			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return reservList;
	}
	
	//Insert
	public int insertReserv(ReservDTO reserv) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int rows=0;
		
		try {
		con = getConnection();
		
		String sql = "insert into reservation(r_no, title, r_name, tel, r_loc, open_date, r_grade) values(SEQ_r_no.NEXTVAL,?,?,?,?,?,?)";
		
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,reserv.getTitle());
			pstmt.setString(2,reserv.getR_name());
			pstmt.setString(3,reserv.getTel());
			pstmt.setString(4,reserv.getR_loc());
			pstmt.setString(5,reserv.getOpen_date().substring(0, 10));
			pstmt.setString(6,reserv.getR_grade());

 			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		} return rows;
	}
	
	//Update
	public int updateReserv(ReservDTO reserv) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int rows=0;
		
		try {
		con = getConnection();
		
		String sql = "update reservation set title=?, R_name=?, Tel=?, R_loc=?, Open_date=?, R_grade=? where r_no=?";
		
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,reserv.getTitle());
			pstmt.setString(2,reserv.getR_name());
			pstmt.setString(3,reserv.getTel());
			pstmt.setString(4,reserv.getR_loc());
			pstmt.setString(5,reserv.getOpen_date().substring(0, 10));
			pstmt.setString(6,reserv.getR_grade());
			pstmt.setInt(7,reserv.getR_no());

 			rows=pstmt.executeUpdate();
 			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		} return rows;
	}
	
	//Delete
	public int deleteReserv(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int rows=0;
		
		try {
		con = getConnection();
		
		String sql = "delete from reservation where r_no=?";
		
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,no);

 			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		} return rows;
	}
	
	public ReservDTO selectNoReserv(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ReservDTO reserv=new ReservDTO();
		try {
			con = getConnection();
			
			String sql="select * from reservation where r_no=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,no);

			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				reserv=new ReservDTO();
				reserv.setTitle(rs.getString("title"));
				reserv.setR_grade(rs.getString("r_grade"));
				reserv.setOpen_date(rs.getString("open_date").substring(0, 10));
				reserv.setR_loc(rs.getString("r_loc"));
				reserv.setR_name(rs.getString("r_name"));
				reserv.setTel(rs.getString("tel"));
				reserv.setR_date(rs.getString("r_date"));
				reserv.setAlarm_date(rs.getString("alarm_date"));
				//reservList.add(reservInfo);

			}
		} catch (SQLException e) {
			System.out.println("[에러]selectNoReserv() 메소드의 SQL 오류"+e.getMessage());
		} finally {
			close(con,pstmt,rs);
		}
		return reserv;
	}
	
	//Search
	public List<ReservDTO> searchNo(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ReservDTO> reservList=new ArrayList<ReservDTO>();
		try {
			con=getConnection();
			String sql="select * from reservation where r_no like '%'||?||'%' order by r_no";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,no);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ReservDTO reservInfo=new ReservDTO();
				reservInfo.setR_no(rs.getInt("r_no"));
				reservInfo.setTitle(rs.getString("title"));
				reservInfo.setR_name(rs.getString("r_name"));
				reservInfo.setTel(rs.getString("tel"));
				reservInfo.setR_loc(rs.getString("r_loc"));
				reservInfo.setOpen_date(rs.getString("open_date").substring(0, 10));
				reservInfo.setR_grade(rs.getString("r_grade"));
				reservInfo.setR_date(rs.getString("r_date").substring(0, 10));
				reservInfo.setAlarm_date(rs.getString("alarm_date").substring(0, 10));
				reservList.add(reservInfo);
			}
			
		} catch (SQLException e) {
			System.out.println("[에러]searchName() 메소드의 SQL 오류"+e.getMessage());
		} finally {
			close(con,pstmt,rs);
		}
		return reservList;
	}
	




}
