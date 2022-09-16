package com.suyash.ecommerce.repository;

import com.suyash.ecommerce.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //    method to return user based on id=> id is email
    Optional<User> findUserByEmail(String email);
}
