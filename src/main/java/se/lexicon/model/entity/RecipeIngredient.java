package se.lexicon.model.entity;

import org.hibernate.annotations.GenericGenerator;
import se.lexicon.model.constant.Measurement;

import javax.persistence.*;

import java.util.Objects;

import static se.lexicon.model.constant.EntityConstants.GENERATOR;
import static se.lexicon.model.constant.EntityConstants.UUID_GENERATOR;

@Entity
public class RecipeIngredient {

    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR,strategy = UUID_GENERATOR)
    private String recipeIngredientId;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_Id")
    private Ingredient ingredient;

    private double amount;
    private Measurement measurement;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_recipe_id")

    private Recipe recipe;

    protected RecipeIngredient() {
    }

    public RecipeIngredient(String recipeIngredientId, Ingredient ingredient, double amount,
                            Measurement measurement, Recipe recipe)
    {
        this.recipeIngredientId = recipeIngredientId;
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public String getRecipeIngredientId() {
        return recipeIngredientId;
    }

    public void setRecipeIngredientId(String recipeIngredientId) {
        this.recipeIngredientId = recipeIngredientId;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(recipeIngredientId, that.recipeIngredientId) && Objects.equals(ingredient, that.ingredient) && measurement == that.measurement && Objects.equals(recipe, that.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeIngredientId, ingredient, amount, measurement, recipe);
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "recipeIngredientId='" + recipeIngredientId + '\'' +
                ", ingredient=" + ingredient +
                ", amount=" + amount +
                ", measurement=" + measurement +
                ", recipe=" + recipe +
                '}';
    }
}
