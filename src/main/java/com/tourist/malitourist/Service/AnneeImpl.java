package com.tourist.malitourist.Service;

import com.tourist.malitourist.Model.Annee;
import com.tourist.malitourist.Repo.AnneeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnneeImpl implements AnneeSvc{

    @Autowired
    AnneeRepo anneeRepo;

    @Override
    public Annee Creer(Annee annee) {
        return anneeRepo.save(annee);
    }

    @Override
    public List<Annee> Afficher() {
        return anneeRepo.findAll();
    }

    @Override
    public Annee Modifier(Annee annee, Long idanne) {
        return anneeRepo.findById(idanne).map(a->{
            a.setDate(annee.getDate());
            return anneeRepo.save(a);

        }).orElseThrow(()->new RuntimeException("Annee trouver"));
    }

    @Override
    public String Supprimer(Long idanne) {
         this.anneeRepo.deleteById(idanne);
        return"Supprimer avec succes";
    }
}
