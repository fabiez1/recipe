package com.example.recipe.database;

import com.example.recipe.model.entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientDAO extends JpaRepository<RecipeIngredient, Integer> {
}
