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
    public RecipeInstruction instruction;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "recipe_recipe_categories", joinColumns = @JoinColumn(name = "recipe_id")
            , inverseJoinColumns = @JoinColumn(name = "recipe_category_id"))
    private Set<RecipeCategory> categories;

    public Recipe(int id, String recipeName, List<RecipeIngredient> recipeIngredient, RecipeInstruction instruction, Set<RecipeCategory> categories) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeIngredient = recipeIngredient;
        this.instruction = instruction;
        this.categories = categories;
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
