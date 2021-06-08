package controller;

import model.Category;
import model.Product;
import service.categoryjdbc.CategoryService;
import service.categoryjdbc.ICategoryService;
import service.producjdbc.IProductService;
import service.producjdbc.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    IProductService productService = new ProductService();
    ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String action = request.getParameter("action");
       if (action == null) action = "";
       switch (action){
           case "":
               showListProduct(request,response);
               break;
           case "create":
               showFormCreate(request,response);
               break;
           case "edit":
               showFormEdit(request,response);
               break;
           case "delete":
               showFormDelete(request,response);
               break;
       }
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.selectById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/delete.jsp");
        request.setAttribute("product",product);
        dispatcher.forward(request,response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        List<Category> categoryList = this.categoryService.selectAll();
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.selectById(id);
        request.setAttribute("product",product);
        request.setAttribute("categoryList",categoryList);
        dispatcher.forward(request,response);
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();
        List<Category> categoryList = categoryService.selectAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("product", product);
        request.setAttribute("categoryList",categoryList);
        dispatcher.forward(request,response);
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = this.productService.selectAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/listProduct.jsp");
        request.setAttribute("productList",productList);
        dispatcher.forward(request,response);
        

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "create":
                CreateNewProduct(request,response);
                break;
            case "edit":
                EditProduct(request,response);
                break;

            case "delete":
                deleteProduct(request,response);
                break;
            case "search":
                searchByName(request,response);
                break;

        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Product product = this.productService.search(name);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/search.jsp");
        dispatcher.forward(request,response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.productService.delete(id);
        request.setAttribute("message","Success");
        response.sendRedirect("product/listProduct.jsp");



    }

    private void EditProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        Category category = this.categoryService.selectById(category_id);
        Product product = new Product(id, name,price,quantity,color,description,category);
        this.productService.edit(id,product);
        response.sendRedirect("product/listProduct.jsp");

    }

    private void CreateNewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = (int)(Math.random() * 10000);
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        Category category = this.categoryService.selectById(category_id);
        Product product = new Product(id, name,price,quantity,color,description,category);
        this.productService.create(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/listProduct.jsp");
        dispatcher.forward(request,response);

    }
}
