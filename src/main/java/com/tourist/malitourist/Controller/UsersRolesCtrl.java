package com.tourist.malitourist.Controller;

import com.tourist.malitourist.Model.Pays;
import com.tourist.malitourist.Model.Role;
import com.tourist.malitourist.Model.Users;
import com.tourist.malitourist.Service.UsersRoleSvc;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roleuser")
public class UsersRolesCtrl {
    @Autowired
    UsersRoleSvc usersRoleSvc;

    //userrrrrrrrrrrrrrrrrrrrrrrrrrrrr

    @GetMapping("/readusers")
    public List<Users> Afficherutilisateur(){
        return usersRoleSvc.AfficherUser();
    }

    @PutMapping("/update/{id}")
    public Users Updateeutilisateur(@RequestBody Users users, @PathVariable Long id){
        return usersRoleSvc.modifierUsers(id, users);
    }


    @DeleteMapping("/delete/{id}")
    public String Supprimerutilisateur(@PathVariable Long id){
        return usersRoleSvc.supprimerUsers(id);
    }



    //roleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee

    @PostMapping("/addrole")
    public Role Create(@RequestBody Role role){
        return usersRoleSvc.Ajouter(role);
    }

    @GetMapping("/readrole")
    public List<Role> Afficherr(){
        return usersRoleSvc.afficherRoles();
    }

    @PutMapping("/updaterole/{id}")
    public Role Updatee( @RequestBody Role role, @PathVariable Long id){
        return usersRoleSvc.modifierRole(role, id);
    }


    @DeleteMapping("/deleterole/{id}")
    public String Supprimerr(@PathVariable Long id){
        return usersRoleSvc.supprimerUsers(id);
    }
}
