package com.surya.ies.admin.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.surya.ies.admin.domain.Account;
import com.surya.ies.admin.service.AccountService;

 

@Controller
public class AccountRegistrationController {
	@Autowired
	private AccountService accountService;

	@PostMapping("/saveAccount")
	public String handleCreateAccountLink(@ModelAttribute("accountObj") Account account, RedirectAttributes rd) {
		
			boolean saveAccount = accountService.saveAccount(account);
			if (saveAccount) {
				if(account.getAccountId() != null)
				rd.addFlashAttribute("succMsg", "Account Updated Successfully");
				else
					rd.addFlashAttribute("succMsg","Account Registration  Successfull Dtailes Send to Account Holder Mialid ");
						
			} else {
				if(account.getAccountId() != null)
				rd.addFlashAttribute("failMsg", "Account Updation Failed");
				else
					rd.addFlashAttribute("failMsg", "Account Registration Failed");
			}
		
						
		return "redirect:/accReg";
	}

	@GetMapping("/uniqueMailCheck")
	@ResponseBody
	public String isUniqueEmail(@RequestParam("email") String email) {
		return accountService.isUniqueEmail(email) ? "UNIQUE" : "DUPLICATE";
	}

}
