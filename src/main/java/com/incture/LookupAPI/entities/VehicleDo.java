package com.incture.LookupAPI.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE_TBL")
public class VehicleDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -212887701028989137L;

	@Id
	private String vId;

	@Column(name = "VEHICLE_NAME")
	private String vehicleName;

	private String yearOfManu;

	public String getvId() {
		return vId;
	}

	public void setvId(String vId) {
		this.vId = vId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getYearOfManu() {
		return yearOfManu;
	}

	public void setYearOfManu(String yearOfManu) {
		this.yearOfManu = yearOfManu;
	}

}
