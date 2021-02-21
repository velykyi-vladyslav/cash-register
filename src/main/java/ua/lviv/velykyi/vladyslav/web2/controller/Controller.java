package ua.lviv.velykyi.vladyslav.web2.controller;

import org.apache.log4j.Logger;
import ua.lviv.velykyi.vladyslav.web2.command.Command;
import ua.lviv.velykyi.vladyslav.web2.command.CommandContainer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controller", urlPatterns = {"/controller/*"})
public class Controller extends HttpServlet {

    private static final Logger log = Logger.getLogger(Controller.class);
    private static final long serialVersion = 2423353715955164816L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {




        // extract command name from the request
        String commandName = request.getParameter("command");

        // obtain command object by its name
        Command command = CommandContainer.get(commandName);

        // execute command and get forward address
        String forward = command.execute(request, response);
        log.debug(forward);

        // if the forward address is not null go to the address
        if (forward != null) {
            RequestDispatcher disp = request.getRequestDispatcher(forward);
            disp.forward(request, response);
        }
    }
}
