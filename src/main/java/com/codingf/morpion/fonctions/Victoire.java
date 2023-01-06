package com.codingf.morpion.fonctions;

import java.util.ArrayList;
import java.util.List;

import com.codingf.morpion.modeles.Grille;
import com.codingf.morpion.modeles.Cases;

public class Victoire {

    private Grille grille;

    private Cases[][] casesList;

    private static List<Character> symbolList = new ArrayList<>();

    private static List<List<Character>> listList = new ArrayList<>();

    //Fonction pour vérifier s'il y a une victoire dans une ligne
    public static boolean lineVictory(Grille grille, Cases[][] casesList){

        boolean lVictory = false;

        symbolList.clear();
        listList.clear();

        for (int ligne = 0; ligne<grille.getSize(); ligne++){
            for (int colonne = 0; colonne<grille.getSize(); colonne++){
                symbolList.add(casesList[ligne][colonne].getSymbol());
            }
        }

        for (int index = 0; index<grille.getSize(); index++){
            //System.out.println(symbolList.subList(gridSize*index, gridSize*(index+1)));
            listList.add(symbolList.subList(grille.getSize()*index, grille.getSize()*(index+1)));
        }

        for (int i = 0; i<listList.size(); i++){
            lVictory = listList.get(i).stream().distinct().count() <= 1 && listList.get(i).get(0) != ' ';
            if (lVictory){
                break;
            }
        }

        return lVictory;

    }

    //Fonction pour vérifier s'il y a une victoire dans une colonne
    public static boolean columnVictory(Grille grille, Cases[][] casesList){

        boolean cVictory = false;

        symbolList.clear();
        listList.clear();

        for (int ligne = 0; ligne<grille.getSize(); ligne++){
            for (int colonne = 0; colonne<grille.getSize(); colonne++){
                symbolList.add(casesList[colonne][ligne].getSymbol());
            }
        }

        for (int index = 0; index<grille.getSize(); index++){
            //System.out.println(symbolList.subList(gridSize*index, gridSize*(index+1)));
            listList.add(symbolList.subList(grille.getSize()*index, grille.getSize()*(index+1)));
        }

        for (int i = 0; i<listList.size(); i++){
            cVictory = listList.get(i).stream().distinct().count() <= 1 && listList.get(i).get(0) != ' ';
            if (cVictory){
                break;
            }
        }

        return cVictory;

    }

    //Fonction pour vérifier s'il y a une victoire dans la diagonale "haut-gauche/bas-droite"
    public static boolean leftRightDiagVictory(Grille grille, Cases[][] casesList){

        boolean lrdVictory = false;

        symbolList.clear();

        for (int ligne = 0; ligne<grille.getSize(); ligne++){
            for (int colonne = 0; colonne<grille.getSize(); colonne++){
                if (ligne == colonne) {
                    symbolList.add(casesList[ligne][colonne].getSymbol());
                }

            }
        }
        lrdVictory = symbolList.stream().distinct().count() <= 1 && symbolList.get(0) != ' ';

        return lrdVictory;

    }

    //Fonction pour vérifier s'il y a une victoire dans la diagonale "haut-droite/bas-gauche"
    public static boolean rightLeftDiagVictory(Grille grille, Cases[][] casesList){

        boolean rldVictory = false;

        symbolList.clear();

        for (int ligne = 0; ligne<grille.getSize(); ligne++){
            for (int colonne = 0; colonne<grille.getSize(); colonne++){
                if (ligne + colonne == grille.getSize()-1) {
                    symbolList.add(casesList[ligne][colonne].getSymbol());
                }
            }
        }

        rldVictory = symbolList.stream().distinct().count() <= 1 && symbolList.get(0) != ' ';

        return rldVictory;

    }
    
}
