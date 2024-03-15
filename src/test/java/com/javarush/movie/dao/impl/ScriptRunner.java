package com.javarush.movie.dao.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

//https://mybatis.org/mybatis-3/apidocs/org/apache/ibatis/jdbc/ScriptRunner.html
@RequiredArgsConstructor
public final class ScriptRunner {
    private final SessionFactory sessionFactory;

    public void runScript(String... scriptFilenames) {
        List<String> scripts = readScriptFiles(scriptFilenames);

        for (String script : scripts) {
            try (Session session = sessionFactory.openSession()) {
                //TODO:
                session.createNativeQuery("BEGIN " + script + " END");
            }

        }
    }

    private static List<String> readScriptFiles(String[] scriptFiles) {
        List<String> scripts = new ArrayList<>();
        for (String scriptFile : scriptFiles) {
            scripts.add(readScriptFile(scriptFile));
        }

        return scripts;
    }

    private static String readScriptFile(String scriptFile) {
        throw new UnsupportedOperationException();
    }


}
