package bookstore.model;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import bookstore.model.dto.BookDTO;
import bookstore.model.util.DBUtil;

public class BookDAO {
	
	static Properties propertiesInfo = new Properties();
	static {
		try {
			propertiesInfo.load(new FileInputStream("dao.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean addBook(BookDTO Book) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("BookDAO.addquery"));
			pstmt.setString(1, Book.getTitle());
			pstmt.setString(2, Book.getPublishMonth());
			pstmt.setString(3, Book.getPrice());
			pstmt.setInt(4, Book.getDiscountRate());
			pstmt.setString(5, Book.getAuthorId());
			pstmt.setString(6, Book.getTranslatorId());
			pstmt.setString(7, Book.getPublisherId());
			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 수정 로직
	// 프로젝트 명으로 내용 수정하기
	public static boolean updateBook(String PublishMonth, int bookId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(propertiesInfo.getProperty("BookDAO.updatequery"));
			pstmt.setInt(1, bookId);
			pstmt.setString(2, PublishMonth);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 삭제 로직
	public static boolean deleteBook(int bookId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("BookDAO.deletequery"));
			pstmt.setInt(1, bookId);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static boolean authorDeleteBook(int authorId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("BookDAO.authordeletequery"));
			pstmt.setInt(1, authorId);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static boolean publisherDeleteBook(int publisherId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("BookDAO.publisherdeletequery"));
			pstmt.setInt(1, publisherId);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static boolean translatorDeleteBook(int translatorId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("BookDAO.translatordeletequery"));
			pstmt.setInt(1, translatorId);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static BookDTO getBook(int BookId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BookDTO Book = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("BookDAO.getquery"));
			pstmt.setInt(1, BookId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				Book = new BookDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getInt(5), rset.getString(6) ,rset.getString(7), rset.getString(8));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return Book;
	}

	public static ArrayList<BookDTO> getAllBooks() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BookDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("BookDAO.getAllquery"));
			rset = pstmt.executeQuery();

			list = new ArrayList<BookDTO>();
			while (rset.next()) {
				list.add(new BookDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getInt(5), rset.getString(6) ,rset.getString(7), rset.getString(8)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	

}
