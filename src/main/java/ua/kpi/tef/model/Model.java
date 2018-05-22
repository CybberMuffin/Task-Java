package ua.kpi.tef.model;

import ua.kpi.tef.controller.exceptions.InvalidRangeException;
import ua.kpi.tef.model.entity.Plane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Model {
    private ArrayList<Plane> allPlanes;
    private ArrayList<Plane> sortedPlanes;
    private Integer lowerRangeBound = 0;
    private Integer upperRangeBound = 0;

    public Model(ArrayList<Plane> planes){
        this.allPlanes = planes;
        this.sortedPlanes = planes;
    }

    public void filterPlanesFuelConsumption(Integer lower, Integer upper) throws InvalidRangeException {
        if(lower > upper) throw new InvalidRangeException(lower, upper);
        if(upper <=0 || lower < 0) throw new InvalidRangeException(lower, upper);
        lowerRangeBound = lower;
        upperRangeBound = upper;
        sortedPlanes = allPlanes.stream()
                .filter(machine -> machine.getFuelConsumption() >= lower && machine.getFuelConsumption() <= 0)
                .collect(Collectors.toCollection(ArrayList::new));
        sortPlanes();
    }

    private void sortPlanes(){
        Collections.sort(sortedPlanes);
    }

    public ArrayList<Plane> getAllPlanes() {
        //Collections.sort(allPlanes, Plane.COMPARE_BY_RANGE);
        return sortedPlanes;
    }

    public Integer getUpperRangeBound() {
        return upperRangeBound;
    }

    public void setUpperRangeBound(Integer upperRangeBound) {
        this.upperRangeBound = upperRangeBound;
    }

    public Integer getLowerRangeBound() {
        return lowerRangeBound;
    }

    public void setLowerRangeBound(Integer lowerRangeBound) {
        this.lowerRangeBound = lowerRangeBound;
    }


}
