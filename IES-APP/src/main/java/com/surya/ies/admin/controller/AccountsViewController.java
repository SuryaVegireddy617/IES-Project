package com.surya.ies.admin.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.surya.ies.admin.domain.Account;
import com.surya.ies.admin.service.AccountService;

 

@Controller
public class AccountsViewController {
    @Autowired
    private AccountService accountService;
	@GetMapping("/editAccount")
	public String editBtnHandling(@RequestParam("accountId") Integer id,Model model)
	{
		Account account = accountService.getAccountById(id);
		model.addAttribute("accountObj", account);
		return "accountRegistration";
		
	}
	@GetMapping("/deactivateAccount")
	public String deactivateBtnHandling(@RequestParam("accountId") Integer id,RedirectAttributes rd) {
		boolean deactivateAccountById = accountService.deactivateAccountById(id);
		if(deactivateAccountById)
		rd.addFlashAttribute("succMsg", "Account Deactivated Successfully");
		else
			rd.addFlashAttribute("errorMsg", "Account Deactivation failed");
		return"redirect:/accounts?role=CASEWORKER";
	}
	@GetMapping("/activateAccount")
	public String activateBtnHandling(@RequestParam("accountId") Integer id,RedirectAttributes rd) {
		 boolean activateAccountById = accountService.activateAccountById(id);
		 if(activateAccountById )
		 rd.addFlashAttribute("succMsg", "Account Activated Successfully");
		 else 
			 rd.addFlashAttribute("errorMsg", "Account Activation failed");
		 
		return"redirect:/accounts?role=CASEWORKER";
	}

}
