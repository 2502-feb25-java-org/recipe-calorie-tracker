package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.repositories.CalorieRepository;

@Service
@Transactional
public class CalorieService {
	@Autowired
	CalorieRepository cRepo;
}
