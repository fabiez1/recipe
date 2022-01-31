package com.example.recipe.model.dto;

import java.io.Serializable;

public class RecipeInstructionDTO implements Serializable {
    private int id;
    private String instruction;

    public RecipeInstructionDTO(int id, String instruction) {
        this.id = id;
        this.instruction = instruction;
    }

    public RecipeInstructionDTO() {
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
