<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

	<h1>Member List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Name</th><th>Address</th><th>Type</th><th>Join Date</th><th>Expiry Date</th><th>Id</th></tr>
    <c:forEach var="member" items="${list}"> 
    <tr>
    <td>${member.name}</td>
    <td>${member.address}</td>
    <td>${member.memberType}</td>
    <td>${member.join_date}</td>
    <td>${member.expire}</td>
    <td>${member.member_id}</td>
    <td><a href="editmember/${member.member_id}">Edit</a></td>
    <td><a href="deletemember/${member.member_id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="memberform">Add New Member</a>