package ua.kpi.tef;

import ua.kpi.tef.model.Model;
import ua.kpi.tef.model.entity.Plane;
import ua.kpi.tef.model.manager.DbPlaneMager;
import ua.kpi.tef.model.manager.PlaneManager;

import java.util.ArrayList;

public class App {
    private static Model model;
    public static void main(String[] args){
        PlaneManager manager;
        try {
            manager = new DbPlaneMager();
            model = new Model((ArrayList<Plane>)manager.getAllPlanes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<Plane> planes = new ArrayList<>();
    }
}
