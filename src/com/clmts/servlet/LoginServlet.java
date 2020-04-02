package com.clmts.servlet;

import com.clmts.service.ManagerService;
import com.clmts.serviceImpl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author suhao
 * @create_date 2020-04-02 10:29
 * @update bia at 2020-04-02 19:37
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取输入的用户名密码
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        ManagerService manager = new ManagerServiceImpl();
        // 判断密码是否正确
        // 正确返回经理编号
        int id = manager.login(uname, upwd);

        if (id != 0) {
            // 登录成功，记录登录编号
            HttpSession session = request.getSession();
            session.setAttribute("manager_id", id);
            // 跳转至订单界面
            response.sendRedirect("show.jsp");
        } else {
            // 登录失败，重新登陆
            request.setAttribute("msg", "login failed");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
