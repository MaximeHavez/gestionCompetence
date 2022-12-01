package fr.maxime.spring.competence.mycomp.equipes;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EquipeRepository extends MongoRepository<Equipe, String> {
}
