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

    }

}
