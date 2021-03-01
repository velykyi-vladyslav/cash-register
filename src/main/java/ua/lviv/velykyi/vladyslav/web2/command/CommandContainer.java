package ua.lviv.velykyi.vladyslav.web2.command;

import org.apache.log4j.Logger;
import ua.lviv.velykyi.vladyslav.web2.command.employees.CreateEmployeeCommand;
import ua.lviv.velykyi.vladyslav.web2.command.employees.DeleteEmployeeCommand;
import ua.lviv.velykyi.vladyslav.web2.command.employees.ShowEmployeesCommand;
import ua.lviv.velykyi.vladyslav.web2.command.login.LoginCommand;
import ua.lviv.velykyi.vladyslav.web2.command.login.LogoutCommand;
import ua.lviv.velykyi.vladyslav.web2.command.products.AddProductCommand;
import ua.lviv.velykyi.vladyslav.web2.command.products.CreateCategoryCommand;
import ua.lviv.velykyi.vladyslav.web2.command.products.DeleteProductCommand;
import ua.lviv.velykyi.vladyslav.web2.command.products.ShowProductsCommand;
import ua.lviv.velykyi.vladyslav.web2.command.receipt.CreateReceiptCommand;

import java.util.Map;
import java.util.TreeMap;

public class CommandContainer {

    private static final Logger log = Logger.getLogger(CommandContainer.class);

    private static Map<String, Command> commands = new TreeMap();

    static {
        // common commands
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("create employee", new CreateEmployeeCommand());
        commands.put("get employees", new ShowEmployeesCommand());
        commands.put("delete employees", new DeleteEmployeeCommand());
        commands.put("show products", new ShowProductsCommand());
        commands.put("add product", new AddProductCommand());
        commands.put("create category", new CreateCategoryCommand());
        commands.put("delete products", new DeleteProductCommand());
        commands.put("create receipt", new CreateReceiptCommand());

        log.debug("Command container was successfully initialized");
        log.trace("Number of commands --> " + commands.size());
    }

    public static Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            log.trace("Command not found, name --> " + commandName);
            return commands.get("noCommand");
        }

        return commands.get(commandName);
    }
}
