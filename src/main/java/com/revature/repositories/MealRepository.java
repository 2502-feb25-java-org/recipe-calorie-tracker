package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.MealHistory;

@Repository
public interface MealRepository extends JpaRepository<MealHistory, Integer>{

	//return all meals with userid maybe sort by date
	List<MealHistory> findByUid(int uid);
}
