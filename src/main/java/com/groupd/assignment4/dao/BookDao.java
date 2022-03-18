package com.groupd.assignment4.dao;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;
import com.groupd.assignment4.beans.Book; 

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

public class BookDao {
	
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Book p){  
	
    String sql="insert into book (Title, Author, Available, Price, Pub_id)values('"+p.getTitle()+"','"+p.getAuthor()+"','"+p.getAvailable()+"',"+p.getPrice()+","+p.getPubId()+")";  
    return template.update(sql);  
}  
public int update(Book p){  
    String sql="update book set Title='"+p.getTitle()+"', Author="+p.getAuthor()+",Available='"+p.getAvailable()+"' where id="+p.getBookId()+"";  
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from book where Book_id="+id+"";  
    return template.update(sql);  
}  
public Book getBookById(int id){  
    String sql="select * from book where Book_id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Book>(Book.class));  
}  
public List<Book> getBooks(){  
    return template.query("select * from book",new RowMapper<Book>(){  
        public Book mapRow(ResultSet rs, int row) throws SQLException {  
            Book e=new Book();  
            e.setBookId(rs.getInt(1));  
            e.setTitle(rs.getString(2)); 
            e.setPubId(rs.getInt(3));
            e.setAuthor(rs.getString(4));  
            return e;  
        }  
    });  
}  
}  