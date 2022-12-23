package com.tourist.malitourist;

import com.tourist.malitourist.Controller.AuthController;
import com.tourist.malitourist.Model.ERole;
import com.tourist.malitourist.Model.Role;
import com.tourist.malitourist.Model.Users;
import com.tourist.malitourist.Repo.RoleRepo;
import com.tourist.malitourist.Repo.UsersRepo;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

//@AllArgsConstructor
@SpringBootApplication
public class MalitouristApplication {//implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(AuthController.class);

	/*final private UsersRepo usersRepo ;
	final private RoleRepo roleRepo  ;

	@Autowired
	PasswordEncoder encoder;*/


	public static void main(String[] args) {
		SpringApplication.run(MalitouristApplication.class, args);
	}


	/*@Override
	public void run(String... args) throws Exception {
		if(roleRepo.findAll().size() == 0){
			roleRepo.save(new Role(ERole.ROLE_ADMIN));
			roleRepo.save(new Role(ERole.ROLE_USER));
		}
		if (roleRepo.findAll().size() == 0){
			Set<Role> roles = new HashSet<>();
			Role adminRole = roleRepo.findByName(ERole.ROLE_ADMIN);
			roles.add(adminRole);
			Users users = new Users("admin",
					"admin@gmail.com",
					encoder.encode("admin@pass"));
			users.setRoles(roles);
			usersRepo.save(users);
		}
	}*/

}
