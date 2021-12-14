package com.example.recipe.model;

import javax.persistence.*;

@Entity
public class RecipeIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private int id;
    private double amount;
    @ManyToOne(cascade = CascadeType.ALL)
    private Ingredient ingredient;
    private Measurement measurement;
    @ManyToOne(cascade = CascadeType.ALL)
    private Recipe recipe;

    public RecipeIngredient(int id, double amount, Ingredient ingredient, Measurement measurement, Recipe recipe) {
        this.id = id;
        this.amount = amount;
        this.ingredient = ingredient;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public RecipeIngredient() {

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
