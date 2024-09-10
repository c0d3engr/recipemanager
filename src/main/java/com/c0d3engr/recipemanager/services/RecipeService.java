package com.c0d3engr.recipemanager.services;

import com.c0d3engr.recipemanager.models.rest.Recipe;
import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipes();
    Recipe getRecipeById(Long id);
    Recipe createRecipe(Recipe recipe);
    Recipe updateRecipe(Long id, Recipe recipe);
    void deleteRecipe(Long id);
}