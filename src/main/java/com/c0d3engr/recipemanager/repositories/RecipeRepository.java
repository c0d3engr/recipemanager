package com.c0d3engr.recipemanager.repositories;

import com.c0d3engr.recipemanager.models.entities.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import com.c0d3engr.recipemanager.models.rest.Recipe;
import java.util.List;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
    
    List<Recipe> getAllRecipes();
    Recipe getRecipeById(Long id);
    Recipe createRecipe(Recipe recipe);
    Recipe updateRecipe(Long id, Recipe recipe);
    void deleteRecipe(Long id);
}