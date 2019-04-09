package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.UserRecipeHistory;

@Repository
public interface UserRecipeHistoryRepository extends JpaRepository<UserRecipeHistory, Integer>{

}
