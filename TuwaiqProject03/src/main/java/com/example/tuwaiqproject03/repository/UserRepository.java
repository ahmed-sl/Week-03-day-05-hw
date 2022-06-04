package com.example.tuwaiqproject03.repository;

import com.example.tuwaiqproject03.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
