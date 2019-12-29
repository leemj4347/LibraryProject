package www.lmj.com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import www.lmj.com.db.DBConn;
import www.lmj.com.vo.Book;

public class BookController {
	Logger logger = Logger.getLogger(getClass().getSimpleName());
	
	public List<Book> selectList(){
		List<Book> result = new ArrayList<Book>();
		
		DBConn db = new DBConn();
		try (Connection conn = db.getConnection()){
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM Book");
			
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Book item = new Book();
				item.setId(rs.getInt("id"));
				item.setTitle(rs.getString("title"));
				item.setAuthor(rs.getString("author"));
				item.setRegist(rs.getString("regist"));
				item.setWdate(rs.getString("wdate"));
				item.setGenre(rs.getString("genre"));
				
				result.add(item);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

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
			
			logger.info(pstmt.toString());
			
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
