package com.example.recipe.service.facade;

import com.example.recipe.model.dto.RecipeDTO;
import com.example.recipe.model.dto.form.RecipeForm;
import com.example.recipe.model.entity.RecipeCategory;
import com.example.recipe.model.entity.RecipeIngredient;
import com.example.recipe.service.GenericService;

import java.util.List;
import java.util.Set;

public interface RecipeService extends GenericService<RecipeDTO, RecipeForm> {
    List<RecipeDTO> findByRecipeName(String recipeName);
    List<RecipeDTO> findRecipesByRecipeIngredient(List<RecipeIngredient> ingredient);
    Set<RecipeDTO> findRecipesByCategory(List<RecipeCategory> categories);
    List<RecipeDTO> findRecipesByCategories(List<RecipeCategory> categories);
}
