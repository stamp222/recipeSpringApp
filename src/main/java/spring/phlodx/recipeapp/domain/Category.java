package spring.phlodx.recipeapp.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> racipes;

    public Set<Recipe> getRacipes() {
        return racipes;
    }

    public void setRacipes(Set<Recipe> racipes) {
        this.racipes = racipes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
