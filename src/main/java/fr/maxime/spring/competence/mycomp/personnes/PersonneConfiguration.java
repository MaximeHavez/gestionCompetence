package fr.maxime.spring.competence.mycomp.personnes;

import org.springframework.context.annotation.Bean;

public class PersonneConfiguration {

    @Bean
    public PersonneService personneService(PersonneRepository personneRepository){
        return new PersonneServiceImpl(personneRepository);
    }
}
