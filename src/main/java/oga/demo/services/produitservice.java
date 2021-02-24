package oga.demo.services;

import oga.demo.entities.categorie;
import oga.demo.entities.produit;
import oga.demo.repositories.categorierepo;
import oga.demo.repositories.produitrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class produitservice {

    @Autowired
    public produitrepo rep;

    public produitservice(produitrepo rep){this.rep=rep;}

    public ResponseEntity<produit> add(produit t1)
    {
        try {
            produit ss = rep.save(t1);
            return new ResponseEntity<produit>(ss, HttpStatus.CREATED);
        }
        catch (Exception  e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<produit> delete(Long id)
    {
        try {
            Optional<produit> ss = rep.findById(id);
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
    public ResponseEntity<produit> update(Long id, produit newact)
    {
        try {
            Optional<produit> ss = rep.findById(id);
            if (ss.isEmpty())
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            produit t1 = ss.get();
            t1.setNom(newact.getNom());
            t1.setNum_categorie(newact.getNum_categorie());
            t1.setPrix(newact.getPrix());
            t1.setPhoto(newact.getPhoto());
            t1.setDate_dernier_update(newact.getDate_dernier_update());
            produit res = rep.save(t1);
            return new ResponseEntity<produit>(res, HttpStatus.CREATED);
        }catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public List<produit> getall() {

        return rep.findAll();
    }
    public List<produit> getbynum(int num) {

        return rep.findBynum(num);
    }
}
