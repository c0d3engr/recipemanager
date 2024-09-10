package com.c0d3engr.recipemanager.mappers;

import com.c0d3engr.recipemanager.models.entities.RecipeEntity;
import com.c0d3engr.recipemanager.models.rest.Recipe;
import org.springframework.stereotype.Component;

@Component
public class RecipeMapper {
    public Recipe toRest(RecipeEntity entity) {
        Recipe rest = new Recipe();
        rest.setId(entity.getId());
        rest.setName(entity.getName());
        rest.setDescription(entity.getDescription());
        rest.setIngredients(entity.getIngredients());
        rest.setInstructions(entity.getInstructions());
        return rest;
    }

    public RecipeEntity toEntity(Recipe rest) {
        RecipeEntity entity = new RecipeEntity();
        entity.setId(rest.getId());
        entity.setName(rest.getName());
        entity.setDescription(rest.getDescription());
        entity.setIngredients(rest.getIngredients());
        entity.setInstructions(rest.getInstructions());
        return entity;
    }
}