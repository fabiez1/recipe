package com.example.recipe.model.dto;

import com.example.recipe.model.entity.Recipe;

import java.io.Serializable;
import java.util.Set;

public class RecipeCategoryDTO implements Serializable {
    private int id;
    private String category;
    private Set<Recipe> recipes;

    public RecipeCategoryDTO(int id, String category, Set<Recipe> recipes) {
        this.id = id;
        this.category = category;
        this.recipes = recipes;
    }

    public RecipeCategoryDTO() {
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
