package fr.maxime.spring.competence.mycomp.personnes.dto;

import fr.maxime.spring.competence.mycomp.personnes.NiveauCompetences;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonneCompetenceMaximum {
    private String id;
    private String nom;
    private String prenom;
    private NiveauCompetences competencesMaximum;

}
