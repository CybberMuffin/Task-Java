package ua.kpi.tef.controller.command;
import ua.kpi.tef.model.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface Command {
    public String execute(HttpServletRequest request, Model model)
            throws ServletException, IOException;
}

