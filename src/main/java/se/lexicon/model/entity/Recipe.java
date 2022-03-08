package se.lexicon.model.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;
    private String recipeName;
    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.REFRESH},
    fetch = FetchType.LAZY,
            mappedBy = "recipe")
    private List<RecipeIngredient> recipeIngredients;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_Instruction_Id")
    private RecipeInstruction recipeInstruction;
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinTable(name = "recipe_recipe_Category", joinColumns = @JoinColumn(name = "fk_recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_category_id"))
    private Set<RecipeCategory> recipeCategories;

    protected Recipe() {
    }

    public Recipe(int recipeId, String recipeName) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeIngredients=new ArrayList<>();
        this.recipeInstruction=new RecipeInstruction();
        this.recipeCategories=new HashSet<>();

    }

    public Recipe(int recipeId, String recipeName, List<RecipeIngredient> recipeIngredients,
                  RecipeInstruction recipeInstruction, Set<RecipeCategory> recipeCategories) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstruction = recipeInstruction;
        this.recipeCategories = recipeCategories;
    }

    //Convenience Methods

    public void addRecipeIngredient(RecipeIngredient recipeIngredient){
        if (recipeIngredient == null) throw new IllegalArgumentException("RecipeIngredient was null");
        if (this.recipeIngredients == null) this.recipeIngredients = new ArrayList<>();

        if (!this.recipeIngredients.contains(recipeIngredient)){
            this.recipeIngredients.add(recipeIngredient);
            recipeIngredient.setRecipe(this);
        }
    }

    //Convenience Method
    public void removeRecipeIngredient(RecipeIngredient recipeIngredient){
        if (recipeIngredient == null) throw new IllegalArgumentException("RecipeIngredient was null");
        if (this.recipeIngredients == null) this.recipeIngredients = new ArrayList<>();

        if (this.recipeIngredients.contains(recipeIngredient)){
            this.recipeIngredients.remove(recipeIngredient);
            recipeIngredient.setRecipe(null);
        }
    }


    public void addRecipeCategory(RecipeCategory recipeCategory)
    {
        if (recipeCategory == null) throw new IllegalArgumentException("RecipeCategory was null");
        if (this.recipeCategories == null) this.recipeCategories = new HashSet<>();

        this.recipeCategories.add(recipeCategory);
        recipeCategory.getRecipes().add(this);

    }

    public void removeRecipeCategory(RecipeCategory recipeCategory)
    {
        if (recipeCategory == null) throw new IllegalArgumentException("RecipeCategory was null");
        if (this.recipeCategories == null) this.recipeCategories = new HashSet<>();
        this.recipeCategories.remove(recipeCategory);
        recipeCategory.getRecipes().remove(this);

    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        if(this.recipeIngredients==null)this.recipeIngredients=new ArrayList<>();
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        if (recipeIngredients == null) recipeIngredients = new ArrayList<>();
        if (this.recipeIngredients == null) this.recipeIngredients = new ArrayList<>();

    }

    public RecipeInstruction getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(RecipeInstruction recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    public Set<RecipeCategory> getRecipeCategories() {
        if(this.recipeCategories==null) recipeCategories = new HashSet<>();
        return recipeCategories;
    }

    public void setRecipeCategories(Set<RecipeCategory> recipeCategories) {
        if (recipeCategories == null) recipeCategories = new HashSet<>();
        if (this.recipeCategories == null) this.recipeCategories = new HashSet<>();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return recipeId == recipe.recipeId && Objects.equals(recipeName, recipe.recipeName) && Objects.equals(recipeIngredients, recipe.recipeIngredients) && Objects.equals(recipeInstruction, recipe.recipeInstruction) && Objects.equals(recipeCategories, recipe.recipeCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, recipeName, recipeIngredients, recipeInstruction, recipeCategories);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                '}';
    }
}
