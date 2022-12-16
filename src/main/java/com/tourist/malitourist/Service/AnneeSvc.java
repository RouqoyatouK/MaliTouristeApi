package com.tourist.malitourist.Service;

import com.tourist.malitourist.Model.Annee;

import java.util.List;

public interface AnneeSvc {

    //add

    Annee Creer(Annee annee);
    //read
    List<Annee> Afficher();

    //update
    Annee Modifier(Annee annee, Long idanne);
    //delete
    String Supprimer(Long idanne);

}
