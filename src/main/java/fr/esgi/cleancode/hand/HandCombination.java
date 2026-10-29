package fr.esgi.cleancode.hand;

public enum HandCombination {
    STRAIGHT_FLUSH(90),
    FOUR_OF_A_KIND(80),
    FULL_HOUSE(50),
    FLUSH(40),
    STRAIGHT(35),
    THREE_OF_A_KIND(30),
    TWO_PAIR(20),
    ONE_PAIR(10),
    HIGH_CARD(45);

    private final int points;

    HandCombination(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
