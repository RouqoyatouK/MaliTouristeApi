package com.tourist.malitourist.Controller;


import com.tourist.malitourist.Model.Annee;
import com.tourist.malitourist.Service.AnneeSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annee")
public class AnneeCtrl {

    @Autowired
    AnneeSvc anneeSvc;


    @PostMapping("/add")
    public String Create(@RequestBody Annee annee){
         this.anneeSvc.Creer(annee);
        return "ok";
    }

    @GetMapping("/read")
    public List<Annee>  Read(){
        return anneeSvc.Afficher();
    }

    @PutMapping("/update/{idanne}")
    public Annee Updates(@RequestBody Annee annee, @PathVariable Long idanne){
        return anneeSvc.Modifier(annee,idanne);
    }


    @DeleteMapping("/delete/{idannee}")
    public String delete(@PathVariable Long idannee ) {
        Object ess = null;
        if (idannee.equals(ess)) return "cette annnee n'existe  pas";
        else
            return anneeSvc.Supprimer(idannee);
    }
}