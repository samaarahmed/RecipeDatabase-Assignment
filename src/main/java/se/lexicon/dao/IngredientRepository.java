package se.lexicon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.model.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {

    //Using JPA Repository builtin methods
    Ingredient findIngredientByIngredientName (String ingredientName);
    //Using a query
    @Query("SELECT n from Ingredient n where n.ingredientName = :ingredientName")
    Ingredient findByExactName (@Param("ingredientName") String ingredientName);

    @Query("select n from Ingredient n where n.ingredientName like '%ingredientName' ")
    Ingredient findbypartofingredientName ( String ingredientName);

}
