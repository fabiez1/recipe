package com.example.recipe.service.facade;

import com.example.recipe.model.dto.IngredientDTO;
import com.example.recipe.model.dto.RecipeDTO;
import com.example.recipe.model.dto.RecipeIngredientDTO;
import com.example.recipe.model.dto.RecipeInstructionDTO;
import com.example.recipe.model.entity.Ingredient;
import com.example.recipe.model.entity.Recipe;
import com.example.recipe.model.entity.RecipeIngredient;
import com.example.recipe.model.entity.RecipeInstruction;

public interface DTOService {
    IngredientDTO forIngredientDTO(Ingredient ingredient);
    RecipeDTO forRecipeDTO(Recipe recipe);
    RecipeIngredientDTO forRecipeIngredientDTO(RecipeIngredient recipeIngredient);
    RecipeInstructionDTO forRecipeInstruction(RecipeInstruction recipeInstruction);
}
