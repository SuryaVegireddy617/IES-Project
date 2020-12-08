package com.surya.ies.admin.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Data
@Entity
@Table(name = "ACCOUNT_DTLS")
public class AccountEntity {
	@Id
	@GeneratedValue
	@Column(name = "ACCOUNT_ID")
	private Integer accountId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PWD")
	private String pwd;
	@Column(name = "DOB")
	private Date dob;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "SSN")
	private Long ssn;
	@Column(name = "PHONE_NUMBER")
	private Long phoneNumber;
	@Column(name = "ROLE")
	private String role;
	@Column(name = "ACCOUNT_STATUS")
	private String accountStatus;
	@CreationTimestamp
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	@UpdateTimestamp
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

}
