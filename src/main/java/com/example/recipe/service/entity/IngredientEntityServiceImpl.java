package com.example.recipe.service.entity;

import com.example.recipe.database.IngredientDAO;
import com.example.recipe.model.dto.form.IngredientForm;
import com.example.recipe.model.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IngredientEntityServiceImpl implements IngredientEntityService{
    private final IngredientDAO ingredientDAO;

    @Autowired
    public IngredientEntityServiceImpl(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

    @Override
    public Ingredient create(IngredientForm ingredientForm) {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName(ingredientForm.getIngredientName());
        ingredientDAO.save(ingredient);
        return ingredient;
    }

    @Override
    public Ingredient findById(int id) {
        return ingredientDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id couldn't be found"));
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredientDAO.findAll();
    }

    @Override
    public Ingredient update(int id, IngredientForm ingredientForm) {
        Ingredient ingredient = new Ingredient();
        Optional<Ingredient> optional = ingredientDAO.findById(id);
        if(optional.isPresent() && optional.get().equals(ingredientForm)) {
            ingredient.setIngredientName(ingredientForm.getIngredientName());
            return ingredientDAO.save(ingredient);
        }
        throw new IllegalArgumentException("Ingredient already exists");
    }

    @Override
    public void delete(int id) {
        Optional<Ingredient> optional = ingredientDAO.findById(id);
        ingredientDAO.delete(optional.get());
    }

    @Override
    public List<Ingredient> findByIngredientName(String ingredientName) {
        return ingredientDAO.findByIngredientName(ingredientName);
    }

    @Override
    public List<Ingredient> findByIngredientNameLike(String ingredientName) {
        return ingredientDAO.findByIngredientNameLike(ingredientName);
    }
}
