package com.ohgiraffers.mode.dto;

import java.sql.Date;

import com.google.gson.annotations.SerializedName;

public class MemberDTO implements java.io.Serializable{
	
	// JSON의 key와 객체의 필드가 다른 경우
	// 클래스의 필드에 @SerializedName("JSON key")어노테이션을 달아주면
	// 직렬화 및 역직렬화 시 JSON key와 필드를 매핑해준다
	@SerializedName("memberCode")
	private String code;
	private String Name; 
	private char gender;
	private int age;
	private Date enrollDate;
	
	public MemberDTO() {
		super();
	}
	
	

	public MemberDTO(String code, String name, char gender, int age) {
		super();
		this.code = code;
		Name = name;
		this.gender = gender;
		this.age = age;
	}



	public MemberDTO(String code, String name, char gender, int age, Date enrollDate) {
		super();
		this.code = code;
		Name = name;
		this.gender = gender;
		this.age = age;
		this.enrollDate = enrollDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "MemberDTO [code=" + code + ", Name=" + Name + ", gender=" + gender + ", age=" + age + ", enrollDate="
				+ enrollDate + "]";
	}
	
	
	
	
}
