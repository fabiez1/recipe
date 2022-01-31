package com.example.recipe.service.facade;

import com.example.recipe.model.dto.RecipeDTO;
import com.example.recipe.model.dto.form.RecipeForm;
import com.example.recipe.model.entity.RecipeCategory;
import com.example.recipe.model.entity.RecipeIngredient;
import com.example.recipe.service.entity.RecipeEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService {
    private final RecipeEntityService recipeEntityService;
    private final DTOService dtoService;

    @Autowired
    public RecipeServiceImpl(RecipeEntityService recipeEntityService, DTOService dtoService) {
        this.recipeEntityService = recipeEntityService;
        this.dtoService = dtoService;
    }

    @Override
    public RecipeDTO create(RecipeForm recipeForm) {
        return dtoService.forRecipeDTO(recipeEntityService.create(recipeForm));
    }

    @Override
    public RecipeDTO findById(int id) {
        return dtoService.forRecipeDTO(recipeEntityService.findById(id));
    }

    @Override
    public List<RecipeDTO> findAll() {
        return recipeEntityService.findAll()
                .stream()
                .map(dtoService::forRecipeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDTO update(int id, RecipeForm recipeForm) {
        return dtoService.forRecipeDTO(recipeEntityService.update(id, recipeForm));
    }

    @Override
    public void delete(int id) {
        recipeEntityService.delete(id);
    }

    @Override
    public List<RecipeDTO> findByRecipeName(String recipeName) {
        return recipeEntityService.findByRecipeName(recipeName)
                .stream()
                .map(dtoService::forRecipeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecipeDTO> findRecipesByRecipeIngredient(List<RecipeIngredient> ingredient) {
        return recipeEntityService.findRecipesByRecipeIngredient(ingredient)
                .stream()
                .map(dtoService::forRecipeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Set<RecipeDTO> findRecipesByCategory(List<RecipeCategory> categories) {
        return recipeEntityService.findRecipesByCategory(categories)
                .stream()
                .map(dtoService::forRecipeDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public List<RecipeDTO> findRecipesByCategories(List<RecipeCategory> categories) {
        return recipeEntityService.findRecipesByCategories(categories)
                .stream()
                .map(dtoService::forRecipeDTO)
                .collect(Collectors.toList());
    }
}
