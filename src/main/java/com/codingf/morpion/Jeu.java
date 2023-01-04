package com.codingf.morpion;

import com.codingf.morpion.classes.Cases;

import javax.print.attribute.standard.PresentationDirection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {

    static List<Cases> casesList = new ArrayList<>();

    static char[] grid =
            {
                ' ',
                ' ', ' ', ' ',
                ' ', ' ', ' ',
                ' ', ' ', ' '
            };

    static void affichageGrille(){
        /*System.out.println(" 1 | 2 | 3 ");
        System.out.println("───┼───┼───");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("───┼───┼───");
        System.out.println(" 7 | 8 | 9 ");*/
        System.out.println(casesList.get(1).getSymbol() + " | " + casesList.get(2).getSymbol() + " | " + casesList.get(3).getSymbol());
        System.out.println("──┼───┼──");
        System.out.println(casesList.get(4).getSymbol() + " | " + casesList.get(5).getSymbol() + " | " + casesList.get(6).getSymbol());
        System.out.println("──┼───┼──");
        System.out.println(casesList.get(7).getSymbol() + " | " + casesList.get(8).getSymbol() + " | " + casesList.get(9).getSymbol());
    }

    public static void main(String[] args) {

        //List<Cases> casesList = new ArrayList<>();

        Cases blank = new Cases();

        casesList.add(blank);

        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                Cases square = new Cases(' ', i, j);
                square.setSimplePosition(i, j);
                //System.out.println(square);
                casesList.add(square);
            }
        }

        //System.out.println(casesList + "\n");

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
                    if (casesList.get(c).getSymbol() == ' '){
                        casesList.get(c).setSymbol(currentPlayer);
                        //grid[c] = currentPlayer;
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
            

            if (casesList.get(1).getSymbol() == casesList.get(2).getSymbol() &&
                    casesList.get(1).getSymbol() == casesList.get(3).getSymbol() &&
                    casesList.get(1).getSymbol() != ' ') {
                victoire = true;
            }

            if (casesList.get(4).getSymbol() == casesList.get(5).getSymbol() &&
                    casesList.get(4).getSymbol() == casesList.get(6).getSymbol() &&
                    casesList.get(4).getSymbol() != ' ') {
                victoire = true;
            }

            if (casesList.get(7).getSymbol() == casesList.get(8).getSymbol() &&
                    casesList.get(7).getSymbol() == casesList.get(9).getSymbol() &&
                    casesList.get(7).getSymbol() != ' ') {
                victoire = true;
            }

            if (casesList.get(1).getSymbol() == casesList.get(4).getSymbol() &&
                    casesList.get(1).getSymbol() == casesList.get(7).getSymbol() &&
                    casesList.get(1).getSymbol() != ' ') {
                victoire = true;
            }

            if (casesList.get(2).getSymbol() == casesList.get(5).getSymbol() &&
                    casesList.get(2).getSymbol() == casesList.get(8).getSymbol() &&
                    casesList.get(2).getSymbol() != ' ') {
                victoire = true;
            }

            if (casesList.get(3).getSymbol() == casesList.get(6).getSymbol() &&
                    casesList.get(3).getSymbol() == casesList.get(9).getSymbol() &&
                    casesList.get(3).getSymbol() != ' ') {
                victoire = true;
            }

            if (casesList.get(1).getSymbol() == casesList.get(5).getSymbol() &&
                    casesList.get(1).getSymbol() == casesList.get(9).getSymbol() &&
                    casesList.get(1).getSymbol() != ' ') {
                victoire = true;
            }

            if (casesList.get(3).getSymbol() == casesList.get(5).getSymbol() &&
                    casesList.get(3).getSymbol() == casesList.get(7).getSymbol() &&
                    casesList.get(3).getSymbol() != ' ') {
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
