package com.estudandocomquestoes.repository;

import com.estudandocomquestoes.model.Math;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MathRepository extends MongoRepository<Math, String> {

    List<Math> findBySubject(String subject);

    Optional<Math> findById(String id);
}
