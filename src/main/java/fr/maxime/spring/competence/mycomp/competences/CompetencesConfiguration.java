package fr.maxime.spring.competence.mycomp.competences;

import org.springframework.context.annotation.Bean;

public class CompetencesConfiguration {

    @Bean
    public CompetencesService CompetencesService(CompetencesRepository CompetencesRepository){
        return new CompetencesServiceImpl(CompetencesRepository);
    }

}
