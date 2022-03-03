package se.lexicon.model.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
@Entity
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String category;
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.REFRESH},
            fetch = FetchType.LAZY,
            mappedBy = "recipeCategories")
    private Set<Recipe> recipes;

    protected RecipeCategory() {
    }

    public RecipeCategory(int categoryId, String category) {
        this.categoryId = categoryId;
        this.category = category;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return categoryId == that.categoryId && Objects.equals(category, that.category) && Objects.equals(recipes, that.recipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, category, recipes);
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "categoryId=" + categoryId +
                ", category='" + category + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
