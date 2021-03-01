package ua.lviv.velykyi.vladyslav.web2.command.products;

import org.apache.log4j.Logger;
import ua.lviv.velykyi.vladyslav.Path;
import ua.lviv.velykyi.vladyslav.db.entity.Product;
import ua.lviv.velykyi.vladyslav.db.service.CategoryService;
import ua.lviv.velykyi.vladyslav.db.service.ProductService;
import ua.lviv.velykyi.vladyslav.db.service.impl.CategoryServiceImpl;
import ua.lviv.velykyi.vladyslav.db.service.impl.ProductServiceImpl;
import ua.lviv.velykyi.vladyslav.web2.command.Command;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class AddProductCommand extends Command {
    private static final Logger log = Logger.getLogger(AddProductCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.debug("Command starts");
        Product product = new Product();
        CategoryService categoryService = new CategoryServiceImpl();
        ProductService productService = new ProductServiceImpl();
        product.setName(request.getParameter("name"));
        BigDecimal price = new BigDecimal(request.getParameter("price"));

        product.setPrice(price);
        product.setCategoryId(categoryService.findByName(request.getParameter("category")).getId());

        log.debug(request.getParameter("name"));
        log.debug(price);
        log.debug(request.getParameter("category"));

        for (int i = 0; i< Integer.parseInt(request.getParameter("count")); i++){
            productService.insert(product);
        }


        return Path.PAGE__HOME_COMMODITY_EXPERT;

    }
}
