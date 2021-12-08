package com.example.recipe.model;

import javax.persistence.*;

@Entity
public class RecipeInstruction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String instruction;

    public RecipeInstruction(int id, String instruction) {
        this.id = id;
        this.instruction = instruction;
    }

    public RecipeInstruction() {

    }

    public int getId() {
        return id;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
