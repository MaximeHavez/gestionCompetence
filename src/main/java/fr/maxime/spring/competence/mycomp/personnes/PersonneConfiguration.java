package fr.maxime.spring.competence.mycomp.personnes;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.maxime.spring.competence.mycomp.competences.CompetencesRepository;
import fr.maxime.spring.competence.mycomp.competences.CompetencesServiceImpl;
import org.springframework.context.annotation.Bean;

public class PersonneConfiguration {

    @Bean
    public PersonneService personneService(PersonneRepository personneRepository, CompetencesServiceImpl competencesService, ObjectMapper objectMapper){
        return new PersonneServiceImpl(personneRepository, competencesService, objectMapper);
    }
}
