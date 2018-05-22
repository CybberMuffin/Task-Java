package ua.kpi.tef.model.manager;

import ua.kpi.tef.model.entity.Plane;

import java.util.ArrayList;

public interface PlaneManager {
    ArrayList<Plane> getAllPlanes() throws Exception;
}
