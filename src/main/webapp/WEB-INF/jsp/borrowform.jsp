<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.groupd.assignment4.beans.Borrow"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:pink !important">
	<h2>Add Borrow</h2>
	<form action="BorrowServlet" method="post">
		Book ID : <input type="text" name="bookId" /> <br>Member ID : <input
			type="text" name="memberId" /> <br>Issue Date : <input
			type="date" name="issueDate" /> <br>Return Date : <input
			type="date" name="returnDate" /> <br>Due Date : <input
			type="date" name="dueDate" /> <br> <input type="submit"
			value="insert" />
	</form>
	<br>
	<br>
	<table>
		<thead>
			<tr>
				<th>Book Name</th>
				<th>Member Name</th>
				<th>Issue Date</th>
				<th>Return Date</th>
				<th>Due Date</th>
			</tr>
		</thead>
		<tbody>
			<%
			ArrayList<Borrow> borrow = (ArrayList<Borrow>) session.getAttribute("borrow");
			if (borrow != null) {
				for (int i = 0; i < borrow.size(); i++) {
					Borrow obj = borrow.get(i);
			%>
			<tr>
				<td><%=obj.getBookName()%></td>
				<td><%=obj.getMemberName()%></td>
				<td><%=obj.getIssueDate()%></td>
				<td><%=obj.getReturnDate()%></td>
				<td><%=obj.getDueDate()%></td>
			</tr>
			<%
			}
			}
			%>
		</tbody>
	</table>
</body>
</html>