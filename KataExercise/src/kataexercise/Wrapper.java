/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kataexercise;

import java.util.Scanner;

/**
 *
 * @author oluwaseunshad
 */
public class Wrapper {

    /**
     * @param args the command line arguments
     */
    private static final String nextLine = System.getProperty("line.separator");
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Enter the string");
        String x = input.nextLine();
        System.out.println("Enter the maximum characters to be seen on each line");
        int y = input.nextInt();
        System.out.print(wrap(x, y));
        
        // TODO code application logic here
    }
    
/**
 * 
 * 
 * @param word
 * @param columnNumber
 * @return 
 */
public static String wrap(String word, int columnNumber) {
    //this trims the word, thereby eliminating leading and trailing spaces
    word = word.trim();
    
    //if the length of the string is less than the maximum wordlength for each line, return string.
    if(word.length() < columnNumber)
        return word;
    
    //split the returned substring if it contains a line separator(\n) 
    if(word.substring(0, columnNumber).contains(nextLine))
        return word.substring(0, word.indexOf(nextLine)).trim() + nextLine + wrap(word.substring(word.indexOf(nextLine) + 1), columnNumber);
    
   
    int nearestTab = word.lastIndexOf("\t", columnNumber);
    int nearestSpace = word.lastIndexOf(" ",  columnNumber);
    //get the maximum nearest space index
    int indexOfBlank = (nearestTab > nearestSpace) ? nearestTab : nearestSpace;
    //if there is no nearest space index, split at the designated maximum wordlength on a line
    if(indexOfBlank < 0)
        indexOfBlank = columnNumber;
    
    //split along the space index
    return word.substring(0, indexOfBlank).trim() + "\n" + wrap(word.substring(indexOfBlank), columnNumber);
}
    
}
