package com.codingf.morpion;

import com.codingf.morpion.classes.Cases;

import javax.print.attribute.standard.PresentationDirection;
import java.util.Scanner;

public class Jeu {

    static void affichageGrille(){
        System.out.println(" 1 | 2 | 3 ");
        System.out.println("───┼───┼───");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("───┼───┼───");
        System.out.println(" 7 | 8 | 9 ");
    }

    public static void main(String[] args) {

        affichageGrille();

        /*Cases case1 = new Cases("X", 2, 0);

        case1.setSimplePosition(case1.getxPosition(), case1.getyPosition());

        System.out.println(case1);

        Scanner symbol = new Scanner(System.in);
        System.out.println("Quel symbole ?");
        String symbole = symbol.nextLine();
        if (symbole.length() != 1){
            System.err.println("Fuck you");
        }

        case1.setSymbol(symbole);

        System.out.println(case1);*/

        // condition de victoire
        int lenghboard = 9; //Changer en variable avec un inconnu
        int nombreCoups = 0; //Compteur de nombre de coup
        boolean victoire = false;


        while(!victoire) {

            if (case1 == case2 && case1 == case3 && case1 != " ") {
                victoire = true;
            }

            if (case4 == case5 && case4 == case6 && case4 != " ") {
                victoire = true;
            }

            if (case7 == case8 && case7 == case9 && case7 != " ") {
                victoire = true;
            }

            if (case1 == case4 && case1 == case7 && case1 != " ") {
                victoire = true;
            }

            if (case2 == case5 && case5 == case8 && case2 != " ") {
                victoire = true;
            }

            if (case3 == case6 && case3 == case9 && case3 != " ") {
                victoire = true;
            }

            if (case1 == case5 && case1 == case9 && case1 != " ") {
                victoire = true;
            }

            if (case3 == case5 && case3 == case7 && case3 != " ") {
                victoire = true;
            }

            nombreCoups++;
            if (nombreCoups == lenghboard){
                System.out.println("Egalité, pas de victoire");
                break;
            }
        }

        if(victoire){
            System.out.println("Victoire de", symbole);
        }

    }

}
