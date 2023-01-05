package com.codingf.morpion;

import com.codingf.morpion.classes.Cases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {

    //Liste d'objets Cases qui regroupe les informations de toutes les cases
    static List<Cases> casesList = new ArrayList<>();

    //Fonction pour afficher la grille
    static void affichageGrille(){
        System.out.println(casesList.get(1).getSymbol() + " | " + casesList.get(2).getSymbol() + " | " + casesList.get(3).getSymbol());
        System.out.println("──┼───┼──");
        System.out.println(casesList.get(4).getSymbol() + " | " + casesList.get(5).getSymbol() + " | " + casesList.get(6).getSymbol());
        System.out.println("──┼───┼──");
        System.out.println(casesList.get(7).getSymbol() + " | " + casesList.get(8).getSymbol() + " | " + casesList.get(9).getSymbol());
    }

    public static void main(String[] args) {

        //Case blanche pour pouvoir commencer les index des vraies cases à 1
        Cases blank = new Cases();
        casesList.add(blank);

        //Création des cases avec leurs indices
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                Cases square = new Cases(' ', i, j);
                square.setSimplePosition(i, j);
                casesList.add(square);
            }
        }

        //On demande les pseudos des joueurs
        Scanner scan = new Scanner(System.in);
        System.out.println("Joueur 1, choisissez votre pseudo");
        String player1Name = scan.nextLine();
        System.out.println("Joueur 2, choisissez votre pseudo");
        String player2Name = scan.nextLine();

        char p1 = 'O';
        char p2 = 'X';
        char currentPlayerSymbol = p1;
        String currentPlayer = player1Name;

        String input;

        int lenghboard = casesList.size()-1; // Nombre total de cases
        int nombreCoups = 0; // Compteur du nombre de coups joués
        boolean victoire = false;

        //Explication de l'agencement des cases et de ce que les joueurs devront faire
        System.out.println(" 1 | 2 | 3 ");
        System.out.println("───┼───┼───");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("───┼───┼───");
        System.out.println(" 7 | 8 | 9 ");
        System.out.println("Vous devrez entrer le nombre correspondant à la case sur laquelle vous voulez placer votre symbole \n \n");

        //Boucle principale du jeu
        while(!victoire) {

            affichageGrille();

            //On demande au joueur de placer son symbole de la grille
            System.out.println("Au tour de " + currentPlayer + " de jouer (symbole " + p1 + ")");
            System.out.println("Choisissez une case entre 1 et 9");
            input = scan.nextLine();

            int c;
            try {
                c = Integer.parseInt(input);
                //Si le nombre entré est correct et que la case est bien vide, on place le symbole du joueur
                if (1 <= c && c <= 9) {
                    if (casesList.get(c).getSymbol() == ' '){
                        casesList.get(c).setSymbol(currentPlayerSymbol);
                    }
                    else {
                        //On affiche une erreur si la case sélectionné est déjà prise
                        System.out.println("Cette case est déjà prise");
                        continue;
                    }

                }
                else {
                    //On affiche une erreur si le joueur sélectionne un nombre inférieur ou supérieur au nombre de cases
                    System.out.println(input + " n'est pas un nombre correct");
                    System.out.println("Veuillez rentrer un nombre entier entre 1 et 9");
                    continue;
                }

            }
            catch (Exception e) {
                System.out.println(input + " n'est pas un nombre");
                System.out.println("Veuillez rentrer un nombre entier entre 1 et 9");
                continue;
            }


            //La liste des conditions de victoire
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

            //Si le nombre de coups est égal au nombre de cases, il y a égalité
            if (nombreCoups == lenghboard){
                affichageGrille();
                System.out.println("Egalité, pas de victoire");
                break;
            }

            if (currentPlayerSymbol == p1 && !victoire){
                currentPlayerSymbol = p2;
                currentPlayer = player2Name;
            } else if (currentPlayerSymbol == p2 && !victoire) {
                currentPlayerSymbol = p1;
                currentPlayer = player1Name;
            }
        }

        if(victoire){
            affichageGrille();
            System.out.println("Victoire de " + currentPlayer);
        }

    }

}
