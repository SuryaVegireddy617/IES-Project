package com.surya.ies.ar.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "APP_REG_TBL")
@Data
public class CitizenEntity {

	@Id
	@Column(name = "AR_ID")
	@GenericGenerator(name = "ar_id_generator", strategy ="com.surya.ies.ar.generators")
	@GeneratedValue(generator = "ar_id_generator")
	private String arId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="DOB")
	private Date dob;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name = "SSNNO")
	private String ssnNo;
	
	@Column(name = "PHONE_NUMBER")
	private Integer phoneNumber;
	
	@Column(name="EMAIL")
	private String email;
}
