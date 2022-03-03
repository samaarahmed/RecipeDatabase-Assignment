package se.lexicon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.model.entity.RecipeIngredient;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient,String> {


}
