package com.tourist.malitourist.Controller;


import com.tourist.malitourist.Model.Nomregion;
import com.tourist.malitourist.Model.Pays;
import com.tourist.malitourist.Repo.NomregionRepo;
import com.tourist.malitourist.Repo.PaysRepo;
import com.tourist.malitourist.Service.NomregionSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8100", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/nomregion")
public class NomregionCtrl {

    @Autowired
    private  NomregionSvc nomregionSvc;

    @Autowired
    PaysRepo paysRepo;


    @PostMapping("/add/{nomPays}")
    //@PreAuthorize("hasRole('ADMIN')")
    public Nomregion Create(@RequestBody Nomregion nomregion, @PathVariable("nomPays") String nomPays){
        Pays pys = paysRepo.findByNompays(nomPays);
        //Pays pays = paysRepo.findByNompays(nomregion.getPays().getNompays());
        nomregion.setPays(pys);
        return nomregionSvc.Creer(nomregion);
    }



    @GetMapping("/read")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Nomregion> Afficher(){
        return nomregionSvc.Afficher();
    }



    @PutMapping("/update/{idnomregion}")
    @PreAuthorize("hasRole('ADMIN')")
    public Nomregion Updatee( @RequestBody Nomregion nomregion, @PathVariable Long idnomregion){
        return nomregionSvc.Modifier(nomregion, idnomregion);
    }

    @DeleteMapping("/delete/{idnomregion}")
    @PreAuthorize("hasRole('ADMIN')")
    public String Supprimerr(@PathVariable Long idnomregion){
        return nomregionSvc.Supprimer(idnomregion);
    }

}
