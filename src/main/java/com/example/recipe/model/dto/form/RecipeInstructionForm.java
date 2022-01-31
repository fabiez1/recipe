package com.example.recipe.model.dto.form;

import com.sun.istack.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public class RecipeInstructionForm {
    @NotNull
    private int id;
    @NotNull
    private String instruction;

    public RecipeInstructionForm(int id, String instruction) {
        this.id = id;
        this.instruction = instruction;
    }

    public RecipeInstructionForm() {
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
