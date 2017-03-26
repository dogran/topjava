package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.ListMeals;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alien on 26.03.17.
 */
public class MealServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MealWithExceed> list = MealsUtil.getFilteredWithExceededByCycle(new ListMeals().getList(), LocalTime.of(7, 0), LocalTime.of(23, 0), 2000);
        req.setAttribute("list", list);

        req.getRequestDispatcher("/meals.jsp").forward(req, resp);
    }
}
