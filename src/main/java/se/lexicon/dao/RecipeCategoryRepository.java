package se.lexicon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.model.entity.RecipeCategory;

public interface RecipeCategoryRepository extends JpaRepository<RecipeCategory,Integer> {


}
