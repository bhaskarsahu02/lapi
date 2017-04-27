package com.incture.LookupAPI.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Bhaskar Sahu
 *
 */
@XmlRootElement
public class LookupResponse {
	private String message;
	private List<VehicleDto> vehicleDtos;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<VehicleDto> getVehicleDtos() {
		return vehicleDtos;
	}

	public void setVehicleDtos(List<VehicleDto> vehicleDtos) {
		this.vehicleDtos = vehicleDtos;
	}

	@Override
	public String toString() {
		return "LookupResponse [message=" + message + ", vehicleDtos=" + vehicleDtos + "]";
	}

}
