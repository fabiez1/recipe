package com.example.recipe.model.dto;

import javax.persistence.Column;
import java.io.Serializable;

public class IngredientDTO implements Serializable {
    private int id;
    private String ingredientName;

    public IngredientDTO(int id, String ingredientName) {
        this.id = id;
        this.ingredientName = ingredientName;
    }

    public IngredientDTO() {
    }

    public int getId() {
        return id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
