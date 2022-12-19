package com.tourist.malitourist.Service;

import com.tourist.malitourist.Model.Annee;
import com.tourist.malitourist.Model.Commentaire;

import java.util.List;

public interface CommentaireSvc {

    //add

    Commentaire Creer(Commentaire commentaire);
    //read
   List<Commentaire> Afficher();
    //Iterable<Object[]> afficher();

    //update
    Commentaire Modifier(Commentaire commentaire, Long idcmt);
    //delete
    String Supprimer(Long idcmt);
}
