package bookstore.model;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import bookstore.model.util.DBUtil;

public class WritingDAO {

	static Properties propertiesInfo = new Properties();
	static {
		try {
			propertiesInfo.load(new FileInputStream("dao.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<String> getBookWriteInfo(int authorid) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<String> authorName = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("WritingDAO.getBookWriteInfo"));

			pstmt.setInt(1, authorid);
			rset = pstmt.executeQuery();

			authorName = new ArrayList<String>();
			if (rset.next()) {
				authorName.add(rset.getString(1));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return authorName;
	}

	public static ArrayList<String> getAuthorWriteInfo(int bookId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<String> authorName = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("WritingDAO.getAuthorWriteInfo"));

			pstmt.setInt(1, bookId);
			rset = pstmt.executeQuery();

			authorName = new ArrayList<String>();
			if (rset.next()) {
				authorName.add(rset.getString(1));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return authorName;
	}

}
