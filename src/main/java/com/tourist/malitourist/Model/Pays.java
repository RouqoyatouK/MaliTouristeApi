package com.tourist.malitourist.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pays {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpays;
    private String nompays;
    private String superficie;


}
