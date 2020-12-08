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
@Table(name="co_triggers")
public class CoTriggers 
{

@Id
@GeneratedValue
@Column(name="trg_id")
private Number trgId;

@Column(name="case_num")
private Number caseNum;
	
@Column(name="create_dt")
private Date createDt;
	
@Column(name ="trg_status")
private String trgStatus;

@Column(name="update_dt")
private Date updateDt;
	 
}
