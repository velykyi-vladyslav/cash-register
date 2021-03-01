package ua.lviv.velykyi.vladyslav.web2.command.products;

import ua.lviv.velykyi.vladyslav.Path;
import ua.lviv.velykyi.vladyslav.db.service.ProductService;
import ua.lviv.velykyi.vladyslav.db.service.impl.ProductServiceImpl;
import ua.lviv.velykyi.vladyslav.web2.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProductCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int count = Integer.parseInt(request.getParameter("count"));
        String productName = request.getParameter("name");
        ProductService productService = new ProductServiceImpl();

        if (productService.delete(productName, count)){
            return Path.PAGE__HOME_COMMODITY_EXPERT;
        }
        return null;//error page


    }
}
