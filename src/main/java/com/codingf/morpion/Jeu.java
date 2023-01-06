package com.codingf.morpion;

import com.codingf.morpion.modeles.Cases;
import com.codingf.morpion.modeles.Grille;
import com.codingf.morpion.fonctions.Victoire;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Jeu {

    public static void main(String[] args) {

        while(true) {

            Grille grille;
            Cases[][] casesList = new Cases[9][9];
            char player2Symbol;
            List<String> historique = new ArrayList<>();

            //On demande les pseudos et les symboles des joueurs
            Scanner scan = new Scanner(System.in);
            System.out.println("Joueur 1, choisissez votre pseudo");
            String player1Name = scan.nextLine();
            System.out.println("Joueur 1, choisissez votre symbole");
            char player1Symbol = scan.nextLine().charAt(0);

            System.out.println("Joueur 2, choisissez votre pseudo");
            String player2Name = scan.nextLine();

            while (true){
                //On fait en sorte que les deux joueurs ne choisissent pas le même symbole
                System.out.println("Joueur 2, choisissez votre symbole");
                player2Symbol = scan.nextLine().charAt(0);
                if (player1Symbol == player2Symbol){
                    System.out.println("Les deux joueurs ne peuvent pas avoir le même symbole");
                }
                else {
                    System.out.println();
                    break;
                }
                System.out.println();
            }

            while(true) {

                //On demande au joueur la taille de la grille
                Scanner askGridSize = new Scanner(System.in);
                System.out.println("Quelle taille de grille voulez-vous (Entre 3 et 9)?");

                try {
                    grille = new Grille(askGridSize.nextInt(), casesList);
                    if(grille.getSize() < 3 || grille.getSize() > 9){
                        System.out.println("La taille de la grille doit être comprise entre 3 et 9.");
                    }
                    else {
                        break;
                    }

                }
                //Si le joueur ne choisit pas un nombre, on redemande la taille
                catch (Exception e) {
                    System.out.println("Choisissez un nombre et non une lettre ou symbole");
                }
            }

            historique.add("Partie entre " + player1Name + " (" + player1Symbol + ") et " + player2Name + " (" + player2Symbol +  ") sur une grille de " + grille.getSize() + "*" + grille.getSize());

            LocalDateTime gameTime = LocalDateTime.now();

            String formattedDate = gameTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String formattedTime = gameTime.format(DateTimeFormatter.ofPattern("HH:mm"));
            historique.add("Partie jouée le " + formattedDate + " à " + formattedTime);

            //Création des cases avec leurs indices
            for (int i = 0; i < grille.getSize(); i++) {
                for (int j = 0; j < grille.getSize(); j++) {
                    Cases square = new Cases(' ', i, j);
                    casesList[i][j] = square;
                }
            }

            char p1 = 'O';
            char p2 = 'X';
            char currentPlayerSymbol = player1Symbol;
            String currentPlayer = player1Name;

            String input;

            int lenghboard = grille.getSize() * grille.getSize(); // Nombre total de cases
            int nombreCoups = 0; // Compteur du nombre de coups joués
            boolean victoire = false;

            System.out.println("Vous devrez entrer les coordonnées correspondant à la case sur laquelle vous voulez placer votre symbole \n");

            //Boucle principale du jeu
            while (!victoire) {

                grille.affichageGrille();

                //On demande au joueur de placer son symbole de la grille
                System.out.println("Au tour de " + currentPlayer + " de jouer (symbole " + currentPlayerSymbol + ")");
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
                                casesList[l][c].setSymbol(currentPlayerSymbol);
                                historique.add(currentPlayer + " a joué " + currentPlayerSymbol + " en " + l + "," + c);
                            }
                            else {
                                //On affiche une erreur si la case sélectionné est déjà prise
                                System.out.println("Cette case est déjà prise");
                                continue;
                            }
                        }
                        else {
                            //On affiche une erreur si le joueur sélectionne un nombre inférieur ou supérieur au nombre de lignes/colonnes
                            System.out.println(input + " n'est pas un nombre valable");
                            System.out.println("Veuillez rentrer deux nombres entiers entre 1 et la taille de la grille");
                            continue;
                        }

                    }
                    else {
                        //On affiche une erreur si le joueur sélectionne un nombre inférieur ou supérieur au nombre de lignes/colonnes
                        System.out.println(input + " n'est pas un nombre valable");
                        System.out.println("Veuillez rentrer deux nombres entiers entre 1 et la taille de la grille");
                        continue;
                    }

                }
                catch (Exception e) {
                    //On affiche une erreur si le joueur sélectionne autre chose qu'un nombre
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
                    historique.add("Egalité, pas de victoire");
                    break;
                }

                if (currentPlayerSymbol == player1Symbol && !victoire) {
                    currentPlayerSymbol = player2Symbol;
                    currentPlayer = player2Name;
                } else if (currentPlayerSymbol == player2Symbol && !victoire) {
                    currentPlayerSymbol = player1Symbol;
                    currentPlayer = player1Name;
                }
            }

            if (victoire) {
                grille.affichageGrille();
                System.out.println("Victoire de " + currentPlayer + "\n");
                historique.add("Victoire de " + currentPlayer + "\n\n");
            }

            try {
                BufferedWriter sortie = new BufferedWriter(new FileWriter("historique.txt", true));
                for (int i = 0; i<historique.size(); i++){
                    sortie.write(historique.get(i) + "\n");
                }
                sortie.close();
            }
            catch (IOException e){
                System.out.println("Ce fichier n'existe pas");
            }


            System.out.println();

            //Option pour recommencer une partie
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
            } else if (answer.equals("N") || answer.equals("n")) {
                System.out.println("Merci d'avoir joué au morpion !");
                break;
            } else {
                break;
            }

        }
    }

}
