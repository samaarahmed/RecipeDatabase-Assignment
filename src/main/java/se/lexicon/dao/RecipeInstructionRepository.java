package se.lexicon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.model.entity.RecipeInstruction;

public interface RecipeInstructionRepository extends JpaRepository<RecipeInstruction,String> {


}
