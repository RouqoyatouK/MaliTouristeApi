package com.tourist.malitourist.Service;

import com.tourist.malitourist.Model.Annee;
import com.tourist.malitourist.Model.Nomregion;

import java.util.List;

public interface NomregionSvc {
    //add

    Nomregion Creer(Nomregion nomregion);
    //read
    //List<Nomregion> Afficher();

    List<Nomregion> Afficher();


    //update
    Nomregion Modifier(Nomregion nomregion, Long idnomregion);
    //delete
    String Supprimer(Long idnomregion);
}
