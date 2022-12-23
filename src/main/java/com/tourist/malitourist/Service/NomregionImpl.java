package com.tourist.malitourist.Service;


import com.tourist.malitourist.Model.Nomregion;
import com.tourist.malitourist.Model.Region;
import com.tourist.malitourist.Repo.NomregionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class NomregionImpl implements NomregionSvc {

    @Autowired
    NomregionRepo nomregionRepo;

    @Override
    public Nomregion Creer(Nomregion nomregion) {
        return nomregionRepo.save(nomregion);
    }

    @Override
    public List<Nomregion> Afficher() {
        List<Nomregion> r = nomregionRepo.findAll();
        System.err.println("---------------------------------------"+ r +"--------------------------------------");
/*
        for (Nomregion a: r){
            System.err.println("---------------------------------------"+ r +"--------------------------------------");
        }

 */
        return r;
    }


    @Override
    public Nomregion Modifier(Nomregion nomregion, Long idnomregion) {
        return nomregionRepo.findById(idnomregion).map(nr->{
            nr.setNom(nomregion.getNom());
            nr.setActivite(nomregion.getActivite());
            nr.setCoderegion(nomregion.getCoderegion());
            nr.setSuperfie(nomregion.getSuperfie());
            nr.setImgregion(nomregion.getImgregion());
            //nr.setPays(nomregion.getPays());
           // nr.setImgregion(nomregion.getImgregion());
            return nomregionRepo.save(nr);
        }).orElseThrow(()->new RuntimeException("nomregion trouver"));
    }

    @Override
    public String Supprimer(Long idnomregion) {
        this.nomregionRepo.deleteById(idnomregion);
        return "ok!";
    }

    @Override
    public Nomregion AfficherUneRegion(Long idnomregion) {
        return nomregionRepo.findById(idnomregion).get();
    }
}
