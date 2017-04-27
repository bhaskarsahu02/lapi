package com.incture.LookupAPI.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VehicleDto {
	private String vId;
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

	@Override
	public String toString() {
		return "VehicleDto [vId=" + vId + ", vehicleName=" + vehicleName + ", yearOfManu=" + yearOfManu + "]";
	}

}
