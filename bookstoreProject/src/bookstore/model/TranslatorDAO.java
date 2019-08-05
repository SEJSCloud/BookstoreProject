package bookstore.model;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import bookstore.model.dto.TranslatorDTO;
import bookstore.model.util.DBUtil;

public class TranslatorDAO {
	static Properties propertiesInfo = new Properties();
	static {
		try {
			propertiesInfo.load(new FileInputStream("dao.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean addTranslator(TranslatorDTO translator) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("TranslatorDAO.addquery"));
			pstmt.setString(1, translator.getTranslatorName());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static boolean addTranslator2() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("TranslatorDAO.addquery2"));
			
			int result = pstmt.executeUpdate();
			
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static boolean addTranslatorName(TranslatorDTO translator) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("TranslatorDAO.updatetranslatornamequery"));
			pstmt.setString(1, translator.getTranslatorName());
			pstmt.setString(2, translator.getTranslatorName());
			
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
	public static boolean updateTranslator(int translatorId, String translatorName) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(propertiesInfo.getProperty("TranslatorDAO.updatequery"));
			pstmt.setString(1, translatorName);
			pstmt.setInt(2, translatorId);
			
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
	public static boolean deleteTranslator(int translatorId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("TranslatorDAO.deletequery"));
			pstmt.setInt(1, translatorId);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static TranslatorDTO getTranslator(int translatorId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		TranslatorDTO Translator = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("TranslatorDAO.getquery"));
			pstmt.setInt(1, translatorId);
			rset = pstmt.executeQuery();
			if(rset.next()){
				Translator = new TranslatorDTO(rset.getInt(1), rset.getString(2));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return Translator;
	}

	public static ArrayList<TranslatorDTO> getAllTranslators() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<TranslatorDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("TranslatorDAO.getAllquery"));
			rset = pstmt.executeQuery();
			
			list = new ArrayList<TranslatorDTO>();
			while(rset.next()){
				list.add(new TranslatorDTO(rset.getInt(1), rset.getString(2)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
