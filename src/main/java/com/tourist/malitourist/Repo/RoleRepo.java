package com.tourist.malitourist.Repo;

import com.tourist.malitourist.Model.ERole;
import com.tourist.malitourist.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(ERole name);
}
