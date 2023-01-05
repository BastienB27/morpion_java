package com.codingf.morpion;

import com.codingf.morpion.classes.Cases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Jeu {

    static int gridSize;

    //Liste d'objets Cases qui regroupe les informations de toutes les cases
    //static List<Cases> casesList = new ArrayList<>();
    static Cases[][] casesList = new Cases[5][5];

    //Fonction pour afficher la grille
    static void affichageGrille(){
        System.out.print("  ");
        for(int i = 1; i<=gridSize; i++){
            System.out.print("   " + i);
        }

        System.out.println();
        System.out.print("   ╔");
        for(int i = 1; i<gridSize; i++){
            System.out.print("═══╦");
        }
        System.out.println("═══╗");

        for(int i = 0 ;i<gridSize; i++){
            System.out.print(" " + (i+1) + " ║ ");
            //System.out.print(" ║ ");
            for(int j = 0; j<gridSize ;j++){
                //System.out.println(casesList[i][j]);
                System.out.print(casesList[i][j].getSymbol() + " ║ ");
            }
            System.out.println();
            if(i == gridSize-1){
                continue;
            }
            System.out.print("   ╠");
            for(int j = 0; j<gridSize-1; j++){
                System.out.print("═══╬");
            }
            System.out.println("═══╣");
        }

        System.out.print("   ╚");
        for(int i = 1; i<gridSize; i++){
            System.out.print("═══╩");
        }
        System.out.println("═══╝");

        /*System.out.println(" 1 ║ " + casesList[0][0].getSymbol() + " ║ " + casesList[0][1].getSymbol() + " ║ " + casesList[0][2].getSymbol() + " ║ ");
        System.out.println("   ╠═══╬═══╬═══╣");
        System.out.println(" 2 ║ " + casesList[1][0].getSymbol() + " ║ " + casesList[1][1].getSymbol() + " ║ " + casesList[1][2].getSymbol() + " ║ ");
        System.out.println("   ╠═══╬═══╬═══╣");
        System.out.println(" 3 ║ " + casesList[2][0].getSymbol() + " ║ " + casesList[2][1].getSymbol() + " ║ " + casesList[2][2].getSymbol() + " ║ ");*/
        //System.out.println("   ╚═══╩═══╩═══╝");
    }

    static List<Character> symbolList = new ArrayList<>();

    static List<List<Character>> listList = new ArrayList<>();

    static void lineVictory(){

        symbolList.clear();
        listList.clear();

            for (int ligne = 0; ligne<gridSize; ligne++){
                for (int colonne = 0; colonne<gridSize; colonne++){
                    symbolList.add(casesList[ligne][colonne].getSymbol());
                }
            }

        for (int index = 0; index<gridSize; index++){
            //System.out.println(symbolList.subList(gridSize*index, gridSize*(index+1)));
            listList.add(symbolList.subList(gridSize*index, gridSize*(index+1)));
        }
    }

    static void columnVictory(){

        symbolList.clear();
        listList.clear();

        for (int ligne = 0; ligne<gridSize; ligne++){
            for (int colonne = 0; colonne<gridSize; colonne++){
                symbolList.add(casesList[colonne][ligne].getSymbol());
            }
        }

        for (int index = 0; index<gridSize; index++){
            //System.out.println(symbolList.subList(gridSize*index, gridSize*(index+1)));
            listList.add(symbolList.subList(gridSize*index, gridSize*(index+1)));
        }
    }

    static void leftRightDiagVictory(){

        symbolList.clear();

        for (int ligne = 0; ligne<gridSize; ligne++){
            for (int colonne = 0; colonne<gridSize; colonne++){
                if (ligne == colonne) {
                    symbolList.add(casesList[ligne][colonne].getSymbol());
                }

            }
        }

    }

    static void rightLeftDiagVictory(){

        symbolList.clear();

        for (int ligne = 0; ligne<gridSize; ligne++){
            for (int colonne = 0; colonne<gridSize; colonne++){
                if (ligne + colonne == gridSize-1) {
                    symbolList.add(casesList[ligne][colonne].getSymbol());
                }
            }
        }

    }




    public static void main(String[] args) {

        //On demande les pseudos des joueurs
        Scanner scan = new Scanner(System.in);
        System.out.println("Joueur 1, choisissez votre pseudo");
        String player1Name = scan.nextLine();
        System.out.println("Joueur 2, choisissez votre pseudo");
        String player2Name = scan.nextLine();
        System.out.println();

        Scanner askGridSize = new Scanner(System.in);
        System.out.println("Quelle taille de grille voulez-vous ?");
        gridSize = askGridSize.nextInt();
        System.out.println(gridSize);

        //Création des cases avec leurs indices
        for(int i = 0; i<gridSize; i++){
            for(int j = 0; j<gridSize; j++){
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

        int lenghboard = casesList.length*casesList.length; // Nombre total de cases
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
        while(!victoire) {

            affichageGrille();

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
            }
            catch (Exception e){
                System.out.println("Veuillez respecter le format demandé : ligne,colonne");
                continue;
            }


            int l;
            int c;
            try {
                l = Integer.parseInt(lineInput)-1;
                c = Integer.parseInt(columnInput)-1;
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
                    System.out.println(input + " n'est pas un nombre valable");
                    System.out.println("Veuillez rentrer deux nombres entiers entre 1 et la taille de la grille");
                    continue;
                }

            }
            catch (Exception e) {
                System.out.println(input + " n'est pas une coordonnée valide");
                System.out.println("Veuillez rentrer deux nombres entiers entre 1 et la taille de la grille");
                continue;
            }

            //boolean conditionDeVictoire = false;

            /*for (int size = 0; size<gridSize; size++){
                for (int ligne = 0; ligne<gridSize; ligne++){
                    for (int colonne = 0; colonne<gridSize; colonne++){
                        System.out.println(gridSize);
                        System.out.println(casesList[ligne][colonne].getSymbol() + " symbol ligne " + ligne + " colonne " + colonne);
                        System.out.println(casesList[ligne][size].getSymbol());
                        if (casesList[ligne][colonne].getSymbol() == casesList[ligne][size].getSymbol() || casesList[ligne][colonne].getSymbol() != ' '){
                            conditionDeVictoire = true;
                            boolean allEqual = Arrays.stream(casesList).distinct().count() <= 1;
                        }
                    }
                }
            }*/

            //La liste des conditions de victoire

            //boolean allEqual = false;
            boolean lVictory = false;
            boolean cVictory = false;
            boolean lrdVictory = false;
            boolean rldVictory = false;


            lineVictory();
            //System.out.println(symbolList + " lines");
            System.out.println(listList + " lines");

            for (int i = 0; i<listList.size(); i++){
                lVictory = listList.get(i).stream().distinct().count() <= 1 && listList.get(i).get(0) != ' ';
                if (lVictory){
                    break;
                }
            }

            columnVictory();
            //System.out.println(symbolList + " columns");
            System.out.println(listList + " columns");
            for (int i = 0; i<listList.size(); i++){
                cVictory = listList.get(i).stream().distinct().count() <= 1 && listList.get(i).get(0) != ' ';
                if (cVictory){
                    break;
                }
            }

            leftRightDiagVictory();
            System.out.println(symbolList + " lr diag");

            lrdVictory = symbolList.stream().distinct().count() <= 1 && symbolList.get(0) != ' ';

            rightLeftDiagVictory();
            System.out.println(symbolList + " rl diag");

            rldVictory = symbolList.stream().distinct().count() <= 1 && symbolList.get(0) != ' ';

            if  (lVictory || cVictory || lrdVictory || rldVictory){
                victoire = true;
            }



            /*if (casesList[0][0].getSymbol() == casesList[0][1].getSymbol() &&
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
                    casesList[0][1].getSymbol() == casesList[2][1].getSymbol() &&
                    casesList[0][1].getSymbol() != ' ') {
                victoire = true;
            }

            if (casesList[0][2].getSymbol() == casesList[1][2].getSymbol() &&
                    casesList[0][2].getSymbol() == casesList[2][2].getSymbol() &&
                    casesList[0][2].getSymbol() != ' ') {
                victoire = true;
            }

            /*if (casesList[0][0].getSymbol() == casesList[1][1].getSymbol() &&
                    casesList[0][0].getSymbol() == casesList[2][2].getSymbol() &&
                    casesList[0][0].getSymbol() != ' ') {
                victoire = true;
            }

            if (casesList[0][2].getSymbol() == casesList[1][1].getSymbol() &&
                    casesList[0][2].getSymbol() == casesList[2][0].getSymbol() &&
                    casesList[0][2].getSymbol() != ' ') {
                victoire = true;
            }*/

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
