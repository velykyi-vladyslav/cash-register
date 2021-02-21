package ua.lviv.velykyi.vladyslav.web2.command;

import org.apache.log4j.Logger;
import ua.lviv.velykyi.vladyslav.Path;
import ua.lviv.velykyi.vladyslav.db.entity.Product;
import ua.lviv.velykyi.vladyslav.db.service.ProductService;
import ua.lviv.velykyi.vladyslav.db.service.impl.ProductServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class ShowProductsCommand extends Command {
    private static final Logger log = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){

        log.debug("Command starts");
        ProductService productService = new ProductServiceImpl();
        List<Product> products = productService.findAll();

        return "Path.PAGE__ADMIN_EMPLOYEES";
    }
}
