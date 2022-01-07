package com.example.recipe.database;

import com.example.recipe.model.Recipe;
import com.example.recipe.model.RecipeCategory;
import com.example.recipe.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface RecipeDAO extends JpaRepository<Recipe, Integer> {

    
    @Query("SELECT r FROM Recipe r WHERE r.recipeName = LOWER(:name)")
    List<Recipe> findByRecipeName(
            @Param("name") String recipeName
    );
    @Query("SELECT r FROM Recipe r, RecipeIngredient ri INNER JOIN ri.ingredient WHERE ri.ingredient = LOWER(:ingredient)")
    List<Recipe> findRecipesByRecipeIngredient(
            @Param("ingredient") List<RecipeIngredient> ingredient);
    @Query("SELECT r FROM Recipe r JOIN RecipeCategory rc WHERE r.categories = LOWER(:category)")
    Set<Recipe> findRecipesByCategory(
            @Param("category") List<RecipeCategory> categories
    );
    @Query("SELECT r FROM Recipe r JOIN RecipeCategory rc WHERE r.categories IN :category")
    List<Recipe> findRecipesByCategories(
            @Param("category") List<RecipeCategory> categories
    );
}
