package com.incture.LookupAPI.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.incture.LookupAPI.dto.LookupResponse;
import com.incture.LookupAPI.dto.VehicleDto;
import com.incture.LookupAPI.services.VehicleServices;

@Path("/vehicle")
public class VehicleRest {

	VehicleServices vehicleServices = new VehicleServices();

	@GET
	@Path("/dummy")
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it!";
	}

	@POST
	@Path("/createVehicle")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public LookupResponse createRecord(VehicleDto vehicleDto) {
		return vehicleServices.createVehicleRecord(vehicleDto);
	}

	@GET
	@Path("/getVehicle/{vId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public LookupResponse readRecord(@PathParam("vId") String vId) {
		return vehicleServices.readVehicleRecord(vId);
	}

	@POST
	@Path("/updateVehicle")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public LookupResponse updateRecord(VehicleDto vehicleDto) {
		return vehicleServices.updateVehicleRecord(vehicleDto);
	}

	@GET
	@Path("/deleteVehicle/{vId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public LookupResponse deleteRecord(@PathParam("vId") String vId) {
		return vehicleServices.deleteVehicleRecord(vId);
	}

}
