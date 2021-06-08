package service.categoryjdbc;

import model.Category;
import service.ConnectJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategoryService{

    Connection connection = ConnectJDBC.getConnect();


    @Override
    public List<Category> selectAll() {
        List<Category> categoryList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from category");
            ResultSet set = statement.executeQuery();
            while (set.next()){
                int id = set.getInt("id");
                String name = set.getString("category_name");

                Category category = new Category(id,name);
                categoryList.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public Category selectById(int id) {
        Category category = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from category where id = ?");
            statement.setInt(1,id);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                String name = set.getString("category_name");
                category = new Category(id,name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return category;
    }
}
