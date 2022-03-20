<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Publisher List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Publisher Id</th><th>Name</th><th>Address</th></tr>
    <c:forEach var="publisher" items="${list}"> 
    <tr>
    <td>${publisher.id}</td>
    <td>${publisher.name}</td>
    <td>${publisher.address}</td>
    <td><a href="editpublisher/${publisher.id}">Edit</a></td>
    <td><a href="deletepublisher/${publisher.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="publisherform">Add New Publisher</a>