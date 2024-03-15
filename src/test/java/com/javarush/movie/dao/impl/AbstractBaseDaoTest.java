package com.javarush.movie.dao.impl;


import com.javarush.movie.entity.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractBaseDaoTest {
    final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.test-cfg.xml")
            .addAnnotatedClass(Customer.class)
            .buildSessionFactory();

    final ScriptRunner scriptRunner = new ScriptRunner(sessionFactory);

//    @BeforeEach
    void init(){
        scriptRunner.runScript("schema.sql", "data.sql");
    }

}
