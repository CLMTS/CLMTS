package com.clmts.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author suhao
 * @create_date 2020-04-02 10:29
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String uname=request.getParameter("uname");
         String upwd=request.getParameter("upwd");

         if(uname.equals("sh")&&upwd.equals("123")){
             request.getRequestDispatcher("show.jsp").forward(request, response);
         }else if (uname.equals("lgr")&&upwd.equals("123")){
             request.getRequestDispatcher("show.jsp").forward(request, response);
         }
         else if (uname.equals("ltt")&&upwd.equals("123")){
             request.getRequestDispatcher("show.jsp").forward(request, response);
         }
         else if (uname.equals("sml")&&upwd.equals("123")){
             request.getRequestDispatcher("show.jsp").forward(request, response);
         }
         else if (uname.equals("cjh")&&upwd.equals("123")){
             request.getRequestDispatcher("show.jsp").forward(request, response);
         }else{
             request.getRequestDispatcher("index.jsp").forward(request, response);
         }
    }
}
