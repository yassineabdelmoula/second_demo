package oga.demo.services;


import oga.demo.entities.categorie;
import oga.demo.repositories.categorierepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;

@Service
public class  categorieservice {
    @Autowired
    public categorierepo rep;

    public categorieservice(categorierepo rep){this.rep=rep;}

    public ResponseEntity<categorie> add(categorie t1)
    {
        try {
            categorie ss = rep.save(t1);
            return new ResponseEntity<categorie>(ss, HttpStatus.CREATED);
        }
        catch (Exception  e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<categorie> delete(Long id)
    {
        try {
            Optional<categorie> ss = rep.findById(id);
            if (ss.isEmpty())//id erroné
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            rep.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    public ResponseEntity<categorie> update(Long id, categorie newact)
    {
        try {
            Optional<categorie> ss = rep.findById(id);
            if (ss.isEmpty())
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            categorie t1 = ss.get();
            t1.setNom(newact.getNom());
            t1.setNombre_produit(newact.getNombre_produit());
            categorie res = rep.save(t1);
            return new ResponseEntity<categorie>(res, HttpStatus.CREATED);
        }catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public List<categorie> getall() {

        return rep.findAll();
    }
    public List<Integer> getallnum() {
        return rep.findAllnum();
    }
}


