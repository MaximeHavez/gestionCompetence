package fr.maxime.spring.competence.mycomp.personnes;

import fr.maxime.spring.competence.mycomp.competences.Competences;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NiveauCompetences {
    @DBRef
    private Competences competence;
    private Integer niveau;

}
