package com.projetoCatalago.Filmes.controller;

import com.projetoCatalago.Filmes.entity.Filme;
import com.projetoCatalago.Filmes.entity.Genero;
import com.projetoCatalago.Filmes.repository.FilmeRepository;
import com.projetoCatalago.Filmes.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepository;

    //construtor
    public GeneroController(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    @PostMapping
    public ResponseEntity<Genero> save(@RequestBody Genero genero){
        generoRepository.save(genero);
        return new ResponseEntity<>(genero, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<Genero>> getAll(){
        List<Genero> generos = new ArrayList<>();
        generos = generoRepository.findAll();
        return new ResponseEntity<>(generos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Genero>> getById(@PathVariable Long id){
        Optional<Genero> genero;
        try{
            genero = generoRepository.findById(id);
            return new ResponseEntity<Optional<Genero>>(genero, HttpStatus.OK);
        }catch (NoSuchElementException nsee){
            return new ResponseEntity<Optional<Genero>>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Genero>> deleteById(@PathVariable Long id){
        try{
            generoRepository.deleteById(id);
            return new ResponseEntity<Optional<Genero>>(HttpStatus.OK);
        }catch (NoSuchElementException nsee){
            return new ResponseEntity<Optional<Genero>>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genero> update(@PathVariable Long id, @RequestBody Genero newGenero){
        return generoRepository.findById(id).map(genero -> {
            genero.setCategoria(newGenero.getCategoria());
            Genero genero1Updated = generoRepository.save(genero);
            return ResponseEntity.ok().body(genero1Updated);
        }).orElse(ResponseEntity.notFound().build());
    }

}
