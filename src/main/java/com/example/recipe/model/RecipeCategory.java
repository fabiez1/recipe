package com.example.recipe.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;
    @ManyToMany
    private Set<Recipe> recipes;

    public RecipeCategory(int id, String category) {
        this.id = id;
        this.category = category;
    }

    public RecipeCategory() {

    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
