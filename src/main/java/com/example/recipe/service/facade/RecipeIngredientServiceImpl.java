package com.example.recipe.service.facade;

import com.example.recipe.model.dto.RecipeIngredientDTO;
import com.example.recipe.model.dto.form.RecipeIngredientForm;
import com.example.recipe.service.entity.RecipeIngredientEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RecipeIngredientServiceImpl implements RecipeIngredientService{
    private final RecipeIngredientEntityService recipeIngredientEntityService;
    private final DTOService dtoService;

    @Autowired
    public RecipeIngredientServiceImpl(RecipeIngredientEntityService recipeIngredientEntityService, DTOService dtoService) {
        this.recipeIngredientEntityService = recipeIngredientEntityService;
        this.dtoService = dtoService;
    }

    @Override
    public RecipeIngredientDTO create(RecipeIngredientForm recipeIngredientForm) {
        return dtoService.forRecipeIngredientDTO(recipeIngredientEntityService.create(recipeIngredientForm));
    }

    @Override
    public RecipeIngredientDTO findById(int id) {
        return dtoService.forRecipeIngredientDTO(recipeIngredientEntityService.findById(id));
    }

    @Override
    public List<RecipeIngredientDTO> findAll() {
        return recipeIngredientEntityService.findAll()
                .stream()
                .map(dtoService::forRecipeIngredientDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeIngredientDTO update(int id, RecipeIngredientForm recipeIngredientForm) {
        return dtoService.forRecipeIngredientDTO(recipeIngredientEntityService.update(id, recipeIngredientForm));
    }

    @Override
    public void delete(int id) {
        recipeIngredientEntityService.delete(id);
    }
}
