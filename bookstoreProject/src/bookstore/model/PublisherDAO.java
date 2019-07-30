package bookstore.model;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import bookstore.model.dto.PublisherDTO;
import bookstore.model.util.DBUtil;

public class PublisherDAO {
	static Properties propertiesInfo = new Properties();
	static {
		try {
			propertiesInfo.load(new FileInputStream("dao.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean addPublisher(PublisherDTO Publisher) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("PublisherDAO.addquery"));
			pstmt.setInt(1, Publisher.getPublisherId());
			pstmt.setString(2, Publisher.getPublisherName());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	//수정 로직
	// 프로젝트 명으로 내용 수정하기
	public static boolean updatePublisher(int PublisherId, String PublisherName) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(propertiesInfo.getProperty("PublisherDAO.updatequery"));
			pstmt.setString(1, PublisherName);
			pstmt.setInt(2, PublisherId);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	


	//삭제 로직
	public static boolean deletePublisher(int PublisherId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("PublisherDAO.deletequery"));
			pstmt.setInt(1, PublisherId);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static PublisherDTO getPublisher(String PublisherId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		PublisherDTO Publisher = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("PublisherDAO.getquery"));
			pstmt.setString(1, PublisherId);
			rset = pstmt.executeQuery();
			if(rset.next()){
				Publisher = new PublisherDTO(rset.getInt(1), rset.getString(2));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return Publisher;
	}

	public static ArrayList<PublisherDTO> getAllPublishers() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<PublisherDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("PublisherDAO.getAllquery"));
			rset = pstmt.executeQuery();
			
			list = new ArrayList<PublisherDTO>();
			while(rset.next()){
				list.add(new PublisherDTO(rset.getInt(1), rset.getString(2)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
