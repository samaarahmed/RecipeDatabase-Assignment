package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.dao.IngredientRepository;
import se.lexicon.model.entity.Ingredient;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IngredientServiceimpl implements IngredientService{


    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceimpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();

    }

    @Override
    public Ingredient create(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
        return ingredient;
    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
        return ingredient;
    }

    @Override
    public void delete(Integer ingredientId) {
        Optional<Ingredient> foundIngredient = ingredientRepository.findById(ingredientId);
        if (foundIngredient.isPresent()) {
            ingredientRepository.deleteById(ingredientId);
        } else {

            throw new IllegalArgumentException("Required ID not found");
        }
    }

    }

