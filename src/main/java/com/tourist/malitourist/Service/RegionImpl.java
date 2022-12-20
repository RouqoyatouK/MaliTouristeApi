package com.tourist.malitourist.Service;

import com.tourist.malitourist.Model.Region;
import com.tourist.malitourist.Repo.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionImpl implements RegionSvc {

    @Autowired
    RegionRepo regionRepo;

    @Override
    public Region Creer(Region region) {
        return regionRepo.save(region);
    }

    @Override
    public List<Region> Afficher() {
        return regionRepo.findAll();
    }

    @Override
    public Region Modifier(Region region, Long id) {
        return regionRepo.findById(id).map(r->{
            r.setHabitants(region.getHabitants());
            r.setAnnee(region.getAnnee());
            r.setNomregions(region.getNomregions());
            return regionRepo.save(r);
        }).orElseThrow(()->new RuntimeException("region trouver"));
    }

    @Override
    public String Supprimer(Long id) {
         this.regionRepo.deleteById(id);
        return"suppression ok";
    }
}
