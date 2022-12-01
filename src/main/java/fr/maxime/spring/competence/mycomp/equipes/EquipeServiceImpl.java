package fr.maxime.spring.competence.mycomp.equipes;

import fr.maxime.spring.competence.mycomp.personnes.Personne;
import fr.maxime.spring.competence.mycomp.personnes.PersonneService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EquipeServiceImpl implements EquipeService {

    private final EquipeRepository equipeRepository;
    private final PersonneService personneService;

    public EquipeServiceImpl(EquipeRepository equipeRepository, PersonneService personneService) {
        this.equipeRepository = equipeRepository;
        this.personneService = personneService;
    }

    @Override
    public List<Equipe> findAll() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe save(Equipe entity) {
        for (Personne membre : entity.getMembres()) {
            if (membre.getId() == null) {
                this.personneService.save(membre);
            }
        }
        return equipeRepository.save(entity);
    }

    @Override
    public Equipe findById(String id) {
        return equipeRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteById(String id) {
        equipeRepository.deleteById(id);
    }

    /**
     * Ajoute un membre {idMembre} à l'équipe {idEquipe}
     *
     * @param idEquipe id de l'équipe
     * @param idMembre id de la personne qui devient membre
     * @return l'équipe avec les membres
     */
    @Override
    public Equipe ajoutMembre(String idEquipe, String idMembre) {
        Equipe equipe = this.findById(idEquipe);
        Personne membre = this.personneService.findById(idMembre);
        if (equipe.getMembres().stream().noneMatch(equipeMembre -> equipeMembre.getId().equals(idMembre))){
            equipe.getMembres().add(membre);
        }
        return this.save(equipe);
    }

    @Override
    public Equipe suppressionMembre(String idEquipe, String idMembre) {
        Equipe equipe = this.findById(idEquipe);
        equipe.getMembres().removeIf(membre -> membre.getId().equals(idMembre));
        return this.save(equipe);
    }


}
