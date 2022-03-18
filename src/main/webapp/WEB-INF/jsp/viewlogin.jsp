<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Login Page</h1>
       <form:form method="POST" action="/Assignment4GroupD/save">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="id" /></td>
         </tr> 
         <tr>  
          <td>Username:</td> 
          <td><form:input path="username"  /></td>
         </tr>  
         <tr>  
          <td>Password :</td>  
          <td><form:input path="password" /></td>
         </tr> 
    
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
