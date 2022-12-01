package fr.maxime.spring.competence.mycomp.equipes;

import java.util.List;

public interface EquipeService {
    List<Equipe> findAll();

    Equipe save(Equipe entity);

    Equipe findById(String id);

    void deleteById(String id);

    /**
     * Ajoute un membre {idMembre} à l'équipe {idEquipe}
     * @param idEquipe id de l'équipe
     * @param idMembre id de la personne qui devient membre
     * @return l'équipe avec les membres
     */
    Equipe ajoutMembre(String idEquipe, String idMembre);

    Equipe suppressionMembre(String idEquipe, String idMembre);
}
