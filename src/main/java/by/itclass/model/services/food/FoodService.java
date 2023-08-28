package by.itclass.model.services.food;

import by.itclass.model.dao.food.FoodDao;
import by.itclass.model.entities.food.FoodItem;

import java.io.IOException;
import java.util.List;

public class FoodService {
    private static FoodService service;
    private FoodDao dao;

    public FoodService() throws IOException, ClassNotFoundException {
        dao = FoodDao.getInstance();
    }

    public static FoodService getInstance() throws IOException, ClassNotFoundException {
        return service==null?new FoodService():service;
    }

    public List<FoodItem> getFoodByType(int foodType){
        return dao.getFoodByType(foodType);
    }
}
