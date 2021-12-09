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
    public Measurement measurement;
    @ManyToOne(cascade = CascadeType.ALL)
    public Recipe recipe;

    public RecipeIngredient(int id, double amount) {
        this.id = id;
        this.amount = amount;
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
}
