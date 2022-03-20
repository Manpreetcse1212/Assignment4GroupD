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
 * Date: 15.03.2022 Group D 
 * Member1: Manpreet kaur 
 * Member2: Manpreet Kaur
 * Member3: Bhumikaben Manubhai Patel 
 * Member4: Ashikkumar Nareshbhai Patel
 * Member5: Hardeep Kaur Chahal
 * 
 * This class is having methods to add to the borrowlist and to display the
 * borrow list
 */
public class BorrowDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Borrow p) { // This method is to add Borrow to borrow table

		String sql = "insert into borrow (Due_date, Return_date, issue_date, borrow_book_id, borrow_member_id)values(CAST('"
				+ p.getDueDate() + "' AS DATE),CAST('" + p.getDueDate() + "' AS DATE),CAST('" + p.getDueDate()
				+ "' AS DATE)," + p.getBookId() + "," + p.getMemberId() + ")";
		return template.update(sql);
	}

	public int delete(int bookId, int memberId) {
		String sql = "delete from borrow where borrow_book_id=" + bookId + " and borrow_member_id =" + memberId;
		return template.update(sql);
	}

	public List<Borrow> getBorrow() {
		return template.query("select * from borrow", new RowMapper<Borrow>() {
			public Borrow mapRow(ResultSet rs, int row) throws SQLException {
				Borrow e = new Borrow();
				e.setBookId(rs.getInt(4));
				e.setDueDate(rs.getDate(1).toString());
				e.setIssueDate(rs.getDate(3).toString());
				e.setMemberId(rs.getInt(5));
				e.setReturnDate(rs.getDate(2).toString());

				return e;
			}
		});
	}
}
