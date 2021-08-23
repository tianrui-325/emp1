package com.example.emp.dao;

import com.example.emp.domain.Emp;

import java.util.List;

public interface EmpDao {
    int save(Emp emp);
    int delete(int empNo);
    List<Emp> findAll();
    int update(Emp emp);
    Emp findByEmpNo(int empNo);
}
