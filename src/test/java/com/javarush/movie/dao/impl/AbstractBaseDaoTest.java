package com.javarush.movie.dao.impl;


import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractBaseDaoTest {

    @BeforeEach
    void init(){
        ScriptRunner.runScript("schema.sql", "data.sql");
    }

}
