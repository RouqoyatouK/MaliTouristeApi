package com.tourist.malitourist.Controller;


import com.tourist.malitourist.Model.Nomregion;
import com.tourist.malitourist.Model.Pays;
import com.tourist.malitourist.Repo.NomregionRepo;
import com.tourist.malitourist.Repo.PaysRepo;
import com.tourist.malitourist.Service.NomregionSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nomregion")
public class NomregionCtrl {

    @Autowired
    NomregionSvc nomregionSvc;

    @Autowired
    PaysRepo paysRepo;
    NomregionRepo nomregionRepo;

    @PostMapping("/add")
    public Nomregion Create(@RequestBody Nomregion nomregion){

        Pays pays = paysRepo.findByNompays(nomregion.getPays().getNompays());
        return nomregionSvc.Creer(nomregion);
    }


    /*
    @GetMapping("/read")
    public List<Nomregion> Afficherr(){
        return nomregionRepo.AfficherListe();
    }

     */

    @PutMapping("/update/{idnomregion}")
    public Nomregion Updatee( @RequestBody Nomregion nomregion, @PathVariable Long idnomregion){
        return nomregionSvc.Modifier(nomregion, idnomregion);
    }

    @DeleteMapping("/delete/{idnomregion}")
    public String Supprimerr(@PathVariable Long idnomregion){
        return nomregionSvc.Supprimer(idnomregion);
    }

}
