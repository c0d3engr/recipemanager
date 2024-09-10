package com.c0d3engr.recipemanager.models.rest;

import lombok.Data;
import java.util.List;

@Data
public class Recipe {
    private Long id;
    private String name;
    private String description;
    private List<String> ingredients;
    private List<String> instructions;
}