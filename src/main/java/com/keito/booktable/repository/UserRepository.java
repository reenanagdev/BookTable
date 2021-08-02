package com.keito.booktable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keito.booktable.dao.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
