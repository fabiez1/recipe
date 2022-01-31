package com.example.recipe.model.dto.form;

import com.example.recipe.model.entity.Ingredient;
import com.example.recipe.model.entity.Measurement;
import com.example.recipe.model.entity.Recipe;
import com.sun.istack.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public class RecipeIngredientForm {
    @NotNull
    private int id;
    @NotNull
    private double amount;
    @NotNull
    private Ingredient ingredient;
    @NotNull
    private Measurement measurement;
    @NotNull
    private Recipe recipe;

    public RecipeIngredientForm(int id, double amount, Ingredient ingredient, Measurement measurement, Recipe recipe) {
        this.id = id;
        this.amount = amount;
        this.ingredient = ingredient;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public RecipeIngredientForm() {
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
