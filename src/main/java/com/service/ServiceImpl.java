package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.Car;
import com.data.CarTypeEnum;
import com.data.Constant;
import com.data.ParkRepository;
import com.data.Request;
import com.data.Response;

@Service
public class ServiceImpl {
	private final ParkRepository parkRepository;
	
	@Autowired
	public ServiceImpl(ParkRepository parkRepository) {
		this.parkRepository = parkRepository;
	}
		
	public void log(Request request, Response response) {
		// do logging process
	}

	public Response postParking(Request request) {
		Response response = new Response();
		if(CarTypeEnum.CAR.type.equals(request.getCar().getCarType()))
		{
			response = allocateSlot(CarTypeEnum.CAR.slot,request,"park");
		}
		if(CarTypeEnum.TRUCK.type.equals(request.getCar().getCarType()))
		{
			response = allocateSlot(CarTypeEnum.TRUCK.slot,request,"park");
		}
		if(CarTypeEnum.JEEP.type.equals(request.getCar().getCarType()))
		{
			response = allocateSlot(CarTypeEnum.JEEP.slot,request,"park");
		}
		
		return response;
	}
	
	private Response allocateSlot(int slot,Request request,String status)
	{
		Response response = new Response();
		boolean isFind = false;
		if(Constant.park.equals(status)) {
			List<Car> carListInThePark = parkRepository.findAll();
			for (int i = 0; i < carListInThePark.size() -1 ; i= i+slot) {
				if(carListInThePark.get(i).getCarNo().isBlank())
				{
					response.setResult("Allocated 1 slot" );
					parkRepository.save(request.getCar());
					isFind = true;
					break;
				}
			}
		}
		else if(Constant.leave.equals(status))
		{
			List<Car> carListInThePark = parkRepository.findAll();
			for (int i = 0; i < carListInThePark.size() -1 ; i= i+slot) {
				if(carListInThePark.get(i).getCarNo().equals(request.getCar().getCarNo()))
				{
					response.setResult("leave " + i );
					parkRepository.delete(request.getCar());
					isFind = true;
					break;
				}
			}
		}
		if(!isFind)
			response.setResult("Garage is full");
		return response;
	}
	

	public Response leaveParking(Request request) {
		Response response = new Response();
		if(CarTypeEnum.CAR.type.equals(request.getCar().getCarType()))
		{
			response = allocateSlot(CarTypeEnum.CAR.slot,request,"leave");
		}
		if(CarTypeEnum.TRUCK.type.equals(request.getCar().getCarType()))
		{
			response = allocateSlot(CarTypeEnum.TRUCK.slot,request,"leave");
		}
		if(CarTypeEnum.JEEP.type.equals(request.getCar().getCarType()))
		{
			response = allocateSlot(CarTypeEnum.JEEP.slot,request,"leave");
		}
		
		return response;
	}

	public Response getStatus(Request request) {
		Response response = new Response();
		List<Car> carListInThePark = parkRepository.findAll();
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("Status: ");
		for (int i = 0; i < carListInThePark.size() -1 ; i= i++) {
			Car car = carListInThePark.get(i);
			sBuilder.append(car.getCarNo());
			sBuilder.append("\n");
			sBuilder.append(car.getCarColor());
			sBuilder.append("\n");
			sBuilder.append(i);
			sBuilder.append("\n");
		}
		response.setResult(sBuilder.toString());
		return response;
	}

}
