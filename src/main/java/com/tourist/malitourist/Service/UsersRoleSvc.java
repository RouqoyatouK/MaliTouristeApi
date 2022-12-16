package com.tourist.malitourist.Service;

import com.tourist.malitourist.Model.Role;
import com.tourist.malitourist.Model.Users;

import java.util.List;

public interface UsersRoleSvc {

    List<Users> AfficherUser();
    Users modifierUsers(Long id, Users users);
    String supprimerUsers(Long id);


    Role Ajouter (Role role);
    List<Role> afficherRoles();
    Role modifierRole(Role role, Long id);
    String SupprimerRole(Long id);

}
