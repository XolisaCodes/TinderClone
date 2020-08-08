package com.company;

import java.io.FileNotFoundException;
import java.util.Scanner;

//  GROUP MEMBERS:
//  Luyanda Dingindlela
//  Xolisa Runeyi
//  Sisipho Nyobe

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
    	// write your code here
        Database db = new Database();
        Profile[] profiles = db.GetAllProfiles();
        TinderSwipe tinderSwipe = new TinderSwipe();


        Scanner scanner = new Scanner(System.in);
        int index = 0;

        System.out.println("type 'l' to swipe left and 'r' to swipe right");
        String userInput = "";

        while(!(userInput.equals(String.valueOf('q'))) ) {
            tinderSwipe.ShowNext(index, profiles);

            userInput = scanner.nextLine();

            if(userInput.toLowerCase().equals(String.valueOf('l'))) {
                if(index < profiles.length) {
                    tinderSwipe.SwipeLeft(index, profiles);
                    index++;

                } else {
                    index = 0;
                }
            } else if(userInput.toLowerCase().equals(String.valueOf('r'))) {
                if(index < profiles.length) {
                    tinderSwipe.SwipeRight(index, profiles);
                    index++;

                } else {
                    index = 0;
                }
            } else {
                    System.out.println("your selection is invalid");
            }
        }
    }
}
