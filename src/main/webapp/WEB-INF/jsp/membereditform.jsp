<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Edit Member</h1>
<form:form method="POST" action="/Assignment4GroupD/editsavemember">
	<table>
		<tr>
			<td></td>
			<td><form:hidden path="member_id" /></td>
		</tr>
		<tr>
			<td>Name :</td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td>Address :</td>
			<td><form:input path="address" /></td>
		</tr>
		<tr>
			<td>Member Type :</td>
			<td><form:input path="memberType" /></td>
		</tr>
		<tr>
			<td>Join Date :</td>
			<td><form:input type="date" path="join_date" /></td>
		</tr>
		<tr>
			<td>Expire Date :</td>
			<td><form:input type="date" path="expire" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Edit Save" /></td>
		</tr>
	</table>
</form:form>
