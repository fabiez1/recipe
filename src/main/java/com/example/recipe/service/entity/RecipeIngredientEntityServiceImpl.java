package com.example.recipe.service.entity;

import com.example.recipe.database.RecipeIngredientDAO;
import com.example.recipe.model.dto.form.RecipeIngredientForm;
import com.example.recipe.model.entity.RecipeIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipeIngredientEntityServiceImpl implements RecipeIngredientEntityService{
    private final RecipeIngredientDAO recipeIngredientDAO;

    @Autowired
    public RecipeIngredientEntityServiceImpl(RecipeIngredientDAO recipeIngredientDAO) {
        this.recipeIngredientDAO = recipeIngredientDAO;
    }

    @Override
    public RecipeIngredient create(RecipeIngredientForm recipeIngredientForm) {
        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setAmount(recipeIngredientForm.getAmount());
        recipeIngredient.setIngredient(recipeIngredientForm.getIngredient());
        recipeIngredient.setMeasurement(recipeIngredientForm.getMeasurement());
        recipeIngredient.setRecipe(recipeIngredientForm.getRecipe());
        return recipeIngredientDAO.save(recipeIngredient);
    }

    @Override
    public RecipeIngredient findById(int id) {
        return recipeIngredientDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id couldn't be found"));
    }

    @Override
    public List<RecipeIngredient> findAll() {
        return recipeIngredientDAO.findAll();
    }

    @Override
    public RecipeIngredient update(int id, RecipeIngredientForm recipeIngredientForm) {
        RecipeIngredient recipeIngredient = new RecipeIngredient();
        Optional<RecipeIngredient> optional = recipeIngredientDAO.findById(id);
        if(optional.isPresent() && optional.get().equals(recipeIngredient)) {
            recipeIngredient.setAmount(recipeIngredientForm.getAmount());
            recipeIngredient.setIngredient(recipeIngredientForm.getIngredient());
            recipeIngredient.setMeasurement(recipeIngredientForm.getMeasurement());
            recipeIngredient.setRecipe(recipeIngredientForm.getRecipe());
            return recipeIngredientDAO.save(recipeIngredient);
        }
        throw new IllegalArgumentException("RecipeIngredient already exists");
    }

    @Override
    public void delete(int id) {
        Optional<RecipeIngredient> optional = recipeIngredientDAO.findById(id);
        recipeIngredientDAO.delete(optional.get());
    }
}
