package com.springboot.springbootproject1dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.springbootproject1dms.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>{

}



