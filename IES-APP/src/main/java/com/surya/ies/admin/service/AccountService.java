package com.surya.ies.admin.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.surya.ies.admin.domain.Account;




public interface AccountService {
	public boolean saveAccount(Account account);
	public List<Account> getAllAccounts();
	public boolean deactivateAccountById(Integer accountId);
	public String getRegDtlsMailBody(Account account);
	public boolean sendRegDtlsToAccountHolderEmail(String to, String subject, String body);
	public boolean isUniqueEmail(String email);
	public String loginCheck(String eMail, String pwd);
	public List<Account> getAllAccountsByRole(String role);
	public Account getAccountById(Integer accountId);
	public boolean activateAccountById(Integer id);
}
