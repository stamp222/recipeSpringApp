package spring.phlodx.recipeapp.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Notes notes = (Notes) o;
        return id != null && Objects.equals(id, notes.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
