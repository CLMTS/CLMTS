package com.clmts.servlet;

import com.clmts.service.OrderService;
import com.clmts.serviceImpl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取订单的 顾客姓名、电话、地址、商品编号、销售单价
        // 订单编号由时间戳+经理id合成
        // 下单时间、总价由后台自动计算生成
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        // 一个订单可能会有数量不定的商品
        // 将商品编号和售价存储至数组
        String[] id_str = request.getParameterValues("product_id");
        String[] price_str = request.getParameterValues("price");
        // 创建数值型数组用于存储转化后的编号和售价
        int[] product_id = new int[id_str.length];
        double[] price = new double[price_str.length];
        // 循环将编号和售价转化为数值型，存储至数组中
        for (int i = 0; i < id_str.length; i++) {
            product_id[i] = Integer.parseInt(id_str[i]);
            price[i] = Double.parseDouble(price_str[i]);
        }

        OrderService order = new OrderServiceImpl();
        boolean flag = order.takeOrder(name, phone, address, product_id, price);

        String msg = flag ? "success!" : "failed!";
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }
}
