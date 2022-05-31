package com.estudandocomquestoes.repository;

import com.estudandocomquestoes.model.Geography;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GeographyRepository extends MongoRepository<Geography, String> {

    List<Geography> findBySubject(String subject);

    Optional<Geography> findById(String id);
}
