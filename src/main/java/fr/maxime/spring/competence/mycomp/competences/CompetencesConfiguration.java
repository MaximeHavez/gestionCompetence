package fr.maxime.spring.competence.mycomp.competences;

import fr.maxime.spring.competence.mycomp.equipes.EquipeRepository;
import fr.maxime.spring.competence.mycomp.equipes.EquipeService;
import fr.maxime.spring.competence.mycomp.equipes.EquipeServiceImpl;
import org.springframework.context.annotation.Bean;

public class CompetencesConfiguration {

    @Bean
    public CompetencesService CompetencesService(CompetencesRepository CompetencesRepository){
        return new CompetencesServiceImpl(CompetencesRepository);
    }

}
