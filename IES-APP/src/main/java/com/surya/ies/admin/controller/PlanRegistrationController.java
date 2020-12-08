package com.surya.ies.admin.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.surya.ies.admin.domain.Plan;
import com.surya.ies.admin.service.PlanService;

 

@Controller
public class PlanRegistrationController {
	@Autowired
	private PlanService planService; 
	@PostMapping("/savePlan")
	public String handleCreatePlanLink(@ModelAttribute("planObj")Plan plan,RedirectAttributes rd) {
		boolean savePlan = planService.savePlan(plan);
		if(savePlan) {
			rd.addFlashAttribute("succMsg", "Plan Registration Successfull");
		}
		else {
			rd.addFlashAttribute("failMsg", "Plan Registration Failed");
		}
		return "redirect:/planReg";
		
	}

}
