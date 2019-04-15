package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.MealHistory;
import com.revature.repositories.MealRepository;

@Service
@Transactional
public class MealService {
	
	@Autowired
	MealRepository mRepo;
	
	public MealHistory addMeal(MealHistory meal) {
		return mRepo.save(meal);
	}
	public List<MealHistory> getAllByUser(int uid){
		return mRepo.findByUid(uid);
	}

}
