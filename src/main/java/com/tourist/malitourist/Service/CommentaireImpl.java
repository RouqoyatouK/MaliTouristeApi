package com.tourist.malitourist.Service;


import com.tourist.malitourist.Model.Commentaire;
import com.tourist.malitourist.Repo.CommentaireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaireImpl implements CommentaireSvc {
    @Autowired
    CommentaireRepo commentaireRepo;

    @Override
    public Commentaire Creer(Commentaire commentaire) {
        return commentaireRepo.save(commentaire);
    }

    @Override
    public List<Commentaire> Afficher() {
        return commentaireRepo.findAll();
    }


    @Override
    public Commentaire Modifier(Commentaire commentaire, Long idcmt) {
        return commentaireRepo.findById(idcmt).map(c->{
            c.setDatecmt(commentaire.getDatecmt());
            c.setMessage(commentaire.getMessage());
            c.setRegions(commentaire.getRegions());
            return commentaireRepo.save(c);
        }).orElseThrow(()->new RuntimeException("commentaire trouver"));
    }

    @Override
    public String Supprimer(Long idcmt) {
         this.commentaireRepo.deleteById(idcmt);
        return"ok";
    }
}
