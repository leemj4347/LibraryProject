<%@page import="www.lmj.com.controller.BookController"%>
<%@page import="www.lmj.com.vo.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");//한글깨짐 방지

	String title = request.getParameter("title");
	String author = request.getParameter("author");
	String regist = request.getParameter("regist");
	String genre = request.getParameter("genre");
	
	Book book = new Book();
	book.setTitle(title);
	book.setAuthor(author);
	book.setRegist(regist);
	book.setGenre(genre);
	
	out.print(book.toString());
	
	BookController controller = new BookController();
	int result = controller.insert(book);
	
%>
