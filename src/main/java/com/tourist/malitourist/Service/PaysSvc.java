package com.tourist.malitourist.Service;

import com.tourist.malitourist.Model.Annee;
import com.tourist.malitourist.Model.Pays;

import java.util.List;

public interface PaysSvc {

    //add
    Pays Creer(Pays pays);
    //read
    List<Pays> Afficher();

    //update
    Pays Modifier(Pays pays, Long idpays);
    //delete
    String Supprimer(Long idpays);
}
