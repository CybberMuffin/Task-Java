package ua.kpi.tef.controller.command;

import ua.kpi.tef.controller.exceptions.InvalidRangeException;
import ua.kpi.tef.model.Model;
import ua.kpi.tef.model.manager.FinalText;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class Sorter implements Command {
    @Override
    public String execute(HttpServletRequest request, Model model)
            throws ServletException, IOException {
        try{
            Integer lower = Integer.parseInt(request.getParameter(FinalText.SORTER_FUEL_LOWER_BOUND));
            Integer upper = Integer.parseInt(request.getParameter(FinalText.SORTER_FUEL_UPPER_BOUND));
            model.filterPlanesFuelConsumption(lower, upper);
        } catch (InvalidRangeException | NumberFormatException e) {
            request.setAttribute(FinalText.SORTER_ERROR, e.getMessage());
        }

        return FinalText.MAIN_PAGE;
    }
}
