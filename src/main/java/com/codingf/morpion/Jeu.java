package com.codingf.morpion;

import com.codingf.morpion.classes.Cases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {

    //static int gridSize;

    //Liste d'objets Cases qui regroupe les informations de toutes les cases
    //static List<Cases> casesList = new ArrayList<>();
    static Cases[][] casesList = new Cases[3][3];

    //Fonction pour afficher la grille
    static void affichageGrille(){
        System.out.println("     1   2   3");
        System.out.println("   ╔═══╦═══╦═══╗");
        System.out.println(" 1 ║ " + casesList[0][0].getSymbol() + " ║ " + casesList[0][1].getSymbol() + " ║ " + casesList[0][2].getSymbol() + " ║ ");
        System.out.println("   ╠═══╬═══╬═══╣");
        System.out.println(" 2 ║ " + casesList[1][0].getSymbol() + " ║ " + casesList[1][1].getSymbol() + " ║ " + casesList[1][2].getSymbol() + " ║ ");
        System.out.println("   ╠═══╬═══╬═══╣");
        System.out.println(" 3 ║ " + casesList[2][0].getSymbol() + " ║ " + casesList[2][1].getSymbol() + " ║ " + casesList[2][2].getSymbol() + " ║ ");
        System.out.println("   ╚═══╩═══╩═══╝");
    }

    public static void main(String[] args) {

        //Création des cases avec leurs indices
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                Cases square = new Cases(' ', i, j);
                square.setSimplePosition(i, j);
                casesList[i][j] = square;
            }
        }

        //On demande les pseudos des joueurs
        Scanner scan = new Scanner(System.in);
        System.out.println("Joueur 1, choisissez votre pseudo");
        String player1Name = scan.nextLine();
        System.out.println("Joueur 2, choisissez votre pseudo");
        String player2Name = scan.nextLine();
        System.out.println();

        char p1 = 'O';
        char p2 = 'X';
        char currentPlayerSymbol = p1;
        String currentPlayer = player1Name;

        String input;

        int lenghboard = casesList.length*casesList.length; // Nombre total de cases
        int nombreCoups = 0; // Compteur du nombre de coups joués
        boolean victoire = false;

        //Explication de l'agencement des cases et de ce que les joueurs devront faire
        System.out.println("╔═══╦═══╦═══╗");
        System.out.println("║ 1 ║ 2 ║ 3 ║");
        System.out.println("╠═══╬═══╬═══╣");
        System.out.println("║ 4 ║ 5 ║ 6 ║");
        System.out.println("╠═══╬═══╬═══╣");
        System.out.println("║ 7 ║ 8 ║ 9 ║");
        System.out.println("╚═══╩═══╩═══╝");
        System.out.println("Vous devrez entrer le nombre correspondant à la case sur laquelle vous voulez placer votre symbole \n");

        //Boucle principale du jeu
        while(!victoire) {

            affichageGrille();

            //On demande au joueur de placer son symbole de la grille
            System.out.println("Au tour de " + currentPlayer + " de jouer (symbole " + p1 + ")");
            //System.out.println("Choisissez une case entre 1 et 9");
            System.out.println("Choisissez une ligne et une colonne (ligne,colonne)");
            input = scan.nextLine();
            String ligne;
            String colonne;
            try {
                String[] inputResult = input.split(",");
                ligne = inputResult[0];
                colonne = inputResult[1];
            }
            catch (Exception e){
                System.out.println("Veuillez respecter le format demandé : ligne,colonne");
                continue;
            }


            int l;
            int c;
            try {
                l = Integer.parseInt(ligne)-1;
                c = Integer.parseInt(colonne)-1;
                //Si le nombre entré est correct et que la case est bien vide, on place le symbole du joueur
                if (0 <= l && l <= 3) {
                    if (0 <= c && c <= 3) {
                        if (casesList[l][c].getSymbol() == ' '){
                            casesList[l][c].setSymbol(currentPlayerSymbol);
                        }
                        else {
                            //On affiche une erreur si la case sélectionné est déjà prise
                            System.out.println("Cette case est déjà prise");
                            continue;
                        }
                    }



                }
                else {
                    //On affiche une erreur si le joueur sélectionne un nombre inférieur ou supérieur au nombre de lignes/colonnes
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
            if (casesList[0][0].getSymbol() == casesList[0][1].getSymbol() &&
                    casesList[0][0].getSymbol() == casesList[0][2].getSymbol() &&
                    casesList[0][0].getSymbol() != ' ') {
                victoire = true;
            }

            if (casesList[1][0].getSymbol() == casesList[1][1].getSymbol() &&
                    casesList[1][0].getSymbol() == casesList[1][2].getSymbol() &&
                    casesList[1][0].getSymbol() != ' ') {
                victoire = true;
            }

            if (casesList[2][0].getSymbol() == casesList[2][1].getSymbol() &&
                    casesList[2][0].getSymbol() == casesList[2][2].getSymbol() &&
                    casesList[2][0].getSymbol() != ' ') {
                victoire = true;
            }

            if (casesList[0][0].getSymbol() == casesList[1][0].getSymbol() &&
                    casesList[0][0].getSymbol() == casesList[2][0].getSymbol() &&
                    casesList[0][0].getSymbol() != ' ') {
                victoire = true;
            }

            if (casesList[0][1].getSymbol() == casesList[1][1].getSymbol() &&
                    casesList[0][1].getSymbol() == casesList[1][1].getSymbol() &&
                    casesList[0][1].getSymbol() != ' ') {
                victoire = true;
            }

            if (casesList[0][2].getSymbol() == casesList[1][2].getSymbol() &&
                    casesList[0][2].getSymbol() == casesList[2][2].getSymbol() &&
                    casesList[0][2].getSymbol() != ' ') {
                victoire = true;
            }

            if (casesList[0][0].getSymbol() == casesList[1][1].getSymbol() &&
                    casesList[0][0].getSymbol() == casesList[2][2].getSymbol() &&
                    casesList[0][0].getSymbol() != ' ') {
                victoire = true;
            }

            if (casesList[0][2].getSymbol() == casesList[1][1].getSymbol() &&
                    casesList[0][2].getSymbol() == casesList[2][0].getSymbol() &&
                    casesList[0][2].getSymbol() != ' ') {
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
