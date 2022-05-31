package com.estudandocomquestoes.controller;

import com.estudandocomquestoes.model.Math;
import com.estudandocomquestoes.repository.MathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matematica")
public class MathController {

    @Autowired
    private MathRepository mathRepository;

    @GetMapping
    public List<Math> listAllQuestions(){
        return mathRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Math> listById(@PathVariable String id){
        return mathRepository.findById(id);
    }

    @GetMapping("/filter")
    public List<Math> listBySubject(@RequestParam("subject") String subject){
        List<Math> collect = new ArrayList<>(this.mathRepository.findBySubject(subject));
        return collect;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Math addQuestion(@RequestBody Math math){
        return mathRepository.save(math);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Math> update(@PathVariable String id, @RequestBody Math math){

        if(!mathRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        math.setId(id);
        math = mathRepository.save(math);
        return ResponseEntity.ok(math);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){

        if(!mathRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        mathRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
