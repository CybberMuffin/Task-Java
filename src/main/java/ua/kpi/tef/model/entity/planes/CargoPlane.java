package ua.kpi.tef.model.entity.planes;

import ua.kpi.tef.model.entity.Plane;

public class CargoPlane extends Plane{
    public CargoPlane(String model, Integer capacity, Integer carryingCapacity, Integer fuelConsumption, Integer range) {
        super(model, capacity, carryingCapacity, fuelConsumption, range);
    }
}
