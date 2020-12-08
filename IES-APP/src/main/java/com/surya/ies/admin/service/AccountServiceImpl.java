package com.surya.ies.admin.service;



import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.surya.ies.admin.domain.Account;
import com.surya.ies.admin.entity.AccountEntity;
import com.surya.ies.admin.repository.AccountRepository;
import com.surya.ies.util.EmailUtils;

 
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private EmailUtils emailUtils;
	@Autowired
	private AccountRepository accountRepo;
	

	@Override
	public boolean saveAccount(Account account) {
		account.setAccountStatus("ACTIVE");
		AccountEntity accountEntity = new AccountEntity();
		BeanUtils.copyProperties(account, accountEntity);
		
		accountRepo.save(accountEntity);
		String mailBody = getRegDtlsMailBody(account);
		String subject = "IES Application Login Detailes";
		String to = account.getEmail();
		sendRegDtlsToAccountHolderEmail(to, subject, mailBody);

		return sendRegDtlsToAccountHolderEmail(to, subject, mailBody);
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deactivateAccountById(Integer accountId) {
		Account account= getAccountById( accountId);
		account.setAccountStatus("INACTIVE");
		AccountEntity accountEntity = new AccountEntity();
		BeanUtils.copyProperties(account, accountEntity);
		
		AccountEntity entity = accountRepo.save(accountEntity);
		
		return entity.getSsn()!=null?true:false;
	}

	@Override
	public String getRegDtlsMailBody(Account account) {
		String fileName = "IES-ACCOUNT-DTLS-EMAIL_BODYTEMPLATE.txt";
		List<String> replacedLines = null;
		String mailBody = null;
		try {
			Path path = Paths.get(fileName, "");
			Stream<String> lines = Files.lines(path);
			replacedLines = lines.map(line -> line
							.replace("{FNAME}", account.getFirstName())
							.replace("{LNAME}", account.getLastName()).replace("{ROLE}", account.getRole())
							.replace("{EMAIL}", account.getEmail()).replace("{PWD}", account.getPwd()))
					        .collect(Collectors.toList());
			mailBody = String.join("", replacedLines);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mailBody;
	}

	@Override
	public boolean sendRegDtlsToAccountHolderEmail(String to, String subject, String body) {

		return emailUtils.sendEmail(to, subject, body);
	}

	@Override
	public boolean isUniqueEmail(String email) {
		AccountEntity entity = accountRepo.findByEmail(email);
		return entity == null ? true : false;
	}

	@Override
	public String loginCheck(String eMail, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAllAccountsByRole(String role) {
		List<Account> listofAccounts = new ArrayList<Account>();
		List<AccountEntity> listofAccountEntities = accountRepo.findByRole(role);
		listofAccountEntities.forEach(entity -> {
			Account account = new Account();
			BeanUtils.copyProperties(entity, account);
			listofAccounts.add(account);
		});
		return listofAccounts;
	}

	@Override
	public Account getAccountById(Integer accountId) {
		 AccountEntity accountEntity = null;
		 Optional<AccountEntity>  findById = accountRepo.findById(accountId);
		 if(findById.isPresent()) {
			 accountEntity = findById.get();
			 
		 }
		Account account = new Account();
		
		BeanUtils.copyProperties(accountEntity, account);
		return account;
	}

	@Override
	public boolean activateAccountById(Integer id) {
		Account account= getAccountById(id);
		account.setAccountStatus("ACTIVE");
		AccountEntity accountEntity = new AccountEntity();
		BeanUtils.copyProperties(account, accountEntity);
		
		AccountEntity entity = accountRepo.save(accountEntity);
		
		
		return entity.getSsn()!=null?true:false;
	}

}
