package com.softtek.academia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="state")
public class State {
	
	@Id
	@Column(name = "state_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long state_id;
	private String description;
	private String shipping_zone_id;
	
	public long getState_id() {
		return state_id;
	}
	public void setState_id(long state_id) {
		this.state_id = state_id;
	}
	
	
	public String getShipping_zone_id() {
		return shipping_zone_id;
	}
	public void setShipping_zone_id(String shipping_zone_id) {
		this.shipping_zone_id = shipping_zone_id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "State [id=" + state_id + ", Description=" + description + "]";
	}

    

}