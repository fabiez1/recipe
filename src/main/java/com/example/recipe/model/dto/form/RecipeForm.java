package com.example.recipe.model.dto.form;

import com.example.recipe.model.entity.RecipeCategory;
import com.example.recipe.model.entity.RecipeIngredient;
import com.example.recipe.model.entity.RecipeInstruction;
import com.sun.istack.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Set;

@Validated
public class RecipeForm {
    @NotNull
    private int id;
    @NotNull
    private String recipeName;
    @NotNull
    private List<RecipeIngredient> recipeIngredient;
    @NotNull
    private RecipeInstruction instruction;
    @NotNull
    private Set<RecipeCategory> categories;

    public RecipeForm(int id, String recipeName, List<RecipeIngredient> recipeIngredient, RecipeInstruction instruction, Set<RecipeCategory> categories) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeIngredient = recipeIngredient;
        this.instruction = instruction;
        this.categories = categories;
    }

    public RecipeForm() {
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
