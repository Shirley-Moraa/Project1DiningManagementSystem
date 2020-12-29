package com.springboot.springbootproject1dms.controller;

import java.util.ArrayList;
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
import com.springboot.springbootproject1dms.model.Menu;
import com.springboot.springbootproject1dms.model.Recipe;
import com.springboot.springbootproject1dms.repository.MenuRepository;
import com.springboot.springbootproject1dms.repository.RecipeRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/v3")
public class MenuController {
	@Autowired
	private MenuRepository menuRepository;
	
	@GetMapping("/menus")
	public List<Menu> getAllMenus(){
		return menuRepository.findAll();
	}
	
	@GetMapping("/test")
	public String welcome(){
		return "!!!!!!!!!!!!!! menu here: test page";
	}
	
	@GetMapping("/menus/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable(value = "id") Long menuId)
        throws ResourceNotFoundException {
        Menu menu = menuRepository.findById(menuId)
          .orElseThrow(() -> new ResourceNotFoundException("Menu not found for this id :: " + menuId));
        return ResponseEntity.ok().body(menu);
    }
    
    @PostMapping("/menus")
    public Menu createMenu(@Validated @RequestBody Menu menu) {
    	System.out.println("QQQQQQQQQQQQQQ=MENU=QQQQQQQQQQQQQQQQQ" + menu);
        return menuRepository.save(menu);
    }
    
    @PutMapping("/menus/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable(value = "id") Long menuId,
         @Validated @RequestBody Menu menuDetails) throws ResourceNotFoundException {
        Menu menu = menuRepository.findById(menuId)
        .orElseThrow(() -> new ResourceNotFoundException("Menu not found for this id :: " + menuId));

        menu.setBudget(menuDetails.getBudget());
        menu.setCombinations(menuDetails.getCombinations());
        menu.setContainsGluten(menuDetails.isContainsGluten());
        menu.setContainsPeanut(menuDetails.isContainsPeanut());
        final Menu updatedMenu = menuRepository.save(menu);
        return ResponseEntity.ok(updatedMenu);
       
    }
    
  
    @DeleteMapping("/menu/{id}")
    public Map<String, Boolean> deleteMenu(@PathVariable(value = "id") Long menuId)
         throws ResourceNotFoundException {
        Menu menu = menuRepository.findById(menuId)
       .orElseThrow(() -> new ResourceNotFoundException("Menu not found for this id :: " + menuId));

        menuRepository.delete(menu);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
      // create a method that collects data from menu form , recipes and nutrition, transform it into arrayList
    // send to library , get the resulting data and get the titles and return them
    
    
    /*
    @PostMapping("/menus")
    public Menu generateMenu(@Validated @RequestBody Menu menu) {
    	System.out.println("WWWWWWWWWWWWWWWWWWWWW=MENU=WWWWWWWWWWWWWWWWWWW" + menu);
    	//get all the recipes, save them in arraylist format, also nutrition, remove the combinations and budget
    	// ;
    	int estimateBudget = Menu.getBudget();
    	int combinationNumber = Menu.getCombinations();
    //	long totalRecipes = RecipeRepository.count();
    	ArrayList<String> ingredients = new ArrayList<>();
    	
    	
    	List<Recipe> recipeList = RecipeController.getAllRecipes();
    	
    	//List<List<String>> newList = DiningManagement.keyComponents(es, Nutrition, recipeList);
    	// new method: 
    	//List<List<String>> newList = DiningManagement.keyComponents(estimatedBudget, combinationNumber,Nutrition, recipeList);
       // return menuRepository.save(menu);
    	 return menuRepository.save(menu);
    }
     */

}
