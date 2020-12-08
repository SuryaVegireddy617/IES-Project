package com.surya.ies.admin.domain;



import java.util.Date;

import lombok.Data;
@Data
public class Plan {
	private Integer planId;
	private String planName;
	private String planDescription;
	private Date planStartDate;
	private Date planEndDate;
	private String planStatus;
	private Date createdDate;
	private Date updateddDate;
}
