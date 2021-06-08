package service.producjdbc;

import model.Category;
import model.Product;
import service.ConnectJDBC;
import service.categoryjdbc.CategoryService;
import service.categoryjdbc.ICategoryService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{

    public static final String SELECT_ALL_PRODUCT = "select *, category_name from product\n" + "join category c on c.id = product.category_id;";
    public static final String INSERT_INTO_PRODUCT = "insert into product (name, price, quantity, color, description, category_id) VALUE\n" +
            "(?,?,?,?,?,?)";
    public static final String UPDATE_PRODUCT = "update product set name = ?,price = ?, quantity = ?,color =?, description = ?,category_id = ? where id = ?";
    public static final String DELETE_PRODUCT = "delete from product where id = ?";
    public static final String SELECT_PRODUCT_BY_ID = "select  * from product where id = ?";
    ICategoryService categoryService = new CategoryService();

    Connection connection = ConnectJDBC.getConnect();

    @Override
    public List<Product> selectAll() {
        List<Product> productList = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                double price = set.getDouble("price");
                int quantity = set.getInt("quantity");
                String color = set.getString("color");
                String description = set.getString("description");

                int category_id = set.getInt("category_id");
                String category_name = set.getString("category_name");
                Category category = new Category(category_id,category_name);
                Product product = new Product(id,name,price,quantity,color,description,category);
                productList.add(product);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product selectById(int id) {
        Product product = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            statement.setInt(1,id);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                String name = set.getString("name");
                double price = set.getDouble("price");
                int quantity = set.getInt("quantity");
                String color = set.getString("color");
                String description = set.getString("description");

                int category_id = set.getInt("category_id");
                Category category = this.categoryService.selectById(category_id);
                product = new Product(id,name,price,quantity,color,description,category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public void create(Product product) {

        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_INTO_PRODUCT);
            statement.setString(1,product.getName());
            statement.setDouble(2,product.getPrice());
            statement.setInt(3,product.getQuantity());
            statement.setString(4,product.getColor());
            statement.setString(5,product.getDescription());
            statement.setInt(6,product.getCategory().getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void edit(int id, Product product) {

        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT);

            statement.setInt(7,id);
            statement.setString(1,product.getName());
            statement.setDouble(2,product.getPrice());
            statement.setInt(3,product.getQuantity());
            statement.setString(4,product.getColor());
            statement.setString(5,product.getDescription());
            statement.setInt(6,product.getCategory().getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(DELETE_PRODUCT);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public Product search(String name) {
        Product product = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select *, category_name from product join category c on c.id = product.category_id where name = ?");
            statement.setString(1,name);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                int id = set.getInt("id");
                double price = set.getDouble("price");
                int quantity = set.getInt("quantity");
                String color = set.getString("color");
                String description = set.getString("description");

                int category_id = set.getInt("category_id");
                String category_name = set.getString("category_name");
                Category category = new Category(category_id,category_name);
                product = new Product(id,name,price,quantity,color,description,category);


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
       return product;
    }
}
