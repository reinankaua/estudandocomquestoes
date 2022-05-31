package com.estudandocomquestoes.repository;

import com.estudandocomquestoes.model.Chemistry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChemistryRepository extends MongoRepository<Chemistry, String> {
    List<Chemistry> findBySubject(String subject);

    Optional<Chemistry> findById(String id);
}
