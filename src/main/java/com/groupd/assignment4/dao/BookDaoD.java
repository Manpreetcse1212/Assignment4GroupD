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
 * This class is having methods to issue books, show books, update books and delete books
 */

public class BookDaoD {
	
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  

public int IssueBook(Book p){  
	//This method is inserting the records of issuing books to the book table
    String sql="insert into book (Title, Author, Available, Price, Pub_id)values('"+p.getTitle()+"','"+p.getAuthor()+"','"+p.getAvailable()+"',"+p.getPrice()+","+p.getPubId()+")";  
    return template.update(sql);  
} 

public int UpdateBook(Book p){   // This method updates the books from book table
    String sql="update book set Price = "+p.getPrice()+", Title='"+p.getTitle()+"', Author='"+p.getAuthor()+"',Available='"+p.getAvailable()+"' where Book_id="+p.getBookId()+"";  
    System.out.println(sql);
    return template.update(sql);  
} 

public int DeleteBook(int id){  // This method deletes the books from book table
    String sql="delete from book where Book_id="+id+"";  
    return template.update(sql);  
}  

@SuppressWarnings("deprecation")
public Book getBookById(int id){  //This method displays the books from book table
    String sql="select * from book where Book_id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Book>(Book.class));  
} 

public List<Book> getBooks(){  //This method displays the books from book table
    return template.query("select * from book",new RowMapper<Book>(){  
        public Book mapRow(ResultSet rs, int row) throws SQLException {  
            Book e=new Book();  
            e.setBookId(rs.getInt(1));  
            e.setAuthor(rs.getString(2));
            e.setTitle(rs.getString(3)); 
            e.setPrice(rs.getDouble(4));
            e.setAvailable(rs.getString(5));
            e.setPubId(rs.getInt(6));
            return e;  
        }  
    });  
}  
}  
