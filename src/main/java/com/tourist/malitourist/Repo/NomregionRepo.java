package com.tourist.malitourist.Repo;

import com.tourist.malitourist.Model.Nomregion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NomregionRepo extends JpaRepository<Nomregion, Long> {

    /*
    @Query(value = "select * from nomregion", nativeQuery = true)
    public List<Nomregion> AfficherListe();

     */

    Nomregion findByNom(String nom);
}
