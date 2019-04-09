package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Ingredient;

@Repository
public interface UserIngredientPreferenceRepository extends JpaRepository<Ingredient, Integer>{

}
