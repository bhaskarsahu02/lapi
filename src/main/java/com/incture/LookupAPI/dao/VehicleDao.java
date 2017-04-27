package com.incture.LookupAPI.dao;

import com.incture.LookupAPI.dto.VehicleDto;
import com.incture.LookupAPI.entities.VehicleDo;

public class VehicleDao {

	// for reading
	public VehicleDto exportDto(VehicleDo vehicleDo) {
		VehicleDto vehicleDto = new VehicleDto();
		if (vehicleDo.getvId() != null) {
			vehicleDto.setvId(vehicleDo.getvId());
		}
		if (vehicleDo.getVehicleName() != null) {
			vehicleDto.setVehicleName(vehicleDo.getVehicleName());
		}
		if (vehicleDo.getYearOfManu() != null) {
			vehicleDto.setYearOfManu(vehicleDo.getYearOfManu());
		}

		return vehicleDto;
	}

	// for creating
	public VehicleDo importDto(VehicleDto vehicleDto) {
		VehicleDo vehicleDo = new VehicleDo();
		if (vehicleDto.getvId() != null) {
			vehicleDo.setvId(vehicleDto.getvId());
		}
		if (vehicleDto.getVehicleName() != null) {
			vehicleDo.setVehicleName(vehicleDto.getVehicleName());
		}
		if (vehicleDto.getYearOfManu() != null) {
			vehicleDo.setYearOfManu(vehicleDto.getYearOfManu());
		}
		return vehicleDo;
	}

	// for updating
	public VehicleDo importDto(VehicleDto vehicleDto, VehicleDo vehicleDo) {
		if (vehicleDto.getvId() != null) {
			vehicleDo.setvId(vehicleDto.getvId());
		}
		if (vehicleDto.getVehicleName() != null) {
			vehicleDo.setVehicleName(vehicleDto.getVehicleName());
		}
		if (vehicleDto.getYearOfManu() != null) {
			vehicleDo.setYearOfManu(vehicleDto.getYearOfManu());
		}
		return vehicleDo;
	}

}
