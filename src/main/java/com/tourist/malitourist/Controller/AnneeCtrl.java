package com.tourist.malitourist.Controller;


import com.tourist.malitourist.Model.Annee;
import com.tourist.malitourist.Service.AnneeSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8100", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/annee")
public class AnneeCtrl {

    @Autowired
    AnneeSvc anneeSvc;


    @PostMapping("/add")
    //@PreAuthorize("hasRole('ADMIN') ")
    public String Create(@RequestBody Annee annee){
         this.anneeSvc.Creer(annee);
        return "ok";
    }

    @GetMapping("/read")
    @PreAuthorize("hasRole('ADMIN') ")
    public List<Annee>  Read(){
        return anneeSvc.Afficher();
    }

    @PutMapping("/update/{idanne}")
    @PreAuthorize("hasRole('ADMIN') ")
    public Annee Updates(@RequestBody Annee annee, @PathVariable Long idanne){
        return anneeSvc.Modifier(annee,idanne);
    }


    @DeleteMapping("/delete/{idannee}")
    @PreAuthorize("hasRole('ADMIN') ")
    public String delete(@PathVariable Long idannee ) {
        Object ess = null;
        if (idannee.equals(ess)) return "cette annnee n'existe  pas";
        else
            return anneeSvc.Supprimer(idannee);
    }
}
