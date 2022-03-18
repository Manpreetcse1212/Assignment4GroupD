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

import com.groupd.assignment4.beans.Member;

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

public class MemberDao {

JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Member p){  
	
    String sql="insert into member (Name, Address, Memb_type, Memb_date, Expiry_date,Memb_id)values('"+p.getName()+"','"+p.getAddress()+"','"+p.getType()+"','"+p.getJoin_date()+"','"+p.getExpire()+"',"+p.getMember_id()+")";  
    return template.update(sql);  
}  
public int update(Member p){  
    String sql="update member set Memb_date='"+p.getJoin_date()+"', Expiry_date='"+p.getExpire()+"', Nmae='"+p.getName()+"',Address="+p.getAddress()+", Memb_type= where id="+p.getType()+"";  
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from member where Memb_id="+id+"";  
    return template.update(sql);  
}  
public Member getMemberById(int id){  
    String sql="select * from member where Memb_id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Member>(Member.class));  
}  
public List<Member> getMember(){  
    return template.query("select * from member",new RowMapper<Member>(){  
        public Member mapRow(ResultSet rs, int row) throws SQLException {  
            Member e=new Member();  
            e.setName(rs.getString(1));
            e.setAddress(rs.getString(2));
            e.setType(rs.getString(3));
            e.setJoin_date(rs.getDate(4));
            e.setExpire(rs.getDate(5));
            e.setMember_id(rs.getInt(6));
            
            return e;  
        }  
    });  
}  

}
