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
			pstmt.setInt(1, Book.getBookId());
			pstmt.setString(2, Book.getTitle());
			pstmt.setString(3, Book.getPublishMonth());
			pstmt.setInt(4, Book.getPrice());
			pstmt.setInt(5, Book.getDiscountRate());
			pstmt.setInt(6, Book.getPublisherId());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// ���� ����
	// ������Ʈ ������ ���� �����ϱ�
	public static boolean updateBook(int bookId, String bookTitle) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(propertiesInfo.getProperty("BookDAO.updatequery"));
			pstmt.setString(1, bookTitle);
			pstmt.setInt(2, bookId);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// ���� ����
	public static boolean deleteBook(int BookId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("BookDAO.deletequery"));
			pstmt.setInt(1, BookId);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static BookDTO getBook(String BookId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BookDTO Book = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(propertiesInfo.getProperty("BookDAO.getquery"));
			pstmt.setString(1, BookId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				Book = new BookDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4), rset.getInt(5),
						rset.getInt(6));
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
				list.add(new BookDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4), rset.getInt(5),
						rset.getInt(6)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
