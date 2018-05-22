package ua.kpi.tef.controller;


import ua.kpi.tef.controller.enums.PlaneType;
import ua.kpi.tef.model.entity.Plane;
import ua.kpi.tef.model.entity.planes.BusinessPlane;
import ua.kpi.tef.model.entity.planes.CargoPlane;
import ua.kpi.tef.model.entity.planes.PassengerPlane;

public class AviationHeritage {
    public Plane choosePlane(PlaneType type, String model, Integer capacity, Integer carryingCapacity,
                             Integer fuelConsumption, Integer range) throws Exception {
        switch (type) {
            case PASSENGER:
                return new PassengerPlane(model, capacity, carryingCapacity, fuelConsumption, range);
            case CARGO:
                return new CargoPlane(model, capacity, carryingCapacity, fuelConsumption, range);
            case BUSINESS:
                return new BusinessPlane(model, capacity, carryingCapacity, fuelConsumption, range);
            default:
                throw new Exception("Invalid type of plane");
        }
    }

}
