package com.tourist.malitourist.Repo;


import com.tourist.malitourist.Model.Commentaire;
import com.tourist.malitourist.Model.Nomregion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentaireRepo extends JpaRepository<Commentaire, Long> {
    /*//Requete permettant d'afficher la liste de commentaire datecmt message region
    @Query(value = "select commentaire.datecmt, commentaire.message, region.nom  from commentaire, region " +
            "where solution.probleme = probleme.id_probleme and probleme.user = user.id_user", nativeQuery = true)
    Iterable<Object[]> listeSolution();*/


    //public Long InsertId(Long probleme);

    Optional<Commentaire> findById(Long id);


}
