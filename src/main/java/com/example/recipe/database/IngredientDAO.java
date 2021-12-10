package com.example.recipe.database;

import com.example.recipe.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IngredientDAO extends JpaRepository<Ingredient, Integer> {
    @Query("SELECT i FROM Ingredient i WHERE LOWER(i.ingredientName) = LOWER(:name)")
    List<Ingredient> findByIngredientName(
            @Param("name") String ingredientName
    );
    @Query("SELECT i FROM Ingredient i WHERE LOWER(i.ingredientName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Ingredient> findByIngredientNameLike(
            @Param("name") String ingredientName
    );
}
