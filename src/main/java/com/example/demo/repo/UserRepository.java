package com.example.demo.repo;

import com.example.demo.entity.User; //import my entity
import org.springframework.data.jpa.repository.JpaRepository; //all CRUD methods automatically(JPA interface)
import org.springframework.stereotype.Repository; //This is an annotation(@Repository)

import java.util.Optional;

//JpaRepository is like hiring a chef (CRUD methods).
//@Repository is like putting a chef badge on them.(Hey, this interface/class talks to the database. manage it for me)

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String username); // Looks in the database for a User with that username.
    Optional<User> findByEmail(String email);
    Optional<User> findByPassword(String password);

    boolean existsByUsername(String username);// checks if someone with that username already exists.
    boolean existsByEmail(String email);
    boolean existsByPassword(String password);

    // when new user signs up, this boolean needs
    // when user sign in, need this option

}


//Create - save()
//Read - findById(), findByUsername()
//Update - save()
//Delete - delete()

//Repositories - can also handle custom searches, queries, sorting, and pagination.