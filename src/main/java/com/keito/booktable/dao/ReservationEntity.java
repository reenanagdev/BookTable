package com.keito.booktable.dao;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.keito.booktable.model.Reservation;

@Entity(name="RESERVATION")
public class ReservationEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name="TABLE_ID")
	private long tableId;
	
	@Column(name="USER_ID")
	private long userId;
	
	@Column(name="DATETIME")
	private LocalDateTime dateTime;
	private int duration;
	private int seats;
	
	public ReservationEntity() {
		super();
	}
	
	public ReservationEntity(Reservation reservation) {
		this.tableId = reservation.getTableId();
		this.userId = reservation.getUserId();
		this.dateTime = reservation.getDateTime();
		this.duration = reservation.getDuration();
		this.seats = reservation.getSeats();
	}
	
	public long getTableId() {
		return tableId;
	}
	public void setTableId(long tableId) {
		this.tableId = tableId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	

}
