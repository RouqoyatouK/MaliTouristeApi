package com.tourist.malitourist.Controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.tourist.malitourist.Model.Nomregion;
import com.tourist.malitourist.Model.Pays;
import com.tourist.malitourist.Repo.NomregionRepo;
import com.tourist.malitourist.Repo.PaysRepo;
import com.tourist.malitourist.Service.NomregionSvc;
import com.tourist.malitourist.security.ResponseMessage;
import com.tourist.malitourist.security.SaveImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8101", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/nomregion")
public class NomregionCtrl {

    @Autowired
    private NomregionSvc nomregionSvc;

    @Autowired
    PaysRepo paysRepo;
    @Autowired
    NomregionRepo nomregionRepo;




   /* @PostMapping("/add/{nomPays}")
    //@PreAuthorize("hasRole('ADMIN')")
    public Nomregion Create(@RequestBody Nomregion nomregion, @PathVariable("nomPays") String nomPays){
        Pays pys = paysRepo.findByNompays(nomPays);
        //Pays pays = paysRepo.findByNompays(nomregion.getPays().getNompays());
        nomregion.setPays(pys);
        return nomregionSvc.Creer(nomregion);
    }*/

    @PostMapping("/add/{nomPays}")
    public ResponseEntity<Object> Create(@RequestParam(value = "nomregion") String nomregion,
                                         @PathVariable("nomPays") String nomPays,
                                         @Param(value = "file") MultipartFile file) throws JsonProcessingException {

        Pays pys = paysRepo.findByNompays(nomPays);
        Nomregion nomrg = new JsonMapper().readValue(nomregion, Nomregion.class);

        Nomregion find = nomregionRepo.findByNom(nomrg.getNom());
        if (find == null) {
            if (file != null) {
                nomrg.setImgregion(SaveImage.save("nomregion", file, nomrg.getNom()));
                nomrg.setPays(pys);
                nomregionSvc.Creer(nomrg);
                System.out.println("hhhhhhhhh" + nomrg.getNom());
                return ResponseMessage.generateResponse("ok", HttpStatus.OK, " Nomregion enregistré !");
            } else {
                return ResponseMessage.generateResponse("error", HttpStatus.BAD_REQUEST, "Fichier vide");
            }
        } else {
            return ResponseMessage.generateResponse("error", HttpStatus.BAD_GATEWAY, "Une region existe déja avec le même nom !");

        }

    }


    @GetMapping("/read")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Nomregion> Afficher() {
        return nomregionSvc.Afficher();
    }


    @PutMapping("/update/{idnomregion}")
    @PreAuthorize("hasRole('ADMIN')")
    public Nomregion Updatee(@RequestBody Nomregion nomregion, @PathVariable Long idnomregion) {
        return nomregionSvc.Modifier(nomregion, idnomregion);
    }

    @DeleteMapping("/delete/{idnomregion}")
    @PreAuthorize("hasRole('ADMIN')")
    public String Supprimerr(@PathVariable Long idnomregion) {
        return nomregionSvc.Supprimer(idnomregion);
    }


    //Afficher un seul nom region

    @GetMapping("/read/{idnomregion}")
    public Nomregion Affichagedunelisteavecid(@PathVariable Long idnomregion) {
        return nomregionSvc.AfficherUneRegion(idnomregion);

    }
}
