package spring.phlodx.recipeapp.domain;

import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // w tym wypadku Recipe jest właścicielem Notes. Niechcemy gdy usuwa się Notes też usuwało Recipe. dlatego tu nie dodajemy kaskady.
    @OneToOne
    private Recipe recipe;
    @Lob
    private String recipeNotes;

}
