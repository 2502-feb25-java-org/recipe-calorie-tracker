package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Calorie;

@Repository
public interface CalorieRepository extends JpaRepository<Calorie, Integer>{

}
