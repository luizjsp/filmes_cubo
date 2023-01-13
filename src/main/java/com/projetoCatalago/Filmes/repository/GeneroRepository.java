package com.projetoCatalago.Filmes.repository;


import com.projetoCatalago.Filmes.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {


}
