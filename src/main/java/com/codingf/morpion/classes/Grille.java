package com.codingf.morpion.classes;

import com.codingf.morpion.classes.Cases;

import java.util.List;

public class Grille {

    private int size;

    private Cases[][] list ;

    public Grille(int size, Cases[][] list) {
        this.size = size;
        this.list = list;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Cases[][] getList() {
        return list;
    }

    public void setList(Cases[][] list) {
        this.list = list;
    }


    public void affichageGrille(){
        System.out.print("  ");
        for(int i = 1; i<=this.size; i++){
            System.out.print("   " + i);
        }

        System.out.println();
        System.out.print("   ╔");
        for(int i = 1; i<this.size; i++){
            System.out.print("═══╦");
        }
        System.out.println("═══╗");

        for(int i = 0 ;i<this.size; i++){
            System.out.print(" " + (i+1) + " ║ ");
            //System.out.print(" ║ ");
            for(int j = 0; j<this.size ;j++){
                //System.out.println(casesList[i][j]);
                System.out.print(this.list[i][j].getSymbol() + " ║ ");
            }
            System.out.println();
            if(i == this.size-1){
                continue;
            }
            System.out.print("   ╠");
            for(int j = 0; j<this.size-1; j++){
                System.out.print("═══╬");
            }
            System.out.println("═══╣");
        }

        System.out.print("   ╚");
        for(int i = 1; i<this.size; i++){
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


}
