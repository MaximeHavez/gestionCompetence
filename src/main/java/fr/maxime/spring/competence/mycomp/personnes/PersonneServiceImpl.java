package fr.maxime.spring.competence.mycomp.personnes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.maxime.spring.competence.mycomp.competences.Competences;
import fr.maxime.spring.competence.mycomp.competences.CompetencesService;
import fr.maxime.spring.competence.mycomp.competences.CompetencesServiceImpl;
import fr.maxime.spring.competence.mycomp.personnes.dto.PersonnesMinimalDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class PersonneServiceImpl implements PersonneService {

    private final PersonneRepository personneRepository;
    private final CompetencesService competencesService;
    private final ObjectMapper objectMapper;



    public PersonneServiceImpl(PersonneRepository personneRepository, CompetencesServiceImpl competencesService, ObjectMapper objectMapper) {
        this.personneRepository = personneRepository;
        this.competencesService = competencesService;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<PersonnesMinimalDTO> findAll() {
        List<Personne> listPersonnes = personneRepository.findAll(PageRequest.of(0,10)).toList();



//        List<PersonnesMinimalDTO> ListePersonneMinimal = List.of();
//        for (Personne personne: listPersonnes) {
//            ListePersonneMinimal.add(this.objectMapper.convertValue(personne, PersonnesMinimalDTO.class));
//        }
        return objectMapper.convertValue(listPersonnes, new TypeReference<List<PersonnesMinimalDTO>>(){}
        );
    }

    @Override
    public Personne save(Personne entity) {
        return personneRepository.save(entity);
    }

    @Override
    public Personne findById(String id) {
        return personneRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteById(String id) {
        personneRepository.deleteById(id);
    }

    @Override
    public Personne ajoutCompetence(String idPersonne, String idCompetence, Integer niveau) {
        Personne personne = filterListeNiveauCompetence(idPersonne, idCompetence);

        personne.getCompetences().add(new NiveauCompetences(new Competences(idCompetence), niveau));
        return this.save(personne);
    }

    @Override
    public Personne supprimerNiveauCompetence(String idPersonne, String idCompetence) {
        Personne personne = filterListeNiveauCompetence(idPersonne, idCompetence);
        return this.save(personne);
    }

    @Override
    public List<Personne> rechercherPersonnesParCompetenceSupA(String idCompetence, int niveau) {
        List<Personne> personnes = this.personneRepository.findAllByCompetencesCompetenceId((idCompetence));

        return personnes.stream().filter(personne -> {
            return personne.getCompetences().stream().anyMatch(niveauCompetences -> {
                return niveauCompetences.getCompetence().getId().equals(idCompetence)
                        && niveauCompetences.getNiveau() >= niveau;
            });
        }).toList();
    }

    private Personne filterListeNiveauCompetence(String idPersonne, String idCompetence) {
        Personne personne = this.findById(idPersonne);
        Competences competences = this.competencesService.findById(idCompetence);
        List<NiveauCompetences> niveauCompetences = personne.getCompetences();

        niveauCompetences.removeIf(niveauCompetence -> niveauCompetence.getCompetence().equals(competences));
        return personne;
    }


}


