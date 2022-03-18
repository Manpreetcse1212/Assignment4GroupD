    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Employees List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Book Id</th><th>Member Id</th><th>Issue Date</th><th>Return Date</th><th>Due Date</th></tr>
    <c:forEach var="borrow" items="${list}"> 
    <tr>
    <td>${borrow.borrow_book_id}</td>
    <td>${borrow.borrow_member_id}</td>
    <td>${borrow.issue_date}</td>
    <td>${borrow.Return_date}</td>
    <td>${borrow.Due_date}</td>
    <td><a href="editborrow/${borrow.borrow_book_id}">Edit</a></td>
    <td><a href="deleteborrow/${borrow.borrow_book_id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="borrowform">Add Borrow</a>