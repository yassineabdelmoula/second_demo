package oga.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class categorie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long num;

    @NonNull
    private String nom;


    private int nombre_produit;




}
