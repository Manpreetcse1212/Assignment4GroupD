package com.groupd.assignment4.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.groupd.assignment4.beans.Member;

/**
 * Date: 15.03.2022 Group D 
 * Member1: Manpreet kaur 
 * Member2: Manpreet Kaur
 * Member3: Bhumikaben Manubhai Patel 
 * Member4: Ashikkumar Nareshbhai Patel
 * Member5: Hardeep Kaur Chahal
 * 
 * This class has methods to register,show update and delete the members from
 * the database
 */

public class MemberDaoD {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int RegisterMember(Member p) { // This method is used to register using member table
		String sql = "insert into member (Name, Address, Memb_type, Memb_date, Expiry_date,Memb_id)values('"
				+ p.getName() + "','" + p.getAddress() + "','" + p.getMemberType() + "',CAST('"
				+ java.sql.Date.valueOf(p.getJoin_date()) + "' AS DATE),CAST('" + java.sql.Date.valueOf(p.getExpire())
				+ "' AS DATE)," + p.getMember_id() + ")";
		return template.update(sql);
	}

	public int updateMember(Member p) { // This method is used to update the members in the member table
		System.out.println(java.sql.Date.valueOf(p.getJoin_date()));
		String sql = "update member set Memb_date=CAST('" + java.sql.Date.valueOf(p.getJoin_date())
				+ "' AS DATE), Expiry_date=CAST('" + java.sql.Date.valueOf(p.getExpire()) + "' AS DATE), Name='"
				+ p.getName() + "',Address='" + p.getAddress() + "', Memb_type='" + p.getMemberType()
				+ "' where Memb_id=" + p.getMember_id() + "";
		System.out.println(sql);
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from member where Memb_id=" + id + "";
		String childsql = "delete from borrow where borrow_member_id=" + id + "";

		template.update(childsql);

		return template.update(sql);
	}

	@SuppressWarnings("deprecation")
	public Member getMemberById(int id) { // This method is used to display the members from the member table
		String sql = "select * from member where Memb_id=?";
		return template.queryForObject(sql, new Object[] { id }, new RowMapper<Member>() {
			public Member mapRow(ResultSet rs, int row) throws SQLException {
				Member e = new Member();
				e.setName(rs.getString(1));
				e.setAddress(rs.getString(2));
				e.setMemberType(rs.getString(3));
				e.setJoin_date(rs.getDate(4).toString());
				e.setExpire(rs.getDate(5).toString());
				e.setMember_id(rs.getInt(6));

				return e;
			}
		});
	}

	public List<Member> getMember() { // This method is used to display the members from the member table
		return template.query("select * from member", new RowMapper<Member>() {
			public Member mapRow(ResultSet rs, int row) throws SQLException {
				Member e = new Member();
				e.setName(rs.getString(1));
				e.setAddress(rs.getString(2));
				e.setMemberType(rs.getString(3));
				e.setJoin_date(rs.getDate(4).toString());
				e.setExpire(rs.getDate(5).toString());
				e.setMember_id(rs.getInt(6));

				return e;
			}
		});
	}

}
