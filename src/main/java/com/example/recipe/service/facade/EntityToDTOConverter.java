package com.example.recipe.service.facade;

import com.example.recipe.model.dto.IngredientDTO;
import com.example.recipe.model.dto.RecipeDTO;
import com.example.recipe.model.dto.RecipeIngredientDTO;
import com.example.recipe.model.dto.RecipeInstructionDTO;
import com.example.recipe.model.entity.Ingredient;
import com.example.recipe.model.entity.Recipe;
import com.example.recipe.model.entity.RecipeIngredient;
import com.example.recipe.model.entity.RecipeInstruction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class EntityToDTOConverter implements DTOService{
    @Override
    public IngredientDTO forIngredientDTO(Ingredient ingredient) {
        if(ingredient == null) { return null; }
        IngredientDTO ingredientDTO = new IngredientDTO();
        ingredientDTO.setIngredientName(ingredient.getIngredientName());
        return ingredientDTO;
    }

    @Override
    public RecipeDTO forRecipeDTO(Recipe recipe) {
        if(recipe == null) { return null; }
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setRecipeName(recipe.getRecipeName());
        recipeDTO.setRecipeIngredient(recipe.getRecipeIngredient());
        recipeDTO.setCategories(recipe.getCategories());
        recipeDTO.setInstruction(recipe.getInstruction());
        return recipeDTO;
    }

    @Override
    public RecipeIngredientDTO forRecipeIngredientDTO(RecipeIngredient recipeIngredient) {
        if(recipeIngredient == null) { return null; }
        RecipeIngredientDTO recipeIngredientDTO = new RecipeIngredientDTO();
        recipeIngredientDTO.setAmount(recipeIngredient.getAmount());
        recipeIngredientDTO.setIngredient(recipeIngredient.getIngredient());
        recipeIngredientDTO.setMeasurement(recipeIngredient.getMeasurement());
        recipeIngredientDTO.setRecipe(recipeIngredient.getRecipe());
        return recipeIngredientDTO;
    }

    @Override
    public RecipeInstructionDTO forRecipeInstruction(RecipeInstruction recipeInstruction) {
        if(recipeInstruction == null) { return null; }
        RecipeInstructionDTO recipeInstructionDTO = new RecipeInstructionDTO();
        recipeInstructionDTO.setInstruction(recipeInstruction.getInstruction());
        return recipeInstructionDTO;
    }
}
