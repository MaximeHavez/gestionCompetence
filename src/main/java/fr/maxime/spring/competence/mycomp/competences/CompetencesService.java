package fr.maxime.spring.competence.mycomp.competences;

import java.util.List;

public interface CompetencesService {
    List<Competences> findAll();

    Competences save(Competences entity);

    Competences findById(String id);

    void deleteById(String id);
}
