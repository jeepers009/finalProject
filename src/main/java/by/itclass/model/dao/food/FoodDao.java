package by.itclass.model.dao.food;

import by.itclass.constants.DbConstants;
import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.food.FoodItem;

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.itclass.constants.DbConstants.*;

public class FoodDao {
    private static FoodDao dao;

    public FoodDao() throws IOException, ClassNotFoundException {
        ConnectionManager.init();
    }

    public static FoodDao getInstance() throws IOException, ClassNotFoundException {
        return dao == null ? new FoodDao() : dao;
    }

    public List<FoodItem> getFoodByType(int foodType) {
        List<FoodItem> items = new ArrayList<>();
        try(Connection cn = ConnectionManager.getConnection();
            PreparedStatement ps = cn.prepareStatement(SELECT_FOOD_BY_TYPE)) {
            ps.setInt(1,foodType);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(ID_COL);
                String name = resultSet.getString(NAME_COL);
                double price = resultSet.getDouble(PRICE_COL);
                items.add(new FoodItem(id,foodType,name,price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}
