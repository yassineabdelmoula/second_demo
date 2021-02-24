package oga.demo.controllers;


import oga.demo.entities.categorie;
import oga.demo.entities.produit;
import oga.demo.services.categorieservice;
import oga.demo.services.produitservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/produit")
public class produitcontroller {
    @Autowired
    private produitservice service;
    public produitcontroller(produitservice service){this.service=service;}
    @GetMapping("/all")
    public List<produit> get()
    {
        return service.getall();
    }
    @GetMapping("/byid/{num}")
    public List<produit> getbynum(@PathVariable(value="num") int num)
    {
        return service.getbynum(num);
    }
    @PostMapping("/add")
    public ResponseEntity<produit> add(@RequestBody produit t1)
    {
        return service.add(t1);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<produit> update(@PathVariable(value = "id") Long id, @RequestBody produit t1)
    {
        return service.update(id,t1);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<produit> delete(@PathVariable(value = "id") Long id)
    {
        return service.delete(id);
    }
}
