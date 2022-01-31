package com.example.recipe.model.dto;

import com.example.recipe.model.entity.Ingredient;
import com.example.recipe.model.entity.Measurement;
import com.example.recipe.model.entity.Recipe;

import java.io.Serializable;

public class RecipeIngredientDTO implements Serializable {
    private int id;
    private double amount;
    private Ingredient ingredient;
    private Measurement measurement;
    private Recipe recipe;

    public RecipeIngredientDTO(int id, double amount, Ingredient ingredient, Measurement measurement, Recipe recipe) {
        this.id = id;
        this.amount = amount;
        this.ingredient = ingredient;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public RecipeIngredientDTO() {
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
