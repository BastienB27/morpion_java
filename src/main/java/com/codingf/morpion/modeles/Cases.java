package com.codingf.morpion.modeles;

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

    @Override
    public String toString() {
        return "Cases{" +
                "symbol=" + symbol +
                ", xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                ", simplePosition=" + simplePosition +
                '}';

    }

}
