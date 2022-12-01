package fr.maxime.spring.competence.mycomp.personnes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/personnes")
public class PersonneController {

    private final PersonneServiceImpl personneService;

    public PersonneController(PersonneServiceImpl personneService) {
        this.personneService = personneService;
    }

    @GetMapping("")
    public List<Personne> findAll() {
        return personneService.findAll();
    }

    @PostMapping("")
    public Personne save(Personne entity) {
        return personneService.save(entity);
    }

    @GetMapping("{id}")
    public Personne findById(String id) {
        return personneService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(String id) {
        personneService.deleteById(id);
    }
}
