package ua.kpi.tef.model.entity;

import ua.kpi.tef.controller.exceptions.InvalidDataException;

import java.io.Serializable;

public abstract class Plane implements Comparable<Plane>, Serializable {
    private String model;
    private Integer capacity;
    private Integer carryingCapacity;
    private Integer fuelConsumption;
    private Integer range;
    private static String NEGATIVE_CAPACITY = "Capacity cannot be negative";
    private static String NEGATIVE_FUEL_CONSUMPTION = "Fuel consumption cannot be negative";
    private static String NEGATIVE_RANGE = "Range cannot be negative";


    public Plane(String model, Integer capacity, Integer carryingCapacity,
                 Integer fuelConsumption, Integer range) {
        this.model = model;
        this.capacity = capacity;
        this.carryingCapacity = carryingCapacity;
        this.fuelConsumption = fuelConsumption;
        this.range = range;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) throws InvalidDataException {
        if(capacity < 0) {
            throw new InvalidDataException(NEGATIVE_CAPACITY);
        }
        this.capacity = capacity;
    }

    public Integer getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(Integer carryingCapacity) throws InvalidDataException {
        if (carryingCapacity < 0) {
            throw new InvalidDataException(NEGATIVE_CAPACITY);
        }
        this.carryingCapacity = carryingCapacity;
    }

    public Integer getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Integer fuelConsumption) throws InvalidDataException {
        if (fuelConsumption < 0) {
            throw new InvalidDataException(NEGATIVE_FUEL_CONSUMPTION);
        }
        this.fuelConsumption = fuelConsumption;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) throws InvalidDataException {
        if(range < 0) {
            throw new InvalidDataException(NEGATIVE_RANGE);
        }
        this.range = range;
    }

    @Override
    public int compareTo(Plane o) {
        return Integer.compare(range, o.range);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", capacity=" + capacity +
                ", carryingCapacity=" + carryingCapacity +
                ", fuelConsumption=" + fuelConsumption +
                ", range=" + range +
                '}';
    }

    /*public static final Comparator<Plane> COMPARE_BY_RANGE = new Comparator<Plane>() {
        @Override
        public int compare(Plane first, Plane second) {
            return first.getRange() - second.getRange();
        }
    };*/
}
