package com.tourist.malitourist.Controller;


import com.tourist.malitourist.Model.Commentaire;
import com.tourist.malitourist.Model.Region;
import com.tourist.malitourist.Repo.RegionRepo;
import com.tourist.malitourist.Service.CommentaireSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/commentaire")
public class CommentaireCtrl {

    @Autowired
    CommentaireSvc commentaireSvc;
    RegionRepo regionRepo;

    @PostMapping("/add")
    public Commentaire Create(@RequestBody Commentaire commentaire){
        Optional<Region> region = regionRepo.findById(commentaire.getRegions().getId());
        return commentaireSvc.Creer(commentaire);
    }

    /*@GetMapping("/read")
    public List<Pays> Afficherr(){
        return paysSvc.Afficher();
    }*/

    @PutMapping("/update/{idcmt}")
    public Commentaire Updatee(@RequestBody Commentaire commentaire, @PathVariable Long idcmt){
        return commentaireSvc.Modifier(commentaire, idcmt);
    }


    @DeleteMapping("/delete/{idcmt}")
    public String Supprimerr(@PathVariable Long idcmt){
        return commentaireSvc.Supprimer(idcmt);
    }
}
