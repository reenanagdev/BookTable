package com.keito.booktable.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keito.booktable.dao.ReservationEntity;
import com.keito.booktable.dao.Tables;
import com.keito.booktable.dao.User;
import com.keito.booktable.model.Reservation;
import com.keito.booktable.repository.ReservationRepository;
import com.keito.booktable.repository.TableRepository;
import com.keito.booktable.repository.UserRepository;

@Service
public class TableReservationService implements ReservationService {
	
	@Autowired
	private TableRepository tableRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Transactional
	@Override
	public ResponseEntity<Object> reserveTable(Reservation reserve) {
		Optional<Tables> tables = tableRepository.findById(reserve.getTableId());
		
		if(tables.isPresent()) {
			if(reserve.getDuration() > tables.get().getMaxPeriod()) {
				throw new IllegalStateException("Duration greater than max period allowed for this table.");
			} else if(reserve.getSeats() > tables.get().getCapacity()) {
				throw new IllegalStateException("Number of seats requested is greater than table capacity.");
			}
			
			LocalDateTime startTime1 = reserve.getDateTime();
			LocalDateTime endTime1 = startTime1.plusMinutes(reserve.getDuration());
			
			List<ReservationEntity> tableReservations = reservationRepository.getReservationByTableId(reserve.getTableId());
			
			if(null != tableReservations && !tableReservations.isEmpty()) {
				for(ReservationEntity reservationEntity : tableReservations) {
					LocalDateTime startTime2= reservationEntity.getDateTime();
					LocalDateTime endTime2 = startTime2.plusMinutes(reservationEntity.getDuration());
					if(startTime1.isBefore(endTime2) && endTime1.isAfter(startTime2)) {
						throw new IllegalStateException("Table already booked by another user.");
					}
				}
			}
			
			ReservationEntity reservationEntity = new ReservationEntity(reserve);
			reservationRepository.save(reservationEntity);
			return ResponseEntity.ok("Table reservation done successfully.");
		}
		
		throw new IllegalStateException("Invalid table id.");
	}

	@Override
	public List<Tables> getTables() {
		return tableRepository.findAll();
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<ReservationEntity> getReservations() {
		
		return reservationRepository.findAll();
	}

}
