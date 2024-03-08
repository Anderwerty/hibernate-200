package com.javarush.movie.view;

import java.util.Scanner;

public class ConsoleViewProvider {

    public String readFromConsole(){
       return new Scanner(System.in).nextLine();
    }

    public void print(String message){
        System.out.println(message);
    }

}
