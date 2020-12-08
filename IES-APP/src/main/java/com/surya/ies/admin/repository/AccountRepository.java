package com.surya.ies.admin.repository;



import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surya.ies.admin.entity.AccountEntity;



public interface AccountRepository extends JpaRepository<AccountEntity, Serializable>{
	public AccountEntity findBySsn(Integer accountId);
	public AccountEntity findByEmail(String email);
	public List<AccountEntity> findByRole(String role);
	

}
