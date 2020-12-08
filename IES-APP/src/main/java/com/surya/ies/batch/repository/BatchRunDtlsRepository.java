package com.surya.ies.batch.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surya.ies.batch.entity.BatchRunDtls;

public interface BatchRunDtlsRepository extends JpaRepository<BatchRunDtls, Serializable>{

}
