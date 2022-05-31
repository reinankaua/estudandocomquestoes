package com.estudandocomquestoes.controller;

import com.estudandocomquestoes.model.Geography;
import com.estudandocomquestoes.repository.GeographyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/geografia")
public class GeographyController {

    @Autowired
    private GeographyRepository geographyRepository;

    @GetMapping
    public List<Geography> listAllQuestions(){
        return geographyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Geography> listById(@PathVariable String id){
        return geographyRepository.findById(id);
    }


     @GetMapping("/filter")
     public List<Geography> listBySubject(@RequestParam("subject") String subject){
         List<Geography> collect = new ArrayList<>(this.geographyRepository.findBySubject(subject));
         return collect;
     }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Geography addQuestion(@RequestBody Geography geography){
        return geographyRepository.save(geography);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Geography> update(@PathVariable String id, @RequestBody Geography geography){

        if(!geographyRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        geography.setId(id);
        geography = geographyRepository.save(geography);
        return ResponseEntity.ok(geography);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){

        if(!geographyRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        geographyRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
