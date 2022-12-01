package fr.maxime.spring.competence.mycomp.equipes;

import fr.maxime.spring.competence.mycomp.personnes.Personne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Equipe {

    private String id;
    private String nom;
    private String prenom;

    private List<Personne> membres = new ArrayList<>();


}
