package fr.maxime.spring.competence.mycomp.personnes;

import fr.maxime.spring.competence.mycomp.competences.CompetencesService;
import fr.maxime.spring.competence.mycomp.personnes.dto.PersonnesMinimalDTO;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/personnes")
public class PersonneController {

    private final PersonneServiceImpl personneService;
    private final CompetencesService competencesService;

    public PersonneController(PersonneServiceImpl personneService, CompetencesService competencesService) {
        this.personneService = personneService;
        this.competencesService = competencesService;
    }

    @GetMapping("")
    public List<PersonnesMinimalDTO> findAll() {
        return personneService.findAll();
    }

    @PostMapping("")
    public Personne save(@RequestBody Personne entity) {
        return personneService.save(entity);
    }

    @GetMapping("{id}")
    public Personne findById(@PathVariable String id) {
        return personneService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        personneService.deleteById(id);
    }

    @PutMapping("/{idUser}/competences/{idComp}")
    public Personne updateCompetences(@PathVariable String idUser, @PathVariable String idComp, @RequestBody Integer niveau){
        return this.personneService.ajoutCompetence(idUser,idComp, niveau);
    }

    @PostMapping("{idPersonne}/competences/{idCompetence}")
    public Personne ajoutCompetence(@PathVariable String idUser,
                                    @PathVariable String idComp,
                                    @RequestParam Integer niveau) {
        return personneService.ajoutCompetence(idUser, idComp, niveau);
    }

    public Personne supprimerNiveauCompetence(String idPersonne, String idCompetence) {
        return personneService.supprimerNiveauCompetence(idPersonne, idCompetence);
    }

    @GetMapping("/competences/{idCompetence}")
    public List<Personne> rechercherPersonnesParCompetenceSupA(@PathVariable String idCompetence, @RequestParam int niveau) {
        return personneService.rechercherPersonnesParCompetenceSupA(idCompetence, niveau);
    }

    //    @PutMapping("/{idUser}/competences/{idComp}}")
//    public Personne ajoutNiveauCompetences(@PathVariable String idUser,
//                                           @PathVariable String idComp,
//                                           @RequestBody NiveauCompetences niveau) {
//        return this.personneService.ajoutCompetence(idUser, idComp, niveau);
//    }

}
