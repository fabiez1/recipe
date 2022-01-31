package com.example.recipe.controller;

import com.example.recipe.model.dto.form.RecipeIngredientForm;
import com.example.recipe.model.entity.RecipeIngredient;
import com.example.recipe.service.entity.RecipeIngredientEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeIngredientController {
    private RecipeIngredientEntityService recipeIngredientEntityService;

    @Autowired
    public RecipeIngredientController(RecipeIngredientEntityService recipeIngredientEntityService) {
        this.recipeIngredientEntityService = recipeIngredientEntityService;
    }

    @PostMapping("/api/recipe-ingredient")
    public ResponseEntity<RecipeIngredient> create(RecipeIngredientForm form) {
        RecipeIngredient recipeIngredient = recipeIngredientEntityService.create(form);
        return ResponseEntity.status(201).body(recipeIngredient);
    }

    @GetMapping("api/recipe-ingredient")
    public ResponseEntity<List<RecipeIngredient>> find() {
        return ResponseEntity.ok(recipeIngredientEntityService.findAll());
    }

    @GetMapping("api/recipe-ingredient/{id}")
    public ResponseEntity<RecipeIngredient> findById(@PathVariable("id") int id) {
        return ResponseEntity.ok(recipeIngredientEntityService.findById(id));
    }

    @PutMapping("api/recipe-ingredient/{id}")
    public ResponseEntity<RecipeIngredient> update(@PathVariable("id") int id, @RequestBody RecipeIngredientForm form) {
        return ResponseEntity.ok(recipeIngredientEntityService.update(id, form));
    }

    @DeleteMapping("api/recipe-ingredient/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        recipeIngredientEntityService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
