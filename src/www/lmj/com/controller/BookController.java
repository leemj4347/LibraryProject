package www.lmj.com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import www.lmj.com.db.DBConn;
import www.lmj.com.vo.Book;

public class BookController {

	public int insert(Book input) {
		int result = 0;
		
		DBConn db = new DBConn();
		try (Connection conn = db.getConnection()){
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO Book (title, author, regist, genre) VALUES(?,?,?,?)");
			
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, input.getTitle());
			pstmt.setString(2, input.getAuthor());
			pstmt.setString(3, input.getRegist());
			pstmt.setString(4, input.getGenre());
			
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
