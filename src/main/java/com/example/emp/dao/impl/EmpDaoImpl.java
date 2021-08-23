package com.example.emp.dao.impl;

import com.example.emp.dao.EmpDao;
import com.example.emp.domain.Emp;
import com.example.emp.util.BaseDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    @Override
    public int save(Emp emp) {
        Connection connection
                = BaseDao.getConnection();
        try {
            PreparedStatement preparedStatement
                    =connection.prepareStatement("insert into emp(empno,ename,job,mgr,hiredate,sal,comm) values (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,emp.getEmpNo());
            preparedStatement.setString(2,emp.geteName());
            preparedStatement.setString(3,emp.getJob());
            preparedStatement.setInt(4,emp.getMgr());
            preparedStatement.setDate(5, Date.valueOf(emp.getHireDate()));
            preparedStatement.setDouble(6,emp.getSal());
            preparedStatement.setDouble(7,emp.getComm());
            int count = preparedStatement.executeUpdate();
            preparedStatement.close();
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(int empNo) {
        Connection connection = BaseDao.getConnection();
        try {
            PreparedStatement preparedStatement
                    =connection.prepareStatement("delete from emp where empno =?");
            preparedStatement.setInt(1,empNo);
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Emp> findAll() {
        Connection connection = BaseDao.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select *from emp");
            List<Emp> emp = new ArrayList<>();
            while (resultSet.next()) {
                emp.add(new Emp(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getInt(4),
                resultSet.getDate(5).toLocalDate(),
                resultSet.getDouble(6),
                resultSet.getDouble(7)));
            }
            return emp;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

    @Override
    public int update(Emp emp) {
        String sql = "update emp set ename =?,job=?,mgr=?,hiredate=?,sal=?,comm=?where empno=?";
        Connection connection = BaseDao.getConnection();
        try {
            PreparedStatement preparedStatement
                    =connection.prepareStatement(sql);
            preparedStatement.setString(1,emp.geteName());
            preparedStatement.setString(2,emp.getJob());
            preparedStatement.setInt(3,emp.getMgr());
            preparedStatement.setDate(4,Date.valueOf(emp.getHireDate()));
            preparedStatement.setDouble(5,emp.getSal());
            preparedStatement.setDouble(6,emp.getComm());
            preparedStatement.setInt(7,emp.getEmpNo());
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.close();
        }
        return 0;
    }

    @Override
    public Emp findByEmpNo(int empNo) {
        String sql = "select * from emp where empno=?";
        Connection connection = BaseDao.getConnection();
        try {
            PreparedStatement preparedStatement
                    =connection.prepareStatement(sql);
            preparedStatement.setInt(1,empNo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return new Emp(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getDate(5).toLocalDate(),
                        resultSet.getDouble(6),
                        resultSet.getDouble(7)
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.close();
        }
        return null;
    }
}
