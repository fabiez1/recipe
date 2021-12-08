package com.example.recipe.model;

import javax.persistence.Column;

public class Ingredient {
    private int id;
    @Column(unique = true)
    private String ingredientName;
}
