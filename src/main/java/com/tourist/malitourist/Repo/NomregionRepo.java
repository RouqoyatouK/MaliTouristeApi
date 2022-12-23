package com.tourist.malitourist.Repo;

import com.tourist.malitourist.Model.Nomregion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NomregionRepo extends JpaRepository<Nomregion, Long> {

    /*
    @Query(value = "select * from nomregion", nativeQuery = true)
    public List<Nomregion> AfficherListe();

     */

   /* @Query(value = "select * from nomregion where idnomregion=:idnomregion ", nativeQuery = true)
    public  List<Nomregion> AfficherUneRegion(Long idnomregion);*/

    Nomregion findByNom(String nom);

    Nomregion findByIdnomregion(Long idnomregion);
    //Optional<Nomregion> findById(L)
}
