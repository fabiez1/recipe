package com.example.recipe.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String recipeName;
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
    private List<RecipeIngredient> recipeIngredient;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    public RecipeInstruction instruction;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Set<RecipeCategory> categories;

    public Recipe(int id, String recipeName) {
        this.id = id;
        this.recipeName = recipeName;
    }

    public Recipe() {

    }

    public int getId() {
        return id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
}
