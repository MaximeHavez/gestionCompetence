package fr.maxime.spring.competence.mycomp.competences;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CompetencesServiceImpl implements CompetencesService {

    private final CompetencesRepository competencesRepository;

    public CompetencesServiceImpl(CompetencesRepository competencesRepository) {
        this.competencesRepository = competencesRepository;
    }

    @Override
    public List<Competences> findAll() {
        return competencesRepository.findAll();
    }

    @Override
    public Competences save(Competences entity) {
        return competencesRepository.save(entity);
    }

    @Override
    public Competences findById(String id) {
        return competencesRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteById(String id) {
        competencesRepository.deleteById(id);
    }
}
