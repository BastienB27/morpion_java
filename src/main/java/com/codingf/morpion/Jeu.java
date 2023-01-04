package com.codingf.morpion;

import com.codingf.morpion.classes.Cases;

import javax.print.attribute.standard.PresentationDirection;
import java.util.Scanner;

public class Jeu {

    static char[] grid =
            {
                    ' ', ' ', ' ',
                    ' ', ' ', ' ',
                    ' ', ' ', ' ', ' '
            };

    static void affichageGrille(){
        /*System.out.println(" 1 | 2 | 3 ");
        System.out.println("───┼───┼───");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("───┼───┼───");
        System.out.println(" 7 | 8 | 9 ");*/
        System.out.println(grid[1] + " | " + grid[2] + " | " + grid[3]);
        System.out.println("──┼───┼──");
        System.out.println(grid[4] + " | " + grid[5] + " | " + grid[6]);
        System.out.println("──┼───┼──");
        System.out.println(grid[7] + " | " + grid[8] + " | " + grid[9]);
    }

    public static void main(String[] args) {

        //affichageGrille();

        char p1 = 'O';
        char p2 = 'X';
        char currentPlayer = p1;
        Scanner scan = new Scanner(System.in);
        String input;

        // condition de victoire
        int lenghboard = 9; //Changer en variable avec un inconnu
        int nombreCoups = 0; //Compteur de nombre de coup
        boolean victoire = false;


        while(!victoire) {

            affichageGrille();

            int c;
            System.out.println("Player " + currentPlayer + ", hello: ");
            input = scan.nextLine();

            try {
                c = Integer.parseInt(input);
                if (1 <= c && c <= 9) {
                    if (grid[c] == ' '){
                        grid[c] = currentPlayer;
                    }
                    else {
                        System.err.println("Cette case est déjà prise");
                        continue;
                    }

                }
                else {
                    System.err.println("Veuillez rentrer un nombre entier entre 1 et 9");
                    continue;
                }

            } catch (Exception e) {
                System.err.println("Veuillez rentrer un nombre entier entre 1 et 9");
                continue;
            }
            

            if (grid[1] == grid[2] && grid[1] == grid[3] && grid[1] != ' ') {
                victoire = true;
            }

            if (grid[4] == grid[5] && grid[4] == grid[6] && grid[4] != ' ') {
                victoire = true;
            }

            if (grid[7] == grid[8] && grid[7] == grid[9] && grid[7] != ' ') {
                victoire = true;
            }

            if (grid[1] == grid[4] && grid[1] == grid[7] && grid[1] != ' ') {
                victoire = true;
            }

            if (grid[2] == grid[5] && grid[5] == grid[8] && grid[2] != ' ') {
                victoire = true;
            }

            if (grid[3] == grid[6] && grid[3] == grid[9] && grid[3] != ' ') {
                victoire = true;
            }

            if (grid[1] == grid[5] && grid[1] == grid[9] && grid[1] != ' ') {
                victoire = true;
            }

            if (grid[1] == grid[5] && grid[3] == grid[7] && grid[3] != ' ') {
                victoire = true;
            }

            nombreCoups++;
            if (nombreCoups == lenghboard){
                System.out.println("Egalité, pas de victoire");
                break;
            }
            if (currentPlayer == p1 && !victoire){
                currentPlayer = p2;
            } else {
                currentPlayer = p1;
            }
        }

        if(victoire){
            affichageGrille();
            System.out.println("Victoire de " +  currentPlayer);
        }

    }

}
