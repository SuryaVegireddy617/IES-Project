package com.surya.ies.ar.binding;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;



@Data
@XmlRootElement
public class CitizenResponse
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
