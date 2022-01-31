package com.example.recipe.controller;

import com.example.recipe.model.dto.form.RecipeForm;
import com.example.recipe.model.entity.Recipe;
import com.example.recipe.service.entity.RecipeEntityService;
import com.example.recipe.service.facade.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {
    private RecipeEntityService recipeEntityService;

    @Autowired
    public RecipeController(RecipeEntityService recipeEntityService) {
        this.recipeEntityService = recipeEntityService;
    }

    @PostMapping("/api/recipe")
    public ResponseEntity<Recipe> create(RecipeForm form) {
        Recipe recipe = recipeEntityService.create(form);
        return ResponseEntity.status(201).body(recipe);
    }

    @GetMapping("api/recipe")
    public ResponseEntity<List<Recipe>> find() {
        return ResponseEntity.ok(recipeEntityService.findAll());
    }

    @GetMapping("api/recipe/{id}")
    public ResponseEntity<Recipe> findById(@PathVariable("id") int id) {
        return ResponseEntity.ok(recipeEntityService.findById(id));
    }

    @PutMapping("api/recipe/{id}")
    public ResponseEntity<Recipe> update(@PathVariable("id") int id, @RequestBody RecipeForm form) {
        return ResponseEntity.ok(recipeEntityService.update(id, form));
    }

    @DeleteMapping("api/recipe/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        recipeEntityService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
