package ua.lviv.velykyi.vladyslav.web2.command.products;

import org.apache.log4j.Logger;
import ua.lviv.velykyi.vladyslav.Path;
import ua.lviv.velykyi.vladyslav.db.bean.ProductsBean;
import ua.lviv.velykyi.vladyslav.db.service.impl.ProductServiceImpl;
import ua.lviv.velykyi.vladyslav.web2.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowProductsCommand extends Command {
    private static final Logger log = Logger.getLogger(ShowProductsCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.debug("Commands starts");
        List<ProductsBean> productsBeans = new ProductServiceImpl().getBeanList();
        log.debug("Generated beans -> " + productsBeans);
        request.setAttribute("productsBeanList", productsBeans);
        log.debug("Commands finished");


        new CreateCategoryCommand().updateCategoriesList(request);
        return Path.PAGE__HOME_COMMODITY_EXPERT;
    }


}
