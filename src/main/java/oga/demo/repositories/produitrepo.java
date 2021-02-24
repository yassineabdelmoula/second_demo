package oga.demo.repositories;

import oga.demo.entities.produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.concurrent.Future;

public interface produitrepo extends JpaRepository<produit,Long> {
    @Query("SELECT num_categorie from produit p where p.num_categorie = num")
    List<produit> findBynum(@Param("num") int num);
}

