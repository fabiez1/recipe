package com.example.recipe.controller;

import com.example.recipe.model.dto.form.RecipeInstructionForm;
import com.example.recipe.model.entity.RecipeInstruction;
import com.example.recipe.service.entity.RecipeInstructionEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeInstructionController {
    private RecipeInstructionEntityService recipeInstructionEntityService;

    @Autowired
    public RecipeInstructionController(RecipeInstructionEntityService recipeInstructionEntityService) {
        this.recipeInstructionEntityService = recipeInstructionEntityService;
    }

    @PostMapping("/api/recipe-instruction")
    public ResponseEntity<RecipeInstruction> create(RecipeInstructionForm form) {
        RecipeInstruction recipeInstruction = recipeInstructionEntityService.create(form);
        return ResponseEntity.status(201).body(recipeInstruction);
    }

    @GetMapping("/api/recipe-instruction")
    public ResponseEntity<List<RecipeInstruction>> find() {
        return ResponseEntity.ok(recipeInstructionEntityService.findAll());
    }

    @GetMapping("/api/recipe-instruction/{id}")
    public ResponseEntity<RecipeInstruction> findById(@PathVariable("id") int id) {
        return ResponseEntity.ok(recipeInstructionEntityService.findById(id));
    }

    @PutMapping("/api/recipe-instruction/{id}")
    public ResponseEntity<RecipeInstruction> update(@PathVariable("id") int id, @RequestBody RecipeInstructionForm form) {
        return ResponseEntity.ok(recipeInstructionEntityService.update(id, form));
    }

    @DeleteMapping("/api/recipe-instruction/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        recipeInstructionEntityService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
