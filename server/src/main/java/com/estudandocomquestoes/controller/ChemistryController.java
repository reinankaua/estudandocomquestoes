package com.estudandocomquestoes.controller;

import com.estudandocomquestoes.model.Chemistry;
import com.estudandocomquestoes.repository.ChemistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quimica")
public class ChemistryController {

    @Autowired
    private ChemistryRepository chemistryRepository;

    @GetMapping
    public List<Chemistry> listAllQuestions(){
        return chemistryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Chemistry> listById(@PathVariable String id){
        return chemistryRepository.findById(id);
    }

    @GetMapping("/filter")
    public List<Chemistry> listBySubject(@RequestParam("subject") String subject){
        List<Chemistry> collect = new ArrayList<>(this.chemistryRepository.findBySubject(subject));
        return collect;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Chemistry addQuestion(@RequestBody Chemistry chemistry){
        return chemistryRepository.save(chemistry);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chemistry> update(@PathVariable String id, @RequestBody Chemistry chemistry){

        if(!chemistryRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        chemistry.setId(id);
        chemistry = chemistryRepository.save(chemistry);
        return ResponseEntity.ok(chemistry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){

        if(!chemistryRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        chemistryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}