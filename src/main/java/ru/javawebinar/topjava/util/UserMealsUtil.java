package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.function.Function;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
//        .toLocalDate();
//        .toLocalTime();
    }

    public static List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO return filtered list with correctly exceeded field
        List<UserMealWithExceed> resultList = new ArrayList<>();
        Function<LocalDateTime, LocalTime> toLocT = LocalDateTime::toLocalTime;
        List<UserMeal> tmpList = new ArrayList<>();
        mealList.stream().filter(s -> TimeUtil.isBetween(toLocT.apply(s.getDateTime()), startTime, endTime)).forEach(s -> tmpList.add(s));
        for (UserMeal user:tmpList) {
            List<UserMeal> tempList = new ArrayList<>();
            mealList.stream().filter(s -> (s.getDateTime().getDayOfYear()==user.getDateTime().getDayOfYear())).forEach(p -> tempList.add(p));
            int i=0;
            for (UserMeal u:tempList) {
                i+=u.getCalories();
            }
            if(i>caloriesPerDay) resultList.add(new UserMealWithExceed(user.getDateTime(), user.getDescription(), user.getCalories(), true));
            else resultList.add(new UserMealWithExceed(user.getDateTime(), user.getDescription(), user.getCalories(), false));
        }
        return resultList;
    }
}
