package com.clmts.servlet;

import com.clmts.bean.Product;
import com.clmts.service.ProductService;
import com.clmts.serviceImpl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ProductServlet...");
        ProductService productService = new ProductServiceImpl();
        List<Product> productList = productService.searchProducts();
        System.out.println("----- ---- --");
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("/records.jsp").forward(request, response);
    }
}
