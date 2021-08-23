package com.example.emp.dao.impl;

import com.example.emp.dao.EmpDao;
import com.example.emp.domain.Emp;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmpDaoImplTest {
    EmpDao empDao = new EmpDaoImpl();
    @Test
    void save() {
        Emp emp  = new Emp(
                7636,
                "LMD",
                "SAS",
                2393,
                LocalDate.now(),
                8687,
                80
        );
        assertEquals(empDao.save(emp),1);
    }

    @Test
    void delete() {
        assertEquals(empDao.delete(7636),0);
    }

    @Test
    void findAll() {
        empDao.findAll().forEach(System.out::println);
    }
}