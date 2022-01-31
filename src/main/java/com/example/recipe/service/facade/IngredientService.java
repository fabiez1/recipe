package com.example.recipe.service.facade;

import com.example.recipe.model.dto.IngredientDTO;
import com.example.recipe.model.dto.form.IngredientForm;
import com.example.recipe.service.GenericService;

import java.util.List;

public interface IngredientService extends GenericService<IngredientDTO, IngredientForm> {
    List<IngredientDTO> findByIngredientName(String ingredientName);
    List<IngredientDTO> findByIngredientNameLike(String ingredientName);
}
