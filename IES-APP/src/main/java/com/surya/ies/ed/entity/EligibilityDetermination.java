package com.surya.ies.ed.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="eligibility_details")
public class EligibilityDetermination 
{
	
	@Id
	@GeneratedValue
	@Column(name="ed_trace_id")
	private Number edTraceId;
	
	@Column(name ="benefit_amt")
	private String benefitAmt;
	
	@Column(name="case_num")
	private Number caseNum;
	
	@Column(name ="create_dt")
	private Date createDt;
	
	@Column(name ="denial_reason")
	private String denialReason;
	
	@Column(name="plan_end_dt")
	private String planEndDt;
	
	@Column(name="plan_name")
	private String planName;
	
	@Column(name="plan_start_dt")
	private String planStartDt;
	
	@Column(name="plan_status")
	private String planStatus;
	
	@Column(name="update_dt")
	private Date updateDt;
	
}
