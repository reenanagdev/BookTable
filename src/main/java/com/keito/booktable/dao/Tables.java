package com.keito.booktable.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tables {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "CAPACITY")
	private int capacity;
	
	@Column(name="MAX_PERIOD")
	private int maxPeriod;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getMaxPeriod() {
		return maxPeriod;
	}

	public void setMaxPeriod(int maxPeriod) {
		this.maxPeriod = maxPeriod;
	}
	
	

}
