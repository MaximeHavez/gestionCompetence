package fr.maxime.spring.competence.mycomp.competences;

import java.util.List;

public class CompetencesController {

    private final CompetencesServiceImpl competencesService;

    public CompetencesController(CompetencesServiceImpl competencesService) {
        this.competencesService = competencesService;
    }

    public List<Competences> findAll() {
        return competencesService.findAll();
    }

    public Competences save(Competences entity) {
        return competencesService.save(entity);
    }

    public Competences findById(String id) {
        return competencesService.findById(id);
    }

    public void deleteById(String id) {
        competencesService.deleteById(id);
    }
}
