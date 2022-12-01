package fr.maxime.spring.competence.mycomp.competences;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompetencesRepository extends MongoRepository<Competences, String> {
}
