package com.groupd.assignment4.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.groupd.assignment4.beans.Publisher;

/**
 * Date: 15.03.2022
 * Group D 
 * Member1: Manpreet kaur
 * Member2: Manpreet Kaur
 * Member3: Bhumikaben Manubhai Patel
 * Member4: Ashikkumar Nareshbhai Patel
 * Member5: Hardeep Kaur Chahal 
 * 
 * This class is having methods for addBorrow and showBorrow to add to the borrowlist and to display the borrow list
 */
public class PublisherDao {

JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Publisher p){  
	
    String sql="insert into publisher (Pub_id, Address, Name)values("+p.getId()+",'"+p.getAddress()+"','"+p.getName()+"')";  
    return template.update(sql);  
}  
public int update(Publisher p){  
    String sql="update publisher set Address='"+p.getAddress()+"', Name='"+p.getName()+"' where Pub_id="+p.getId()+"";  
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from publisher where Pub_id="+id+"";  
    return template.update(sql);  
}  
public Publisher getPublisherById(int id){  
    String sql="select * from publisher where Pub_id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Publisher>(Publisher.class));  
}  
public List<Publisher> getPublisher(){  
    return template.query("select * from publisher",new RowMapper<Publisher>(){  
        public Publisher mapRow(ResultSet rs, int row) throws SQLException {  
        	Publisher e=new Publisher();  
        	e.setId(rs.getInt(1));
        	e.setAddress(rs.getString(2));
            e.setName(rs.getString(3));
           
            return e;  
        }  
    });  
}  

	
}
