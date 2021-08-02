package com.keito.booktable.model;

import java.time.LocalDateTime;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class Reservation {
	@NonNull
	private Long userId;
	
	@NonNull
	private Long tableId;
	
	private int duration;
	
	private int seats;
	
	private LocalDateTime dateTime;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getTableId() {
		return tableId;
	}

	public void setTableId(long tableId) {
		this.tableId = tableId;
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

	public void setSeats(int noOfSeats) {
		this.seats = noOfSeats;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	@JsonSerialize(using = LocalDateTimeSerializer.class)
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	

}
