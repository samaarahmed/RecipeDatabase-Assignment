package se.lexicon.service;

import se.lexicon.model.entity.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findAll();
    Ingredient create(Ingredient ingredient);
    Ingredient update(Ingredient ingredient);
    void delete (Integer ingredientId);

}
