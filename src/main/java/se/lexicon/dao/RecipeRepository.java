package se.lexicon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.model.entity.Recipe;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,Integer> {

    @Query("SELECT n from Recipe n where n.recipeName = :recipeName")
    Recipe findRecipebyname (@Param("recipeName") String recipeName);
    @Query("SELECT i from Recipe i where i.recipeIngredients=:ingredient")
    List<Recipe> findbyRecipebyIngredient (@Param("ingredient") String ingredient);

}
