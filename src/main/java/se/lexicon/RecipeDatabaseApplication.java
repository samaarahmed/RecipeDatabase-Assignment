package se.lexicon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.lexicon.dao.IngredientRepository;
import se.lexicon.dao.RecipeIngredientRepository;
import se.lexicon.dao.RecipeRepository;
import se.lexicon.model.constant.Measurement;
import se.lexicon.model.entity.Ingredient;
import se.lexicon.model.entity.Recipe;
import se.lexicon.model.entity.RecipeIngredient;

@SpringBootApplication
public class RecipeDatabaseApplication implements CommandLineRunner {
	@Autowired
	IngredientRepository ingredientRepository;
	@Autowired
	RecipeIngredientRepository recipeIngredientRepository;
	RecipeRepository recipeRepository;

	public static void main(String[] args) {
		SpringApplication.run(RecipeDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ingredientRepository.save(new Ingredient(0,"red chilli"));
		ingredientRepository.save(new Ingredient(0,"salt"));
		ingredientRepository.save(new Ingredient(0,"green chilli"));

		//System.out.println(ingredientRepository.findIngredientByIngredientName("salt"));
		//System.out.println(ingredientRepository.findByExactName("red chilli"));
		System.out.println(ingredientRepository.findIngredientByIngredientName("sa"));

		recipeIngredientRepository.save(new RecipeIngredient(null,new Ingredient(1,"red chilli"),
				20.00, Measurement.HG,new Recipe(1,"omelette")));


	}
}
