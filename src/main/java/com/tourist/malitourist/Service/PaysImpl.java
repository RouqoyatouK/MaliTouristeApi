package com.tourist.malitourist.Service;

import com.tourist.malitourist.Model.Pays;
import com.tourist.malitourist.Repo.PaysRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaysImpl implements PaysSvc {
    @Autowired
    PaysRepo paysRepo;

    @Override
    public Pays Creer(Pays pays) {
        return paysRepo.save(pays);
    }

    @Override
    public List<Pays> Afficher() {
        return paysRepo.findAll();
    }

    @Override
    public Pays Modifier(Pays pays, Long idpays) {
        return paysRepo.findById(idpays).map(p -> {
            p.setNompays(pays.getNompays());
            p.setSuperficie(pays.getSuperficie());
            return paysRepo.save(p
            );
        }).orElseThrow(()->new RuntimeException("pays trouver"));
    }

    @Override
    public String Supprimer(Long idpays) {
         this.paysRepo.deleteById(idpays);
        return "ok delete";
    }
}
