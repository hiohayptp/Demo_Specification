package com.example.guessinggame;

public class Player {
    int number = 0;

    public void guess(){
        double rand = (Math.random()*100);
        number = (int) rand;
        System.out.println("I am guessing "+number);
    }
}
