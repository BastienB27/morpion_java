package com.codingf.morpion.classes;

public class Cases {

    String symbol;
    int xPosition;
    int yPosition;
    int simplePosition;

    public Cases(){}

    public Cases(String symbol, int xPosition, int yPosition) {
        this.symbol = symbol;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
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
}
