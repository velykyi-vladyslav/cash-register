package ua.lviv.velykyi.vladyslav.web2.command.receipt;

import ua.lviv.velykyi.vladyslav.Path;
import ua.lviv.velykyi.vladyslav.web2.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateReceiptCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        return Path.PAGE__HOME_CASHIER;
    }
}
