package fr.maxime.spring.competence.mycomp.competences;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CompetencesController {

    private final CompetencesServiceImpl competencesService;

    public CompetencesController(CompetencesServiceImpl competencesService) {
        this.competencesService = competencesService;
    }

    @GetMapping("")
    public List<Competences> findAll() {
        return competencesService.findAll();
    }

    @PostMapping("")
    public Competences save(@RequestBody Competences entity) {
        return competencesService.save(entity);
    }

    @GetMapping("{id}")
    public Competences findById(@PathVariable String id) {
        return competencesService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        competencesService.deleteById(id);
    }


}
