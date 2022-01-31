package com.example.recipe.database;

import com.example.recipe.model.entity.Ingredient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IngredientDAOTest {
    @Autowired
    private IngredientDAO ingredientDAO;

    @Test
    void findByIngredientName() {
        Ingredient ingredient = ingredientDAO.save(
                new Ingredient(1,"Sugar")
        );

        List<Ingredient> result = ingredientDAO.findByIngredientName("Sugar");
        assertEquals(ingredient.getIngredientName(), result.get(0).getIngredientName());
    }

    @Test
    void findByIngredientNameLike() {
        Ingredient ingredient = ingredientDAO.save(
                new Ingredient(2, "Milk")
        );

        List<Ingredient> result = ingredientDAO.findByIngredientNameLike("Mi");
        assertEquals(ingredient.getIngredientName(), result.get(0).getIngredientName());
    }
}