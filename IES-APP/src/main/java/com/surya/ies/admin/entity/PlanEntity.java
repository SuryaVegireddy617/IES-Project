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
@Table(name = "PLAN_DTLS")
public class PlanEntity {
	@Id
	@GeneratedValue
	@Column(name = "PLAN_ID")
	private Integer planId;
	@Column(name = "PLAN_NAME")
	private String planName;
	@Column(name = "PLAN_DESCRIPTION")
	private String planDescription;
	@Column(name = "PLAN_START_DATE")
	private Date planStartDate;
	@Column(name = "PLAN_END_DATE")
	private Date planEndDate;
	@Column(name = "PLAN_STATUS")
	private String planStatus;
	@CreationTimestamp
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	@UpdateTimestamp
	@Column(name = "UPDATED_DATE")
	private Date updateddDate;

}
