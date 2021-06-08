package service.categoryjdbc;

import model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> selectAll();

    Category selectById(int id);

}
