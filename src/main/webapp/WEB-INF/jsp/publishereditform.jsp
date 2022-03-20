<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Edit Publisher</h1>
<form:form method="POST" action="/Assignment4GroupD/editsavepublisher">
	<form:hidden path="id" />
	<table>
		<tr>
			<td>Name :</td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td>Address :</td>
			<td><form:input path="address" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Edit Save" /></td>
		</tr>
	</table>
</form:form>
