package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alien on 26.03.17.
 */
public class ListMeals {
    private List<Meal> list;

    {
        list = new ArrayList<>();
        list.add(new Meal(LocalDateTime.of(2016, Month.MAY, 16, 11, 0), "Завтрак", 500));
        list.add(new Meal(LocalDateTime.of(2013, Month.MAY, 20, 07, 0), "Обед", 1000));
        list.add(new Meal(LocalDateTime.of(2014, Month.MAY, 11, 20, 0), "Ужин", 500));
        list.add(new Meal(LocalDateTime.of(2014, Month.MAY, 11, 10, 0), "Завтрак", 1000));
        list.add(new Meal(LocalDateTime.of(2014, Month.MAY, 31, 13, 0), "Обед", 500));
        list.add(new Meal(LocalDateTime.of(2011, Month.MAY, 31, 20, 0), "Ужин", 510));
        list.add(new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500));
        list.add(new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000));
        list.add(new Meal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500));
        list.add(new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000));
        list.add(new Meal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500));
        list.add(new Meal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510));
    }

    public List<Meal> getList() {
        return list;
    }
}
