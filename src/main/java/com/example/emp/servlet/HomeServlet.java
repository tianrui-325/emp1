package com.example.emp.servlet;

import com.example.emp.dao.EmpDao;
import com.example.emp.dao.impl.EmpDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private static EmpDao empDao = new EmpDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setAttribute("emp",empDao.findAll());
        req.getRequestDispatcher("WEB-INF/query.jsp").forward(req,resp);
    }
}
