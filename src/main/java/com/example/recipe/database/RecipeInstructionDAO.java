package com.example.recipe.database;

import com.example.recipe.model.entity.RecipeInstruction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeInstructionDAO extends JpaRepository<RecipeInstruction, Integer> {
}
