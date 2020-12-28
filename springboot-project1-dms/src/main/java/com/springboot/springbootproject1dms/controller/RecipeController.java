package com.springboot.springbootproject1dms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springbootproject1dms.exception.ResourceNotFoundException;
import com.springboot.springbootproject1dms.model.Recipe;
import com.springboot.springbootproject1dms.repository.RecipeRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/v2")
public class RecipeController {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@GetMapping("/recipes")
	public List<Recipe> getAllRecipes(){
		return recipeRepository.findAll();
	}
	
	@GetMapping("/test")
	public String welcome(){
		return "get recipees here: test page";
	}
	
	@GetMapping("/recipes/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable(value = "id") Long recipeId)
        throws ResourceNotFoundException {
        Recipe recipe = recipeRepository.findById(recipeId)
          .orElseThrow(() -> new ResourceNotFoundException("Recipe not found for this id :: " + recipeId));
        return ResponseEntity.ok().body(recipe);
    }
    
    @PostMapping("/recipes")
    public Recipe createRecipe(@Validated @RequestBody Recipe recipe) {
    	System.out.println("RRRRRRRRRRRRRRRRRRRR" + recipe);
        return recipeRepository.save(recipe);
    }
    
    @PutMapping("/recipes/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable(value = "id") Long recipeId,
         @Validated @RequestBody Recipe recipeDetails) throws ResourceNotFoundException {
        Recipe recipe = recipeRepository.findById(recipeId)
        .orElseThrow(() -> new ResourceNotFoundException("Recipe not found for this id :: " + recipeId));

        recipe.setTitle(recipeDetails.getTitle());
        recipe.setCost(recipeDetails.getCost());
        recipe.setContainsGluten(recipeDetails.isContainsGluten());
        recipe.setContainsPeanut(recipeDetails.isContainsPeanut());
        recipe.setIngredients(recipeDetails.getIngredients());
        final Recipe updatedRecipe = recipeRepository.save(recipe);
        return ResponseEntity.ok(updatedRecipe);
       
    }
    
    @DeleteMapping("/recipes/{id}")
    public Map<String, Boolean> deleteRecipe(@PathVariable(value = "id") Long recipeId)
         throws ResourceNotFoundException {
        Recipe recipe = recipeRepository.findById(recipeId)
       .orElseThrow(() -> new ResourceNotFoundException("Recipe not found for this id :: " + recipeId));

        recipeRepository.delete(recipe);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
