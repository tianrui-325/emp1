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
@WebServlet("/findByEmpNo")
public class FindByEmpNoServlet extends HttpServlet {
    EmpDao empDao= new EmpDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int empNo = Integer.parseInt(req.getParameter("empNo"));
        Emp emp = empDao.findByEmpNo(empNo);
        req.setAttribute("emp", emp);
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }
}
