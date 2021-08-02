package com.keito.booktable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keito.booktable.dao.Tables;

@Repository
public interface TableRepository extends JpaRepository<Tables, Long> {

}
