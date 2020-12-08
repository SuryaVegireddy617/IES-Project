package com.surya.ies.ar.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Citizen 
{
	private Integer arId;
	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;
	private String ssnNo;
	private Integer phoneNumber;
	private String email;
}
