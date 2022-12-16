package com.tourist.malitourist.Repo;

import com.tourist.malitourist.Model.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaysRepo extends JpaRepository<Pays, Long> {

    Pays findByNompays(String nompays);
}
