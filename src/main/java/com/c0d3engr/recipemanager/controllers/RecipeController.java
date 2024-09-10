package com.c0d3engr.recipemanager.controllers;

import com.c0d3engr.recipemanager.models.rest.Recipe;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface RecipeController {
    ResponseEntity<List<Recipe>> getAllRecipes();
    ResponseEntity<Recipe> getRecipeById(Long id);
    ResponseEntity<Recipe> createRecipe(Recipe recipe);
    ResponseEntity<Recipe> updateRecipe(Long id, Recipe recipe);
    ResponseEntity<Void> deleteRecipe(Long id);
}