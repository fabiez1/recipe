package com.example.recipe.service.facade;

import com.example.recipe.model.dto.IngredientDTO;
import com.example.recipe.model.dto.form.IngredientForm;
import com.example.recipe.model.entity.Ingredient;
import com.example.recipe.service.entity.IngredientEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class IngredientServiceImpl implements IngredientService{
    private final IngredientEntityService ingredientEntityService;
    private final DTOService dtoService;

    @Autowired
    public IngredientServiceImpl(IngredientEntityService ingredientEntityService, DTOService dtoService) {
        this.ingredientEntityService = ingredientEntityService;
        this.dtoService = dtoService;
    }


    @Override
    public IngredientDTO create(IngredientForm ingredientForm) {
        return dtoService.forIngredientDTO(ingredientEntityService.create(ingredientForm));
    }

    @Override
    public IngredientDTO findById(int id) {
        return dtoService.forIngredientDTO(ingredientEntityService.findById(id));
    }

    @Override
    public List<IngredientDTO> findAll() {
        return ingredientEntityService.findAll()
                .stream()
                .map(dtoService::forIngredientDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IngredientDTO update(int id, IngredientForm ingredientForm) {
        return dtoService.forIngredientDTO(ingredientEntityService.update(id, ingredientForm));
    }

    @Override
    public void delete(int id) {
        ingredientEntityService.delete(id);
    }

    @Override
    public List<IngredientDTO> findByIngredientName(String ingredientName) {
        return ingredientEntityService.findByIngredientName(ingredientName)
                .stream()
                .map(dtoService::forIngredientDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<IngredientDTO> findByIngredientNameLike(String ingredientName) {
        return ingredientEntityService.findByIngredientNameLike(ingredientName)
                .stream()
                .map(dtoService::forIngredientDTO)
                .collect(Collectors.toList());
    }
}
