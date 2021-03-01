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
        log.debug("-- ADD PRODUCT COMMAND STARTS --");
        Product product = new Product();
        CategoryService categoryService = new CategoryServiceImpl();
        ProductService productService = new ProductServiceImpl();

        String name = request.getParameter("name");
        BigDecimal price = new BigDecimal(request.getParameter("price"));
        long categoryId = categoryService.findByName(request.getParameter("category")).getId();
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        product.setPrice(price);
        log.debug("Name of products is " + request.getParameter("name"));
        product.setName(name);
        log.debug("Updated price for product is " + price);

        if (!productService.isPresent(product)) {
            product.setCategoryId(categoryId);
            log.debug("Category for product is " + categoryId);
            product.setQuantity(quantity);
            productService.insert(product);
        } else {
            log.debug("HERE");
            product = productService.findByName(name);
            product.setQuantity(productService.getQuantity(product) + quantity);
            productService.update(product);
        }
        return Path.PAGE__HOME_COMMODITY_EXPERT;

    }
}
