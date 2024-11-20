package com.springsecurity.repository;

import com.springsecurity.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepo extends JpaRepository<Users, Long> {

    Users findByUsername(String username);
}
