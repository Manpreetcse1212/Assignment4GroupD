<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.groupd.assignment4.beans.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:pink !important">
	<h2>Update Book</h2>
	<br>
	<form action="BookServlet" method="post">
		<input type="hidden" name="action" value="update" />Book ID : <input
			type="text" name="book-id" /> <br> Title : <input type="text"
			name="title" /> <br>Author : <input type="text" name="author" />
		<br>Availability : <input type="text" name="available" /> <br>Price
		: <input type="text" name="price" /> <br> Publisher ID : <input
			type="text" name="pub-id" /> <br> <input type="submit"
			value="update" />
	</form>
	<br>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author</th>
				<th>Available</th>
				<th>Price</th>
				<th>Publisher ID</th>
			</tr>
		</thead>
		<tbody>
			<%
			ArrayList<Book> book = (ArrayList<Book>) session.getAttribute("book");
			if (book != null) {
				for (int i = 0; i < book.size(); i++) {
					Book obj = book.get(i);
			%>
			<tr>
				<td><%=obj.getBookId()%></td>
				<td><%=obj.getTitle()%></td>
				<td><%=obj.getAuthor()%></td>
				<td><%=obj.getAvailable()%></td>
				<td><%=obj.getPrice()%></td>
				<td><%=obj.getPubId()%></td>
			</tr>
			<%
			}
			}
			%>
		</tbody>
	</table>
</body>
</html>