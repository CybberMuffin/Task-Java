package ua.kpi.tef.model.manager;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import ua.kpi.tef.controller.AviationHeritage;
import ua.kpi.tef.controller.enums.PlaneType;
import ua.kpi.tef.model.entity.Plane;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class DbPlaneMager implements PlaneManager {
    private static final String URL = "jdbc:mysql://localhost:3306/aviation_company";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private Connection connection;
    private String SELECT_ALL_QUERY = "SELECT * FROM `planes`";
    private PreparedStatement getAll;

    public DbPlaneMager() throws Exception {
        Driver driver = new FabricMySQLDriver();
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        if (connection.isClosed()) {
            throw new RuntimeException("Connection failed");
        }
        getAll = connection.prepareStatement(SELECT_ALL_QUERY);
    }

    @Override
    public ArrayList<Plane> getAllPlanes() throws Exception {
        ResultSet result = getAll.executeQuery();
        ArrayList<Plane> planes = new ArrayList<>();
        while(result.next()){
            String model = result.getString(FinalText.PLANE_MODEL);
            Integer capacity = result.getInt(FinalText.PLANE_CAPACITY);
            Integer carryingCapacity = result.getInt(FinalText.PLANE_CARRYING_CAPACITY);
            Integer fuelConsumption = result.getInt(FinalText.PLANE_FUEL_CONSUMPTION);
            Integer range = result.getInt(FinalText.PLANE_FLIGHT_RANGE);
            PlaneType planeType = PlaneType.getType(result.getString(FinalText.PLANE_TYPE));
            AviationHeritage aviation = new AviationHeritage();
            planes.add(aviation.choosePlane(planeType, model, capacity, carryingCapacity, fuelConsumption, range));
        }
        Collections.sort(planes);
        return planes;
    }
}
