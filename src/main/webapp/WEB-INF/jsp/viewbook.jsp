    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Employees List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Title</th><th>Author</th><th>Available</th><th>Price</th><th>Publisher Id</th></tr>
    <c:forEach var="borrow" items="${list}"> 
    <tr>
    <td>${book.Book_id}</td>
    <td>${book.Author}</td>
    <td>${book.Title}</td>
    <td>${book.Price}</td>
    <td>${book.Available}</td>
    <td>${book.Pub_id}</td>
    <td><a href="editbook/${book.Book_id}">Edit</a></td>
    <td><a href="deletebook/${book.Book_id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="bookform">Add Book</a>