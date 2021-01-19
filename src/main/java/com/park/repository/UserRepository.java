package com.park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.park.repository.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

}
