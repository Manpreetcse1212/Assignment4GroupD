<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add book</title>
</head>
<body style="background-color: pink !important">
	<h2>Add Book</h2>

	<form:form method="post" action="savebook">
		<table>
			<tr>
				<td>title :</td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td>author :</td>
				<td><form:input path="author" /></td>
			</tr>
			<tr>
				<td>available :</td>
				<td><form:input path="available" /></td>
			</tr>
			<tr>
				<td>price :</td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td>pubId :</td>
				<td><form:input path="pubId" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>