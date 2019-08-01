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
	
	public static boolean addPublisher(PublisherDTO publisher) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
<<<<<<< HEAD
			pstmt = con.prepareStatement(propertiesInfo.getProperty("PublisherDAO.addquery")); 
			pstmt.setInt(1, publisher.getPublisherId());
			pstmt.setString(2, publisher.getPublisherName());
=======
			pstmt = con.prepareStatement(propertiesInfo.getProperty("PublisherDAO.addquery"));
			pstmt.setString(1, publisher.getPublisherName());
>>>>>>> 677505e638b72f011ee2c40e06e4093feaca3157
			
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
	public static boolean updatePublisher(int PublisherId, String publisherName) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(propertiesInfo.getProperty("PublisherDAO.updatequery"));
			pstmt.setString(1, publisherName);
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
	public static boolean deletePublisher(int publisherId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("PublisherDAO.deletequery"));
			pstmt.setInt(1, publisherId);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static PublisherDTO getPublisher(int publisherId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		PublisherDTO Publisher = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("PublisherDAO.getquery"));
			pstmt.setInt(1, publisherId);
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
