package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.repository.memory.InMemoryRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MealRepository {
    private static final AtomicInteger count = new AtomicInteger(0);
    Map<Integer, Meal> meals = new ConcurrentHashMap<>();
    InMemoryRepository memory = new InMemoryRepository();

    {
        for (Meal m : memory.meals) {
            save(m);
        }
    }

    public Meal save(Meal m) {
        if (isNew(m)) {
            m.setId(count.get());
            meals.put(count.getAndIncrement(), m);
        } else
            meals.computeIfPresent(m.getId(), (key, oldMeal) -> m);
        return m;
    }

    private boolean isNew(Meal m) {
        return m.getId() == null;
    }

    public Meal delete(Integer id) {
        Meal meal = meals.get(id);
        System.out.println(meal);
        if (meals.get(id)!=null) {
            meals.remove(id);
        }
        return meal;
    }

    public List<MealTo> getAll() {
        List<MealTo> mealsTo = MealsUtil.filteredByStreams(meals.values(), LocalTime.MIN, LocalTime.MAX, memory.caloriesPerDay);
        System.out.println(mealsTo);
        return mealsTo;
    }

    public Meal get(String id) {
        return meals.get(Integer.valueOf(id));
    }
}
