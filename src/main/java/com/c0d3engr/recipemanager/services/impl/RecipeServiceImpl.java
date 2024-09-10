package com.c0d3engr.recipemanager.services.impl;

import com.c0d3engr.recipemanager.mappers.RecipeMapper;
import com.c0d3engr.recipemanager.models.entities.RecipeEntity;
import com.c0d3engr.recipemanager.models.rest.Recipe;
import com.c0d3engr.recipemanager.repositories.RecipeRepository;
import com.c0d3engr.recipemanager.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeMapper recipeMapper;

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll().stream()
                .map(recipeMapper::toRest)
                .collect(Collectors.toList());
    }

    @Override
    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id)
                .map(recipeMapper::toRest)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        RecipeEntity entity = recipeMapper.toEntity(recipe);
        return recipeMapper.toRest(recipeRepository.save(entity));
    }

    @Override
    public Recipe updateRecipe(Long id, Recipe recipe) {
        RecipeEntity entity = recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
        entity.setName(recipe.getName());
        entity.setDescription(recipe.getDescription());
        entity.setIngredients(recipe.getIngredients());
        entity.setInstructions(recipe.getInstructions());
        return recipeMapper.toRest(recipeRepository.save(entity));
    }

    @Override
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }
}