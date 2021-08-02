package com.keito.booktable.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.keito.booktable.dao.ReservationEntity;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
	
	@Query(value = "select * from Reservation r where r.table_id = ?1", nativeQuery=true)
	List<ReservationEntity> getReservationByTableId(Long tableId); 

}
