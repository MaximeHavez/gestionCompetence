package fr.maxime.spring.competence.mycomp.equipes;

import fr.maxime.spring.competence.mycomp.personnes.PersonneRepository;
import fr.maxime.spring.competence.mycomp.personnes.PersonneService;
import org.springframework.context.annotation.Bean;

public class EquipeConfiguration {

    @Bean
    public EquipeService equipeService(EquipeRepository equipeRepository, PersonneService personneService){
        return new EquipeServiceImpl(equipeRepository, personneService);
    }
}
