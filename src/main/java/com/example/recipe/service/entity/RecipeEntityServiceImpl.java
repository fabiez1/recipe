package com.example.recipe.service.entity;

import com.example.recipe.database.RecipeDAO;
import com.example.recipe.model.dto.form.RecipeForm;
import com.example.recipe.model.entity.Recipe;
import com.example.recipe.model.entity.RecipeCategory;
import com.example.recipe.model.entity.RecipeIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class RecipeEntityServiceImpl implements RecipeEntityService{
    private final RecipeDAO recipeDAO;

    @Autowired
    public RecipeEntityServiceImpl(RecipeDAO recipeDAO) {
        this.recipeDAO = recipeDAO;
    }

    @Override
    public Recipe create(RecipeForm recipeForm) {
        Recipe recipe = new Recipe();
        recipe.setRecipeName(recipeForm.getRecipeName());
        recipe.setRecipeIngredient(recipeForm.getRecipeIngredient());
        recipe.setCategories(recipeForm.getCategories());
        recipe.setInstruction(recipeForm.getInstruction());
        recipeDAO.save(recipe);
        return recipe;
    }

    @Override
    public Recipe findById(int id) {
        return recipeDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id couldn't be found"));
    }

    @Override
    public List<Recipe> findAll() {
        return recipeDAO.findAll();
    }

    @Override
    public Recipe update(int id, RecipeForm recipeForm) {
        Recipe recipe = new Recipe();
        recipe.setRecipeName(recipeForm.getRecipeName());
        recipe.setRecipeIngredient(recipeForm.getRecipeIngredient());
        recipe.setCategories(recipeForm.getCategories());
        recipe.setInstruction(recipeForm.getInstruction());
        recipeDAO.save(recipe);
        return recipe;
    }

    @Override
    public void delete(int id) {
        Optional<Recipe> optional = recipeDAO.findById(id);
        recipeDAO.delete(optional.get());
    }

    @Override
    public List<Recipe> findByRecipeName(String recipeName) {
        return recipeDAO.findByRecipeName(recipeName);
    }

    @Override
    public List<Recipe> findRecipesByRecipeIngredient(List<RecipeIngredient> ingredient) {
        return recipeDAO.findRecipesByRecipeIngredient(ingredient);
    }

    @Override
    public Set<Recipe> findRecipesByCategory(List<RecipeCategory> categories) {
        return recipeDAO.findRecipesByCategory(categories);
    }

    @Override
    public List<Recipe> findRecipesByCategories(List<RecipeCategory> categories) {
        return recipeDAO.findRecipesByCategories(categories);
    }
}
