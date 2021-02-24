package oga.demo.controllers;


import oga.demo.entities.categorie;
import oga.demo.services.categorieservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/categorie")
public class categoriecontroller {
    @Autowired
    private categorieservice service;
    public categoriecontroller(categorieservice service){this.service=service;}
    @GetMapping("/all")
    public List<categorie> get()
    {
        return service.getall();
    }
    @GetMapping("/allnum")
    public List<Integer> getnum()
    {
        return service.getallnum();
    }

    @PostMapping("/add")
    public ResponseEntity<categorie> add(@RequestBody categorie t1)
    {
        return service.add(t1);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<categorie> update(@PathVariable(value = "id") Long id,@RequestBody categorie t1)
    {
        return service.update(id,t1);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<categorie> delete(@PathVariable(value = "id") Long id)
    {
        return service.delete(id);
    }
}
