package se.lexicon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.lexicon.model.entity.Ingredient;
import se.lexicon.service.IngredientService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ingredient/")

public class MainController {


    private final IngredientService ingredientService;
    @Autowired
    public MainController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public ResponseEntity<List> getAll() {
        return ResponseEntity.ok(ingredientService.findAll());
    }

    @PostMapping
    public ResponseEntity<Ingredient> create(@RequestBody Ingredient ingredient) {
        ingredient = ingredientService.create(ingredient);
        return ResponseEntity.ok(ingredient);
    }
    @PutMapping
    public ResponseEntity<Ingredient> update (@RequestBody Ingredient ingredient) {
        ingredient = ingredientService.update(ingredient);
        return ResponseEntity.ok(ingredient);
    }
    @DeleteMapping("{ingredientId}")
    public ResponseEntity<Void> delete(@PathVariable("ingredientId") Integer ingredientId) {
        ingredientService.delete(ingredientId);
        return ResponseEntity.noContent().build();

    }



}
