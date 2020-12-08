package com.surya.ies.admin.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surya.ies.admin.domain.Plan;
import com.surya.ies.admin.entity.PlanEntity;
import com.surya.ies.admin.repository.PlanRepository;

 
@Service
public class PlanServiceImpl implements PlanService {
	@Autowired
    private PlanRepository planRepo;
	@Override
	public boolean savePlan(Plan plan) {
		plan.setPlanStatus("ACTIVE");
		PlanEntity entity = new PlanEntity();
		BeanUtils.copyProperties(plan, entity);
		PlanEntity planEntity = planRepo.save(entity);
		return planEntity.getPlanId()!=null? true : false;
	}

	@Override
	public Plan getPlanById(Integer id) {
		Plan plan= null;
		Optional<PlanEntity> findById = planRepo.findById(id);
		if(findById.isPresent()) {
			PlanEntity planEntity = findById.get();
			 plan = new Plan();
			BeanUtils.copyProperties(planEntity, plan);
		}
		return plan;
	}

	@Override
	public List<Plan> getAllPlans() {
		List<Plan> listpnals = new ArrayList<>();
		List<PlanEntity> listPlanEntities = planRepo.findAll();
		
		listPlanEntities.forEach(entity->{
			Plan plan = new Plan();
			BeanUtils.copyProperties(entity, plan);
			 listpnals.add(plan);
		});
		
		return listpnals;
	}

	@Override
	public boolean inActivePlan(Integer id) {
		Plan plan = getPlanById(id);
		plan.setPlanStatus("INACTIVE");
		PlanEntity entity = new PlanEntity();
		BeanUtils.copyProperties(plan, entity);
		PlanEntity planEntity = planRepo.save(entity);
	   
		return planEntity.getPlanId()!=null? true : false;
	}

	@Override
	public boolean ActivePlan(Integer planId) {
		Plan plan = getPlanById(planId);
		plan.setPlanStatus("ACTIVE");
		PlanEntity entity = new PlanEntity();
		BeanUtils.copyProperties(plan, entity);
		PlanEntity planEntity = planRepo.save(entity);
		return planEntity.getPlanId()!=null? true : false;
	}

}
