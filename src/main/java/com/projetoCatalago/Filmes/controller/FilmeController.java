package com.projetoCatalago.Filmes.controller;


import com.projetoCatalago.Filmes.entity.Filme;
import com.projetoCatalago.Filmes.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @Autowired
    private FilmeRepository filmeRepository;

    //construtor
    public FilmeController(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

   @PostMapping
   public ResponseEntity<Filme> save(@RequestBody Filme filme){
         filmeRepository.save(filme);
         return new ResponseEntity<>(filme, HttpStatus.OK);
   }


    @GetMapping
    public ResponseEntity<List<Filme>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(filmeRepository.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {
        Optional<Filme> filmeOptional = filmeRepository.findById(id);
        if (!filmeOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(filmeOptional.get());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Filme>> deleteById(@PathVariable Long id){
        try{
            filmeRepository.deleteById(id);
            return new ResponseEntity<Optional<Filme>>(HttpStatus.OK);
        }catch (NoSuchElementException nsee){
            return new ResponseEntity<Optional<Filme>>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> update(@PathVariable Long id, @RequestBody Filme newFilme){
        return filmeRepository.findById(id).map(filme -> {
            filme.setNomefilme(newFilme.getNomefilme());
            filme.setAno(newFilme.getAno());
            Filme filme1Updated = filmeRepository.save(filme);
            return ResponseEntity.ok().body(filme1Updated);
        }).orElse(ResponseEntity.notFound().build());
    }

}
