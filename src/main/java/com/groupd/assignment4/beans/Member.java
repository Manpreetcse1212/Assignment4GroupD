package com.groupd.assignment4.beans;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Date: 15.03.2022 
 * Group D 
 * Member1: Manpreet kaur 
 * Member2: Manpreet Kaur
 * Member3: Bhumikaben Manubhai Patel Member4: Ashikkumar Nareshbhai Patel
 * Member5: Hardeep Kaur Chahal
 * 
 * bean class for member table
 */

public class Member {

	private int member_id;
	private String name;
	private String address;
	private String memberType;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String join_date;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String expire;

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJoin_date() {
		return join_date;
	}

	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}

	public String getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = expire;
	}

}
