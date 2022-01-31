package com.example.recipe.model.dto;

import com.example.recipe.model.entity.RecipeCategory;
import com.example.recipe.model.entity.RecipeIngredient;
import com.example.recipe.model.entity.RecipeInstruction;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class RecipeDTO implements Serializable {
    private int id;
    private String recipeName;
    private List<RecipeIngredient> recipeIngredient;
    private RecipeInstruction instruction;
    private Set<RecipeCategory> categories;

    public RecipeDTO(int id, String recipeName, List<RecipeIngredient> recipeIngredient, RecipeInstruction instruction, Set<RecipeCategory> categories) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeIngredient = recipeIngredient;
        this.instruction = instruction;
        this.categories = categories;
    }

    public RecipeDTO() {
    }

    public int getId() {
        return id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getRecipeIngredient() {
        return recipeIngredient;
    }

    public void setRecipeIngredient(List<RecipeIngredient> recipeIngredient) {
        this.recipeIngredient = recipeIngredient;
    }

    public RecipeInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
    }

    public Set<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<RecipeCategory> categories) {
        this.categories = categories;
    }
}
