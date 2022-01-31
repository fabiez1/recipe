package com.example.recipe.service.entity;

import com.example.recipe.model.dto.form.RecipeForm;
import com.example.recipe.model.entity.Recipe;
import com.example.recipe.model.entity.RecipeCategory;
import com.example.recipe.model.entity.RecipeIngredient;
import com.example.recipe.service.GenericService;

import java.util.List;
import java.util.Set;

public interface RecipeEntityService extends GenericService<Recipe, RecipeForm> {
    List<Recipe> findByRecipeName(String recipeName);
    List<Recipe> findRecipesByRecipeIngredient(List<RecipeIngredient> ingredient);
    Set<Recipe> findRecipesByCategory(List<RecipeCategory> categories);
    List<Recipe> findRecipesByCategories(List<RecipeCategory> categories);
}
