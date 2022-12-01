package fr.maxime.spring.competence.mycomp.equipes;

import org.springframework.context.annotation.Bean;

public class EquipeConfiguration {

    @Bean
    public EquipeService equipeService(EquipeRepository equipeRepository){
        return new EquipeServiceImpl(equipeRepository);
    }
}
