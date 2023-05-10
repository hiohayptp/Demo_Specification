package com.example.guessinggame;

public class GuessGame {
    Player p1;
    Player p2;
    Player p3;
    int counter;


    public void startGame(){
        counter =0;
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        int guessp1 = 0;
        int guessp2 = 0;
        int guessp3 = 0;

        boolean p1IsRight = false;
        boolean p2IsRight = false;
        boolean p3IsRight = false;

        double rand2 = (Math.random()*100);
        int targetNumber = (int) rand2;
        System.out.print("I am thinking "+targetNumber);

        while (true){
            counter++;
            System.out.println("Number to guess is "+targetNumber);
            p1.guess();
            p2.guess();
            p3.guess();

            guessp1 = p1.number;
            System.out.println("P1 guessed "+guessp1);
            guessp2 = p2.number;
            System.out.println("P2 guessed "+guessp2);
            guessp3 = p3.number;
            System.out.println("P3 guessed "+guessp3);

            if (guessp1 == targetNumber){
                p1IsRight = true;
            }
            if (guessp2 == targetNumber){
                p2IsRight = true;
            }
            if (guessp3 == targetNumber){
                p3IsRight = true;
            }

            if (p1IsRight || p2IsRight || p3IsRight){
                System.out.println("Winner Found!!!");
                System.out.println("Palayer 1 got it right ? "+ p1IsRight);
                System.out.println("Palayer 2 got it right ? "+ p2IsRight);
                System.out.println("Palayer 3 got it right ? "+ p3IsRight);
                System.out.println("Game is over!!");
                System.out.println("Total guessed times is :"  +counter);
                break;
            }else {
                System.out.println("No match Found!,Try again...");
            }


        }
    }
}
