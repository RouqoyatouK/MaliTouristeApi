package com.tourist.malitourist.Service;

import com.tourist.malitourist.Model.Pays;
import com.tourist.malitourist.Model.Region;

import java.util.List;

public interface RegionSvc {


    //add
    Region Creer(Region region);
    //read
    List<Region> Afficher();

    //update
    Region Modifier(Region region, Long id);
    //delete
    String Supprimer(Long id);

}
