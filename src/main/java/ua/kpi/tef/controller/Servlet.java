package ua.kpi.tef.controller;

import ua.kpi.tef.controller.command.Command;
import ua.kpi.tef.controller.command.Sorter;
import ua.kpi.tef.model.Model;
import ua.kpi.tef.model.entity.Plane;
import ua.kpi.tef.model.manager.DbPlaneMager;
import ua.kpi.tef.model.manager.FinalText;
import ua.kpi.tef.model.manager.PlaneManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Servlet extends HttpServlet {
    private Model model;
    private PlaneManager manager;
    private ArrayList<Plane> data;
    private Map<String, Command> commands = new HashMap<>();

    @Override
    public void init() throws ServletException {
        try{
            this.manager = new DbPlaneMager();
            this.data = manager.getAllPlanes();
            this.data.forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        model = new Model(this.data);
        commands.put("sorter", new Sorter());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        String commandName = request.getParameter(FinalText.SERVLET_COMMAND_NAME);
        System.out.println(commandName);
        Command command = commands.getOrDefault(commandName ,
                (r, model)-> FinalText.MAIN_PAGE);
        String page = command.execute(request, model);
        setRequestAttributes(request);
        request.getRequestDispatcher(page).forward(request, response);
    }

    private void setRequestAttributes(HttpServletRequest request) {
        request.setAttribute(FinalText.PLANES, model.getAllPlanes());
        request.setAttribute(FinalText.SORTER_FUEL_LOWER_BOUND, model.getLowerRangeBound());
        request.setAttribute(FinalText.SORTER_FUEL_UPPER_BOUND, model.getUpperRangeBound());
    }
}