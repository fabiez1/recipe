package com.example.recipe.service.facade;

import com.example.recipe.model.dto.RecipeInstructionDTO;
import com.example.recipe.model.dto.form.RecipeInstructionForm;
import com.example.recipe.service.entity.RecipeInstructionEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RecipeInstructionServiceImpl implements RecipeInstructionService{
    private final RecipeInstructionEntityService recipeInstructionEntityService;
    private final DTOService dtoService;

    @Autowired
    public RecipeInstructionServiceImpl(RecipeInstructionEntityService recipeInstructionEntityService, DTOService dtoService) {
        this.recipeInstructionEntityService = recipeInstructionEntityService;
        this.dtoService = dtoService;
    }

    @Override
    public RecipeInstructionDTO create(RecipeInstructionForm recipeInstructionForm) {
        return dtoService.forRecipeInstruction(recipeInstructionEntityService.create(recipeInstructionForm));
    }

    @Override
    public RecipeInstructionDTO findById(int id) {
        return dtoService.forRecipeInstruction(recipeInstructionEntityService.findById(id));
    }

    @Override
    public List<RecipeInstructionDTO> findAll() {
        return recipeInstructionEntityService.findAll()
                .stream()
                .map(dtoService::forRecipeInstruction)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeInstructionDTO update(int id, RecipeInstructionForm recipeInstructionForm) {
        return dtoService.forRecipeInstruction(recipeInstructionEntityService.update(id, recipeInstructionForm));
    }

    @Override
    public void delete(int id) {
        recipeInstructionEntityService.delete(id);
    }
}
