package by.itclass.model.entities.food;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
@EqualsAndHashCode
public class FoodItem {
    protected int id;
    protected int type;
    protected String name;
    protected double price;
}
