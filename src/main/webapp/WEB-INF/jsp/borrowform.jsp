<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Borrow</title>
</head>
<body style="background-color: pink !important">
	<h2>Add Borrow</h2>

	<form:form method="post" action="saveborrow">
		<table>
			<tr>
				<td>bookId :</td>
				<td><form:input path="bookId" /></td>
			</tr>
			<tr>
				<td>memberId :</td>
				<td><form:input path="memberId" /></td>
			</tr>
			<tr>
				<td>issueDate :</td>
				<td><form:input type="date" path="issueDate" /></td>
			</tr>
			<tr>
				<td>returnDate :</td>
				<td><form:input type="date" path="returnDate" /></td>
			</tr>
			<tr>
				<td>dueDate :</td>
				<td><form:input type="date" path="dueDate" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>