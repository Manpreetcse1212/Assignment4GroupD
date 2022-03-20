package com.groupd.assignment4.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.groupd.assignment4.beans.Login;

/**
 * Date: 15.03.2022 Group D Member1: Manpreet kaur Member2: Manpreet Kaur
 * Member3: Bhumikaben Manubhai Patel Member4: Ashikkumar Nareshbhai Patel
 * Member5: Hardeep Kaur Chahal Model class for Book table
 */

public class LoginDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

//	login, register
	public boolean check(Login login) {
		String sql = "select * from login where username=? and password=?";

		List<Login> users = template.query("select username, password from login where username='" + login.getUserName()
				+ "' and password='" + login.getPassword() + "'", new RowMapper<Login>() {
					public Login mapRow(ResultSet rs, int row) throws SQLException {
						Login e = new Login();
						e.setUserName(rs.getString(1));
						e.setPassword(rs.getString(2));
						return e;
					}
				});
		if (users.size() > 0) {
			if (login.getUserName().equals(users.get(0).getUserName())
					&& login.getPassword().equals(users.get(0).getPassword())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

//	for Adding users
	public int saveUser(Login login) {
		String sql = "insert into login (username, password) values('" + login.getUserName() + "','"
				+ login.getPassword() + "')";
		return template.update(sql);
	}
}