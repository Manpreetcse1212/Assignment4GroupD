<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Borrow List</h1>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Book Id</th>
		<th>Member Id</th>
		<th>Issue Date</th>
		<th>Return Date</th>
		<th>Due Date</th>
		<th></th>
	</tr>
	<c:forEach var="borrow" items="${list}">
		<tr>
			<td>${borrow.bookId}</td>
			<td>${borrow.memberId}</td>
			<td>${borrow.issueDate}</td>
			<td>${borrow.returnDate}</td>
			<td>${borrow.dueDate}</td>
			<td><a href="deleteborrow/${borrow.bookId}/${borrow.memberId}">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<br />
<a href="borrowform">Add Borrow</a>