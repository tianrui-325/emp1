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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    EmpDao empDao = new EmpDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Emp emp = new Emp(
                Integer.parseInt(req.getParameter("empNo")),
                req.getParameter("eName"),
                req.getParameter("job"),
                Integer.parseInt(req.getParameter("mgr")),
                LocalDate.parse(req.getParameter("hireDate")),
                Double.parseDouble(req.getParameter("sal")),
                Double.parseDouble(req.getParameter("comm"))
        );
        empDao.update(emp);
        resp.sendRedirect("home");
    }
}
