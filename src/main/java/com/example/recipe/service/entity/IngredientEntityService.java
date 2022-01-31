package com.example.recipe.service.entity;

import com.example.recipe.model.dto.form.IngredientForm;
import com.example.recipe.model.entity.Ingredient;
import com.example.recipe.service.GenericService;

import java.util.List;

public interface IngredientEntityService extends GenericService<Ingredient, IngredientForm> {
    List<Ingredient> findByIngredientName(String ingredientName);
    List<Ingredient> findByIngredientNameLike(String ingredientName);
}
