package bookstore.model;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import bookstore.model.dto.AuthorDTO;
import bookstore.model.util.DBUtil;

public class AuthorDAO {
	static Properties propertiesInfo = new Properties();
	static {
		try {
			propertiesInfo.load(new FileInputStream("dao.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean addAuthor(AuthorDTO Author) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("AuthorDAO.addquery"));
			pstmt.setInt(1, Author.getAuthorId());
			pstmt.setString(2, Author.getAuthorName());
			
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
	public static boolean updateAuthor(int AuthorId, String AuthorName) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(propertiesInfo.getProperty("AuthorDAO.updatequery"));
			pstmt.setString(1, AuthorName);
			pstmt.setInt(2, AuthorId);
			
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
	public static boolean deleteAuthor(int AuthorId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("AuthorDAO.deletequery"));
			pstmt.setInt(1, AuthorId);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static AuthorDTO getAuthor(String AuthorId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		AuthorDTO Author = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("AuthorDAO.getquery"));
			pstmt.setString(1, AuthorId);
			rset = pstmt.executeQuery();
			if(rset.next()){
				Author = new AuthorDTO(rset.getInt(1), rset.getString(2));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return Author;
	}

	public static ArrayList<AuthorDTO> getAllAuthors() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AuthorDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("AuthorDAO.getAllquery"));
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AuthorDTO>();
			while(rset.next()){
				list.add(new AuthorDTO(rset.getInt(1), rset.getString(2)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
