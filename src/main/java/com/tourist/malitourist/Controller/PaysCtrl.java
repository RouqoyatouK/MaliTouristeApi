package com.tourist.malitourist.Controller;


import com.tourist.malitourist.Model.Pays;
import com.tourist.malitourist.Service.PaysSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pays")
public class PaysCtrl {
    @Autowired
    PaysSvc paysSvc;

    @PostMapping("/add")
    public Pays Create(@RequestBody Pays pays){
        return paysSvc.Creer(pays);
    }

    @GetMapping("/read")
    public List<Pays> Afficherr(){
        return paysSvc.Afficher();
    }

    @PutMapping("/update/{idpays}")
    public Pays Updatee( @RequestBody Pays pays, @PathVariable Long idpays){
        return paysSvc.Modifier(pays, idpays);
    }


    @DeleteMapping("/delete/{idpays}")
    public String Supprimerr(@PathVariable Long idpays){
        return paysSvc.Supprimer(idpays);
    }

}
