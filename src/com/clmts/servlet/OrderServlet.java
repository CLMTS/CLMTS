package com.clmts.servlet;

import com.clmts.bean.Order;
import com.clmts.service.OrderService;
import com.clmts.serviceImpl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/order/*")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OrderServlet.doGet...");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        // 获取部分URL
        String path = request.getRequestURI();
        System.out.println("path: "+path);
        // 获取方法前部分长度
        int head_length = (request.getContextPath()+request.getServletPath()).length()+1;
        String method_name = path.substring(head_length, path.indexOf(".do"));
        System.out.println("method_name: "+method_name);
        try {
            Method method = getClass().getDeclaredMethod(method_name,
                    HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("----- ---- --");
    }

    // 添加订单
    protected void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OrderServlet.addOrder...");
        // 获取订单的 顾客姓名、电话、地址、商品编号、销售单价
        // 订单编号由时间戳+经理id合成
        // 下单时间、总价由后台自动计算生成
        HttpSession session = request.getSession();
        int manager_id = (Integer) session.getAttribute("manager_id");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        // 一个订单可能会有数量不定的商品
        // 将商品编号和售价存储至数组
        String[] id_str = request.getParameterValues("product_id");
        String[] price_str = request.getParameterValues("price");

        System.out.println(manager_id);
        System.out.println(name);
        System.out.println(phone);
        System.out.println(address);
        System.out.println(id_str);
        System.out.println(price_str);
        System.out.println("-----------");

        // 创建数值型数组用于存储转化后的编号和售价
        int[] product_id = new int[id_str.length];
        double[] price = new double[price_str.length];
        // 循环将编号和售价转化为数值型，存储至数组中
        for (int i = 0; i < id_str.length; i++) {
            product_id[i] = Integer.parseInt(id_str[i]);
            price[i] = Double.parseDouble(price_str[i]);
        }

        OrderService order = new OrderServiceImpl();
        boolean flag = order.takeOrder(manager_id, name, phone, address, product_id, price);

        String msg = flag ? "success!" : "failed!";

        System.out.println(msg);
        System.out.println("----- ---- --");

        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/order/searchOrder.do").forward(request, response);
    }

    // 搜索订单并显示
    protected void searchOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OrderServlet.searchOrder...");
        OrderService orderService = new OrderServiceImpl();
        List<Order> orderList = orderService.searchOrder();
        request.setAttribute("orderList", orderList);
        request.getRequestDispatcher("/show.jsp").forward(request, response);
        System.out.println("----- ---- --");
    }

    protected void searchOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OrderServlet.searchOne...");
        String order_id = request.getParameter("order_id");
        OrderService orderService = new OrderServiceImpl();
        Order order = orderService.searchOne(order_id);
        request.setAttribute("order", order);
        request.getRequestDispatcher("/detail.jsp").forward(request, response);
        System.out.println("----- ---- --");
    }
}
