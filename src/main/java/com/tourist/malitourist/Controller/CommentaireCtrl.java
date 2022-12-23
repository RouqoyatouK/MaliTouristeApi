package com.tourist.malitourist.Controller;


import com.tourist.malitourist.Model.Commentaire;
import com.tourist.malitourist.Model.Nomregion;
import com.tourist.malitourist.Model.Region;
import com.tourist.malitourist.Repo.NomregionRepo;
import com.tourist.malitourist.Repo.RegionRepo;
import com.tourist.malitourist.Service.CommentaireSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8101", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/commentaire/")
public class CommentaireCtrl {

    @Autowired
    CommentaireSvc commentaireSvc;
    RegionRepo regionRepo;
    @Autowired
    NomregionRepo nomregionRepo;

    @PostMapping("/add/{idnomregion}")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Commentaire Create(@RequestBody Commentaire commentaire, @PathVariable String idnomregion){
       // Optional<Region> region = regionRepo.findById(commentaire.getRegions().getIdnomregion());

        Nomregion ng = nomregionRepo.findByIdnomregion(Long.valueOf(idnomregion));
        commentaire.setRegions(ng);
        commentaire.setDatecmt(new Date());
        return commentaireSvc.Creer(commentaire);
    }

    @GetMapping("/read")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Commentaire> Afficherr(){
        return commentaireSvc.Afficher();
    }

    @PutMapping("/update/{idcmt}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Commentaire Updatee(@RequestBody Commentaire commentaire, @PathVariable Long idcmt){
        return commentaireSvc.Modifier(commentaire, idcmt);
    }


    @DeleteMapping("/delete/{idcmt}")
    public String Supprimerr(@PathVariable Long idcmt){
        return commentaireSvc.Supprimer(idcmt);
    }
}
