package xyz.dev.roomtracking.quarter2;

import org.junit.Test;

 public class ObcianaProfile {
     @Test

     public void printMyProfile () {
         // --- 1. THE INPUT
         String myName = "Charlotte P Obciana";
         String petName = "Any";
         String favFood = "Adobo";
         int myAge = 17;

         // --- 2. THE OUTPUT
         System.out.println("--- MY DIGITAL PROFILE ---");
         System.out.println("Hello, my name is " + myName + " and I am " + myAge + " years old.");
         System.out.println("I have a wonderful pet named " + petName + ".");
         System.out.println("If I could, I would eat " + favFood + " every single day! ");
     }
}
