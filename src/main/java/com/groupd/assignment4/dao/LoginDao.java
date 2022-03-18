package com.groupd.assignment4.dao;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;
import com.groupd.assignment4.beans.Book;
import com.groupd.assignment4.beans.Login; 

/**
 * Date: 15.03.2022
 * Group D 
 * Member1: Manpreet kaur
 * Member2: Manpreet Kaur
 * Member3: Bhumikaben Manubhai Patel
 * Member4: Ashikkumar Nareshbhai Patel
 * Member5: Hardeep Kaur Chahal 
 * Model class for Book table
 */

public class LoginDao {
	
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  

// login, register

//for Adding users
public int save(Login l){  
	
    String sql="insert into login (username)values('"+l.getUserName()+"',"+l.getPassword()+")";  
    return template.update(sql);  
}  


//public int update(Login l){  
//    String sql="update book set Title='"+p.getTitle()+"', Author="+p.getAuthor()+",Available='"+p.getAvailable()+"' where id="+p.getBookId()+"";  
//    return template.update(sql);  
//}  

//public Book getBookById(int id){  
//    String sql="select * from book where Book_id=?";  
//    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Book.class));  
//} 

//For viewing users
public List<Login> getUsers(){  
    return template.query("select * from login",new RowMapper<Login>(){  
        public Login mapRow(ResultSet rs, int row) throws SQLException {  
            Login e=new Login();  
            e.setUserName(rs.getString(1));
            e.setPassword(rs.getString(2));
            return e;  
        }  
    });  
}  
}  