package com.tourist.malitourist.Model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Nomregion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idnomregion;
    private String nom;
    private String superfie;
    private String coderegion;
    private String activite;
    //private  String imgregion;


    @ManyToOne( optional = false)
    @JoinColumn(name = "pays", nullable = false)
   @OnDelete(action = OnDeleteAction.CASCADE)
    private Pays pays;


}