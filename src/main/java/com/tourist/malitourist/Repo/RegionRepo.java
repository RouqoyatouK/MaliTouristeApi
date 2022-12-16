package com.tourist.malitourist.Repo;

import com.tourist.malitourist.Model.Region;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RegionRepo extends  JpaRepository<Region, Long>{

    //Region findById(Long id);
}
