package com.codingf.morpion;

import com.codingf.morpion.classes.Cases;
import com.codingf.morpion.classes.Grille;
import com.codingf.morpion.fonctions.Victoire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Jeu {

    public static void main(String[] args) {

        while(true) {

            Grille grille;
            Cases[][] casesList = new Cases[10][10];

            //On demande les pseudos des joueurs
            Scanner scan = new Scanner(System.in);
            System.out.println("Joueur 1, choisissez votre pseudo");
            String player1Name = scan.nextLine();
            System.out.println("Joueur 2, choisissez votre pseudo");
            String player2Name = scan.nextLine();
            System.out.println();

            Scanner askGridSize = new Scanner(System.in);
            System.out.println("Quelle taille de grille voulez-vous ?");
            //gridSize = askGridSize.nextInt();
            //System.out.println(gridSize);
            grille = new Grille(askGridSize.nextInt(), casesList);

            //Création des cases avec leurs indices
            for (int i = 0; i < grille.getSize(); i++) {
                for (int j = 0; j < grille.getSize(); j++) {
                    Cases square = new Cases(' ', i, j);
                    square.setSimplePosition(i, j);
                    casesList[i][j] = square;
                }
            }

            char p1 = 'O';
            char p2 = 'X';
            char currentPlayerSymbol = p1;
            String currentPlayer = player1Name;

            String input;

            int lenghboard = grille.getSize() * grille.getSize(); // Nombre total de cases
            System.out.println(casesList.length);
            System.out.println(lenghboard);
            int nombreCoups = 0; // Compteur du nombre de coups joués
            boolean victoire = false;

            //Explication de l'agencement des cases et de ce que les joueurs devront faire
        /*System.out.println("╔═══╦═══╦═══╗");
        System.out.println("║ 1 ║ 2 ║ 3 ║");
        System.out.println("╠═══╬═══╬═══╣");
        System.out.println("║ 4 ║ 5 ║ 6 ║");
        System.out.println("╠═══╬═══╬═══╣");
        System.out.println("║ 7 ║ 8 ║ 9 ║");
        System.out.println("╚═══╩═══╩═══╝");*/
            System.out.println("Vous devrez entrer les coordonnées correspondant à la case sur laquelle vous voulez placer votre symbole \n");

            //Boucle principale du jeu
            while (!victoire) {

                grille.affichageGrille();

                //On demande au joueur de placer son symbole de la grille
                System.out.println("Au tour de " + currentPlayer + " de jouer (symbole " + currentPlayerSymbol + ")");
                //System.out.println("Choisissez une case entre 1 et 9");
                System.out.println("Choisissez une ligne et une colonne (ligne,colonne)");
                input = scan.nextLine();
                String lineInput;
                String columnInput;
                try {
                    String[] inputResult = input.split(",");
                    lineInput = inputResult[0];
                    columnInput = inputResult[1];
                } catch (Exception e) {
                    System.out.println("Veuillez respecter le format demandé : ligne,colonne");
                    continue;
                }

                int l;
                int c;
                try {
                    l = Integer.parseInt(lineInput) - 1;
                    c = Integer.parseInt(columnInput) - 1;
                    //Si le nombre entré est correct et que la case est bien vide, on place le symbole du joueur
                    if (0 <= l && l <= grille.getSize() - 1) {
                        if (0 <= c && c <= grille.getSize() - 1) {
                            if (casesList[l][c].getSymbol() == ' ') {
                                System.out.println("ligne : " + l + " colonne : " + c);
                                casesList[l][c].setSymbol(currentPlayerSymbol);
                            } else {
                                //On affiche une erreur si la case sélectionné est déjà prise
                                System.out.println("Cette case est déjà prise");
                                continue;
                            }
                        }

                    } else {
                        //On affiche une erreur si le joueur sélectionne un nombre inférieur ou supérieur au nombre de lignes/colonnes
                        System.out.println(input + " n'est pas un nombre valable");
                        System.out.println("Veuillez rentrer deux nombres entiers entre 1 et la taille de la grille");
                        continue;
                    }

                } catch (Exception e) {
                    System.out.println(input + " n'est pas une coordonnée valide");
                    System.out.println("Veuillez rentrer deux nombres entiers entre 1 et la taille de la grille");
                    continue;
                }

                //La liste des conditions de victoire

                if (Victoire.lineVictory(grille, casesList) || Victoire.columnVictory(grille, casesList) || Victoire.leftRightDiagVictory(grille, casesList) || Victoire.rightLeftDiagVictory(grille, casesList)) {
                    victoire = true;
                }

                nombreCoups++;

                //Si le nombre de coups est égal au nombre de cases, il y a égalité
                if (nombreCoups == lenghboard) {
                    grille.affichageGrille();
                    System.out.println("Egalité, pas de victoire");
                    break;
                }

                if (currentPlayerSymbol == p1 && !victoire) {
                    currentPlayerSymbol = p2;
                    currentPlayer = player2Name;
                } else if (currentPlayerSymbol == p2 && !victoire) {
                    currentPlayerSymbol = p1;
                    currentPlayer = player1Name;
                }
            }

            if (victoire) {
                grille.affichageGrille();
                System.out.println("Victoire de " + currentPlayer);
                Scanner nb = new Scanner(System.in);
                System.out.println("Voulez-vous rejouer ? O (oui)/N (non)");
                String answer = nb.nextLine();
                if (answer.equals("O") || answer.equals("o")) {
                    System.out.println("Ok, jouons encore une fois !");
                    for (int k = 0; k < grille.getSize(); k++) {
                        for (int g = 0; g < grille.getSize(); g++){
                            casesList[k][g].setSymbol(' ');
                        }
                    }
                    continue;
                } else if (answer.equals("N") || answer.equals("n")) {
                    System.out.println("Merci d'avoir joué au morpion !");
                    break;
                } else {
                    break;
                }
            }

        }
    }

}
