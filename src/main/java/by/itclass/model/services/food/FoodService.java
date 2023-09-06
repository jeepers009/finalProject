package by.itclass.model.services.food;

import by.itclass.model.dao.food.FoodDao;
import by.itclass.model.entities.food.FoodItem;

import java.util.List;
import java.util.Objects;

public class FoodService {
    private static FoodService service;
    private FoodDao dao;

    public FoodService() {    dao = FoodDao.getInstance();   }

    public static FoodService getInstance() {
        return Objects.isNull(service) ? new FoodService() : service;
    }

    public List<FoodItem> getFoodItemsByType(int foodType) {
        return dao.getFoodItemsByType(foodType);
    }
}
