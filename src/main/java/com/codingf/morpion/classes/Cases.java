package com.codingf.morpion.classes;

public class Cases {

    char symbol;
    int xPosition;
    int yPosition;
    int simplePosition;

    public Cases(){}

    public Cases(char symbol, int xPosition, int yPosition) {
        this.symbol = symbol;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getSimplePosition() {
        return simplePosition;
    }

    public void setSimplePosition(int xPosition, int yPosition) {
        this.simplePosition = 3*xPosition + yPosition + 1;
    }

    @Override
    public String toString() {
        return "Cases{" +
                "symbol=" + symbol +
                ", xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                ", simplePosition=" + simplePosition +
                '}';

    }

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
