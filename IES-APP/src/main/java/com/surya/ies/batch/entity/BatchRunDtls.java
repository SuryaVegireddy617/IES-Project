package com.surya.ies.batch.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "BATCH_RUN_DTLS")
public class BatchRunDtls {
	@Id
	@GeneratedValue
	@Column(name = "BATCH_RUN_SEQ")
	private Integer batchRunSeq;

	@Column(name = "BATCH_NAME")
	private String batchName;

	@Column(name = "BATCH_RUN_STATUS")
	private String batchRunStatus;

   @Column(name = "END_DATE", insertable = false, updatable = false, columnDefinition = "TIMESTAMP default getdate()")
   @Temporal(TemporalType.TIMESTAMP)
   private Date endDate;
   
   @Column(name="INSTANCE_NUM")
   private Number instanceNum;
   
   @Column(name = "START_DATE", insertable = false, updatable = false, columnDefinition = "TIMESTAMP default getdate()")
   @Temporal(TemporalType.TIMESTAMP)
   private Date startDate;
	
	 
}
