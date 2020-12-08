package com.surya.ies.admin.domain;



import java.util.Date;

import lombok.Data;

@Data
public class Account {
	private Integer accountId;
	private String firstName;
	private String lastName;
	private String email;
	private String pwd;
	private Date dob;
	private String gender;
	private Long ssn;
	private Long phoneNumber;
	private String role;
	private String accountStatus;
	private Date createdDate;
	private Date updatedDate;

}
