package com.keito.booktable.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keito.booktable.dao.ReservationEntity;
import com.keito.booktable.dao.Tables;
import com.keito.booktable.dao.User;
import com.keito.booktable.model.Reservation;
import com.keito.booktable.service.ReservationService;

@RestController
@RequestMapping("/booktable")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@PostMapping("/reservation")
	ResponseEntity<Object> reservation(@Valid @RequestBody Reservation reserve) {
		return reservationService.reserveTable(reserve);
	}
	
	@GetMapping("/tables")
	List<Tables> getTables() {
		return reservationService.getTables();
	}
	
	@GetMapping("/users")
	List<User> getUsers() {
		return reservationService.getUsers();
	}
	
	@GetMapping("/reservations")
	List<ReservationEntity> getReservations() {
		return reservationService.getReservations();
		
	}

}
