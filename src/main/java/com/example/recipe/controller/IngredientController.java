package com.example.recipe.controller;

import com.example.recipe.model.dto.form.IngredientForm;
import com.example.recipe.model.entity.Ingredient;
import com.example.recipe.service.entity.IngredientEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {
    private IngredientEntityService ingredientEntityService;

    @Autowired
    public IngredientController(IngredientEntityService ingredientEntityService) {
        this.ingredientEntityService = ingredientEntityService;
    }

    @PostMapping("/api/ingredient")
    public ResponseEntity<Ingredient> create(@RequestBody IngredientForm form) {
        Ingredient ingredient = ingredientEntityService.create(form);
        return ResponseEntity.status(201).body(ingredient);
    }

    @GetMapping("api/ingredient")
    public ResponseEntity<List<Ingredient>> find() {
        return ResponseEntity.ok(ingredientEntityService.findAll());
    }

    @GetMapping("api/ingredient/{id}")
    public ResponseEntity<Ingredient> findById(@PathVariable("id") int id) {
        return ResponseEntity.ok(ingredientEntityService.findById(id));
    }

    @PutMapping("api/ingredient/{id}")
    public ResponseEntity<Ingredient> update(@PathVariable("id") int id, @RequestBody IngredientForm form) {
        return ResponseEntity.ok(ingredientEntityService.update(id, form));
    }

    @DeleteMapping("api/ingredient/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        ingredientEntityService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
