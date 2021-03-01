package ua.lviv.velykyi.vladyslav.web2.command.products;

import ua.lviv.velykyi.vladyslav.Path;
import ua.lviv.velykyi.vladyslav.db.bean.CategoryBean;
import ua.lviv.velykyi.vladyslav.db.entity.Category;
import ua.lviv.velykyi.vladyslav.db.service.CategoryService;
import ua.lviv.velykyi.vladyslav.db.service.impl.CategoryServiceImpl;
import ua.lviv.velykyi.vladyslav.web2.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CreateCategoryCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        CategoryService categoryService = new CategoryServiceImpl();
        Category category = new Category();
        category.setName(request.getParameter("name"));
        categoryService.insert(category);
        updateCategoriesList(request);
        return Path.PAGE__HOME_COMMODITY_EXPERT;
    }


    public void updateCategoriesList(HttpServletRequest request){
        List<CategoryBean> categoryBeans = new CategoryServiceImpl().getBeanList();

        request.setAttribute("categoriesBeanList", categoryBeans);
    }
}
