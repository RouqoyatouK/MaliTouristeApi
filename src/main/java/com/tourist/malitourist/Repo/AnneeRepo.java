package com.tourist.malitourist.Repo;

import com.tourist.malitourist.Model.Annee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AnneeRepo extends JpaRepository<Annee, Long> {

    Annee findByDate(Date date);
}
