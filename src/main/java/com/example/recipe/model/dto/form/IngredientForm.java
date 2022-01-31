package com.example.recipe.model.dto.form;

import com.sun.istack.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public class IngredientForm {
    @NotNull
    private int id;
    @NotNull
    private String ingredientName;

    public IngredientForm(int id, String ingredientName) {
        this.id = id;
        this.ingredientName = ingredientName;
    }

    public IngredientForm() {
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
