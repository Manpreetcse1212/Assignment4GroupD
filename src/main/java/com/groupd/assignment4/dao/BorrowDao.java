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

import com.groupd.assignment4.beans.Book;
import com.groupd.assignment4.beans.Borrow;

/**
 * Date: 15.03.2022
 * Group D 
 * Member1: Manpreet kaur
 * Member2: Manpreet Kaur
 * Member3: Bhumikaben Manubhai Patel
 * Member4: Ashikkumar Nareshbhai Patel
 * Member5: Hardeep Kaur Chahal 
 * 
 * This class is having methods to add to the borrowlist and to display the borrow list
 */
public class BorrowDao {
	
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Borrow p){ //This method is to add Borrow to borrow table  
	
    String sql="insert into borrow (Due_date, Return_date, issue_date, borrow_book_id, borrow_member_id)values("+p.getDueDate()+","+p.getReturnDate()+","+p.getIssueDate()+","+p.getBookId()+","+p.getMemberId()+")";  
    return template.update(sql);  
}  
public int update(Borrow p){  
    String sql="update borrow set Due_date="+p.getDueDate()+", Return_date="+p.getReturnDate()+", issue_date="+p.getIssueDate()+",borrow_book_id="+p.getBookId()+", borrow_member_id= where id="+p.getBookId()+"";  
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from borrow where Book_id="+id+"";  
    return template.update(sql);  
}  
public Borrow getBorrowById(int id){  ////This method is to display Borrow from ShowBorrow table
    String sql="select * from borrow where Book_id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Borrow>(Borrow.class));  
}  
public List<Borrow> getBorrow(){  
    return template.query("select * from borrow",new RowMapper<Borrow>(){  
        public Borrow mapRow(ResultSet rs, int row) throws SQLException {  
            Borrow e=new Borrow();  
            e.setBookId(rs.getInt(1));  
            e.setBookName(rs.getString(4));
            e.setDueDate(rs.getDate(5));
            e.setIssueDate(rs.getDate(3));
            e.setMemberId(rs.getInt(2));
            e.setMemberName(rs.getString(6));
            e.setReturnDate(rs.getDate(7)); 
            
            return e;  
        }  
    });  
}  
}
