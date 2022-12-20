package com.tourist.malitourist.Controller;


import com.tourist.malitourist.Model.Pays;
import com.tourist.malitourist.Service.PaysSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8100", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/pays")
public class PaysCtrl {
    @Autowired
    PaysSvc paysSvc;

    @PostMapping("/add")
    //@PreAuthorize("hasRole('ADMIN') ")
    public Pays Create(@RequestBody Pays pays){
        return paysSvc.Creer(pays);
    }

    @GetMapping("/read")
   // @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Pays> Afficherr(){
        return paysSvc.Afficher();
    }

    @PutMapping("/update/{idpays}")
    @PreAuthorize("hasRole('ADMIN') ")

    public Pays Updatee( @RequestBody Pays pays, @PathVariable Long idpays){
        return paysSvc.Modifier(pays, idpays);
    }


    @DeleteMapping("/delete/{idpays}")
    @PreAuthorize("hasRole('ADMIN')")
    public String Supprimerr(@PathVariable Long idpays){
        return paysSvc.Supprimer(idpays);
    }

}
