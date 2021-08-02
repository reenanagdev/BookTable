package com.keito.booktable.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.keito.booktable.dao.ReservationEntity;
import com.keito.booktable.dao.Tables;
import com.keito.booktable.dao.User;
import com.keito.booktable.model.Reservation;

public interface ReservationService {
	
	public ResponseEntity<Object> reserveTable(Reservation reserve);

	public List<Tables> getTables();

	public List<User> getUsers();

	public List<ReservationEntity> getReservations();

}
