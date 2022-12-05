package fr.maxime.spring.competence.mycomp.personnes;

import fr.maxime.spring.competence.mycomp.competences.Competences;
import fr.maxime.spring.competence.mycomp.personnes.dto.PersonnesMinimalDTO;

import java.util.List;

public interface PersonneService {
    List<PersonnesMinimalDTO> findAll();

    Personne save(Personne entity);

    Personne findById(String id);

    void deleteById(String id);

    /**
     * Ajoute un niveau de compétence à la personne,
     * si cette personne posséde deja cette compétence, la valeur du niveau est mise à jour
     * @param idUser L'id de la personne à modifier
     * @param idComp L'id de la compétence à modifier ou a ajouter
     * @param niveau
     * @return
     */
    Personne ajoutCompetence(String idUser, String idComp, Integer niveau);

    public Personne supprimerNiveauCompetence(String idPersonne, String idCompetence);

    List<Personne> rechercherPersonnesParCompetenceSupA(String idCompetence, int niveau);

}
