package com.incture.LookupAPI.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.incture.LookupAPI.dao.VehicleDao;
import com.incture.LookupAPI.dto.LookupResponse;
import com.incture.LookupAPI.dto.VehicleDto;
import com.incture.LookupAPI.entities.VehicleDo;

public class VehicleServices {

	private SessionFactory sessionFactory = new Configuration().configure("com/incture/LookupAPI/cfgs/hibernate.cfg.xml").buildSessionFactory();
	private Session session = sessionFactory.openSession();

	// public Session getConnection() {
	// sessionFactory = new Configuration().configure("com/incture/LookupAPI/cfgs/hibernate.cfg.xml").buildSessionFactory();
	// return sessionFactory.openSession();
	// }
	//
	// public void sessionClose() {
	// if (session != null) {
	// session.close();
	// }
	// }
	//
	// public void sessionFactoryClose() {
	// if (sessionFactory != null) {
	// sessionFactory.close();
	// }
	// }

	public LookupResponse createVehicleRecord(VehicleDto vehicleDto) {
		LookupResponse lookupResponse = new LookupResponse();
		if (vehicleDto != null) {
			try {
				session.beginTransaction();
				session.save(new VehicleDao().importDto(vehicleDto));
				session.getTransaction().commit();
				lookupResponse.setMessage("Success");
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				lookupResponse.setMessage("Failure");
			} finally {

				//getting error here
				session.close();
				sessionFactory.close();
			}
		}
		return lookupResponse;
	}

	public LookupResponse readVehicleRecord(String vId) {
		LookupResponse lookupResponse = new LookupResponse();
		List<VehicleDto> dtos = new ArrayList<VehicleDto>();
		if (vId != null) {
			VehicleDo vehicleDo = (VehicleDo) session.get(VehicleDo.class, vId);
			if (vehicleDo != null) {
				VehicleDto dto = new VehicleDao().exportDto(vehicleDo);
				dtos.add(dto);
				lookupResponse.setVehicleDtos(dtos);
			}

		}
		return lookupResponse;
	}

	public LookupResponse updateVehicleRecord(VehicleDto vehicleDto) {
		LookupResponse lookupResponse = new LookupResponse();
		List<VehicleDto> dtos = new ArrayList<VehicleDto>();
		if (vehicleDto.getvId() != null) {
			VehicleDo vehicleDo = (VehicleDo) session.get(VehicleDo.class, vehicleDto.getvId().toString());
			if (vehicleDo != null) {
				vehicleDo = new VehicleDao().importDto(vehicleDto, vehicleDo);
				try {

					session.beginTransaction();
					session.update(vehicleDo);
					session.getTransaction().commit();
					lookupResponse.setMessage("Success");
					dtos.add(vehicleDto);
					lookupResponse.setVehicleDtos(dtos);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					lookupResponse.setMessage("Failure");
				} finally {
					session.close();
					sessionFactory.close();
				}
			}
		}
		return lookupResponse;
	}

	public LookupResponse deleteVehicleRecord(String vId) {
		LookupResponse lookupResponse = new LookupResponse();
		if (vId != null) {
			VehicleDo vehicleDo = (VehicleDo) session.get(VehicleDo.class, vId);
			if (vehicleDo != null) {
				try {

					session.beginTransaction();
					session.delete(vehicleDo);
					session.getTransaction().commit();
					lookupResponse.setMessage("Deleted successfully");
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					lookupResponse.setMessage("Failure");
				} finally {
					session.close();
					sessionFactory.close();
				}
			}
		}
		return lookupResponse;
	}

	// public static void main(String args[]) {
	// VehicleServices vehicleServices = new VehicleServices();
	// VehicleDto vehicleDto = new VehicleDto();
	// vehicleDto.setvId("V102");
	// vehicleDto.setVehicleName("facino");
	// vehicleDto.setYearOfManu("2007");
	// // vehicleServices.createVehicleRecord(vehicleDto);
	// // System.out.println(vehicleServices.readVehicleRecord("V102"));
	// // vehicleDto.setVehicleName("Honda");
	// // System.out.println(vehicleServices.updateVehicleRecord(vehicleDto));
	// System.out.println(vehicleServices.deleteVehicleRecord("V102"));
	// }

}
