package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.repository.MealRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    private MealRepository repository;

    @Override
    public void init() throws ServletException {
        super.init();
        repository = new MealRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meals");
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        System.out.println(action);
        System.out.println(id);
        List<MealTo> listMeals;
        if (action == null) action = "all";
        switch (action) {
            case "create":
                log.debug("create");
            case "update":
                log.debug("update");
                request.getRequestDispatcher("form.jsp").forward(request, response);
                break;
            case "delete":
                log.debug("delete");
                repository.delete(Integer.valueOf(id));
                listMeals = repository.getAll();
                request.setAttribute("listMs", listMeals);
            default:
                listMeals = repository.getAll();
                request.setAttribute("listMs", listMeals);
        }


//        System.out.println(listMeals);

        request.getRequestDispatcher("meals.jsp").forward(request, response);
//        response.sendRedirect("meals.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String date = req.getParameter("date");
        String description = req.getParameter("description");
        String calories = req.getParameter("calories");
        System.out.println(id + " " + date + " " + description + " " + calories);
        log.debug("redirect to meals");
        repository.save(new Meal(LocalDateTime.parse(date), description, Integer.valueOf(calories)));
        String action = req.getParameter("action");
        List<MealTo> listMeals;
        listMeals = repository.getAll();
        req.setAttribute("listMs", listMeals);
        req.getRequestDispatcher("meals.jsp").forward(req, resp);
    }
}
