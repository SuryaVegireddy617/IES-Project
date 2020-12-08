package com.surya.ies.admin.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.surya.ies.admin.domain.Account;
import com.surya.ies.admin.domain.Plan;
import com.surya.ies.admin.service.AccountService;
import com.surya.ies.admin.service.PlanService;

 


@Controller
public class HomeController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private PlanService planService;
	
	@GetMapping({"/","/home"})
	public String loadHomePage() {
		return "index";		
	}
	@GetMapping("/accReg")
	public String handleCreatingAccLink(Model model) {
		Account account = new Account();
		model.addAttribute("accountObj", account);
		return "accountRegistration";
	}
	@GetMapping("/accounts")
	public String handleViewAccountsLInk(@RequestParam("role") String role,Model m){
		List<Account> allAccountsByRole = accountService.getAllAccountsByRole(role);
		 m.addAttribute("accounts", allAccountsByRole);
		
		return "viewAccounts";
		
	}
	@GetMapping("/planReg")
	public String handleCreatingplanLink(Model model) {
		Plan plan = new Plan();
		model.addAttribute("planObj", plan);
		return "planRegistration";
	}
	@GetMapping("/plans")
	public String handleViewPlansLink(Model m){
		List<Plan> allPlans = planService.getAllPlans();
		 m.addAttribute("plans", allPlans);
		
		return "viewPlans";
		
	}
	

}
