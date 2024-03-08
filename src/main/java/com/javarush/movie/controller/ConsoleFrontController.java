package com.javarush.movie.controller;

import com.javarush.movie.dao.CustomerDao;
import com.javarush.movie.view.ConsoleViewProvider;

public class ConsoleFrontController {
    private final ConsoleViewProvider consoleViewProvider;
    private final CustomerDao customerDao;

    public ConsoleFrontController(ConsoleViewProvider consoleViewProvider, CustomerDao customerDao) {
        this.consoleViewProvider = consoleViewProvider;
        this.customerDao = customerDao;
    }

    public void process(){
        boolean isWorking = true;
        while (isWorking) {
            consoleViewProvider.print("");
            String answer = consoleViewProvider.readFromConsole();
            //...
        }
    }
}
