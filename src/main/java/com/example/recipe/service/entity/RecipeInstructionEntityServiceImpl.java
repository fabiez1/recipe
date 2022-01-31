package com.example.recipe.service.entity;

import com.example.recipe.database.RecipeInstructionDAO;
import com.example.recipe.model.dto.form.RecipeInstructionForm;
import com.example.recipe.model.entity.RecipeInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipeInstructionEntityServiceImpl implements RecipeInstructionEntityService {
    private final RecipeInstructionDAO recipeInstructionDAO;

    @Autowired
    public RecipeInstructionEntityServiceImpl(RecipeInstructionDAO recipeInstructionDAO) {
        this.recipeInstructionDAO = recipeInstructionDAO;
    }

    @Override
    public RecipeInstruction create(RecipeInstructionForm recipeInstructionForm) {
        RecipeInstruction recipeInstruction = new RecipeInstruction();
        recipeInstruction.setInstruction(recipeInstructionForm.getInstruction());
        recipeInstructionDAO.save(recipeInstruction);
        return recipeInstruction;
    }

    @Override
    public RecipeInstruction findById(int id) {
        return recipeInstructionDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id couldn't be found"));
    }

    @Override
    public List<RecipeInstruction> findAll() {
        return recipeInstructionDAO.findAll();
    }

    @Override
    public RecipeInstruction update(int id, RecipeInstructionForm recipeInstructionForm) {
        RecipeInstruction recipeInstruction = new RecipeInstruction();
        recipeInstruction.setInstruction(recipeInstructionForm.getInstruction());
        recipeInstructionDAO.save(recipeInstruction);
        return recipeInstruction;
    }

    @Override
    public void delete(int id) {
        Optional<RecipeInstruction> optional = recipeInstructionDAO.findById(id);
        recipeInstructionDAO.delete(optional.get());
    }
}
