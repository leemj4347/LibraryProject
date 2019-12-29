<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책정보 입력하기</title>
</head>
<body>
	<form action="./write.jsp">
		<table border = "1" style="border-collapse:collapse;">
			<thead>
				<tr>
					<th colspan="2">책 정보 입력하기</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" placeholder="제목을 입력하세요"/></td>
				</tr>
				<tr>
					<th>저자</th>
					<td><input type="text" name="author"placeholder="저자를 입력하세요"/></td>
				</tr>
				<tr>
					<th>발행일</th>
					<td><input type="text" name="regist"placeholder="발행일을 입력하세요"/></td>
				</tr>
				<tr>
					<th>장르</th>
					<td><input type="text" name="genre"placeholder="장르를 입력하세요"/></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan ="2">
						<input type="submit" value="저장" style="width:100%;"/>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>

</body>
</html>