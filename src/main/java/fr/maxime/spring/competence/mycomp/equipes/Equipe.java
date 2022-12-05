package fr.maxime.spring.competence.mycomp.equipes;

import fr.maxime.spring.competence.mycomp.personnes.Personne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Equipe {

    @Id
    private String id;
    private String nom;
    @DBRef
    private Set<Personne> membres = new HashSet<>();


}
