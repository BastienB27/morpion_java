package com.codingf.morpion.classes;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Symbol {

    public static void main(String[] args) {

        char[] grid =
                {
                        ' ', ' ', ' ',
                        ' ', ' ', ' ',
                        ' ', ' ', ' '
                };
        char p1 = 'O';
        char p2 = 'X';
        char currentPlayer = p1;
        Scanner scan = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println(grid[0] + " | " + grid[1] + " | " + grid[2]);
            System.out.println(grid[3] + " | " + grid[4] + " | " + grid[5]);
            System.out.println(grid[6] + " | " + grid[7] + " | " + grid[8]);

            int c;
            System.out.println("Player " + currentPlayer + ", hello: ");
            input = scan.nextLine();

            try {
                c = Integer.parseInt(input)-1;
                if (0 <= c && c <= 8) {
                    if (grid[c] == ' '){
                        grid[c] = currentPlayer;
                    }
                    else {
                        System.err.println("Cette case est déjà prise");
                        continue;
                    }

                }
                else {
                    System.err.println("Rentre un nombre entre 1 et 9 connard");
                    continue;
                }
                if (currentPlayer == p1){
                    currentPlayer = p2;
                } else {
                    currentPlayer = p1;
                }



            } catch (Exception e) {
                System.err.println("Rentre un nombre entier connard");
                continue;
            }
        }
    }
}
