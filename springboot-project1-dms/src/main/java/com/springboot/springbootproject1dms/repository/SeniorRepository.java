package com.springboot.springbootproject1dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.springbootproject1dms.model.Senior;

@Repository
public interface SeniorRepository extends JpaRepository<Senior, Long> {

}
