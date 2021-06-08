package service.producjdbc;

import model.Product;

import java.util.List;

public interface IProductService {

    List<Product> selectAll();

    Product selectById(int id);

    void create(Product product);

    void edit(int id, Product product);

    void delete(int id);

    Product search(String name);
}
