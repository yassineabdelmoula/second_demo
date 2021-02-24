package oga.demo.repositories;

import oga.demo.entities.categorie;
import oga.demo.entities.produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface categorierepo extends JpaRepository<categorie,Long> {
    @Query("SELECT num from categorie ")
    List<Integer> findAllnum();
}
