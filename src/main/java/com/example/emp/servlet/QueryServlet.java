package com.example.emp.servlet;

import com.example.emp.dao.EmpDao;
import com.example.emp.dao.impl.EmpDaoImpl;
import com.example.emp.domain.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
@WebServlet("/query")
public class QueryServlet extends HttpServlet {
    private static EmpDao empDao = new EmpDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Emp emp = new Emp(
                Integer.parseInt(req.getParameter("empno")),
                req.getParameter("ename"),
                req.getParameter("job"),
                Integer.parseInt(req.getParameter("mgr")),
                LocalDate.parse(req.getParameter("hiredate")),
                Double.parseDouble(req.getParameter("sal")),
                Double.parseDouble(req.getParameter("comm"))
        );
        empDao.save(emp);
        resp.sendRedirect("home");

    }
}
