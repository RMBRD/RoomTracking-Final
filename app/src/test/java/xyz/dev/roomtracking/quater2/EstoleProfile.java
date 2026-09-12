package xyz.dev.roomtracking.quater2;

import org.junit.Test;

public class EstoleProfile {
    @Test
    public void printMyProfile () {
        // --- 1. THE INPUT
        String myName = "James Aiken P. Estole";
        String petName = "Nutella";
        String favFood = "Tortang Giniling";
        int myAge = 17;

        // --- 2. THE OUTPUT
        System.out.println("--- MY DIGITAL PROFILE ---");
        System.out.println("Hello, my name is " + myName + " and I am " + myAge + " years old.");
        System.out.println("I have a wonderful pet named " + petName + ".");
        System.out.println("If I could, I would eat " + favFood + " every single day!");
    }
}