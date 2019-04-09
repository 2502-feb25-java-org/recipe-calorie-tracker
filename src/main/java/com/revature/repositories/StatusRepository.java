package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer>{

}
