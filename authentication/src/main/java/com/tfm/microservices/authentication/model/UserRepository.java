package com.tfm.microservices.authentication.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserData, Integer> {

    UserData findByUsername(String username);
}