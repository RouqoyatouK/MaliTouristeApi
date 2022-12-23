package com.tourist.malitourist.Controller;

import com.tourist.malitourist.Model.Annee;
import com.tourist.malitourist.Model.Nomregion;
import com.tourist.malitourist.Model.Region;
import com.tourist.malitourist.Repo.AnneeRepo;
import com.tourist.malitourist.Repo.NomregionRepo;
import com.tourist.malitourist.Service.RegionSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8101", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/region")
public class RegionCtrl {
    @Autowired
    RegionSvc regionSvc;
    @Autowired
    AnneeRepo anneeRepo;
    @Autowired
    NomregionRepo nomregionRepo;


    @PostMapping("/add/{nom}")
    //@PreAuthorize("hasRole('ADMIN') ")
    public Region Create(@RequestBody Region region, @PathVariable String nom ){

        Nomregion nomregion = nomregionRepo.findByNom(nom);
        //Nomregion nomregion = nomregionRepo.findByNom(region.getNomregions().getNom());
        //System.out.println(region.getAnnees());
       // Nomregion ng=nomregionRepo.findByNom(region.getNomregions().getNom());
        //Annee annee=anneeRepo.findByDate(region.getAnnees().getDate());
        region.setAnnee(new Date());
        region.setNomregions(nomregion);
        return regionSvc.Creer(region);
    }


    @GetMapping("/read")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Region> Afficherr(){

        return regionSvc.Afficher();
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN') ")
    public Region Updatee( @RequestBody Region region, @PathVariable Long id){
        return regionSvc.Modifier(region, id);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN') ")
    public String Supprimerr(@PathVariable Long id){
        return regionSvc.Supprimer(id);
    }


}
