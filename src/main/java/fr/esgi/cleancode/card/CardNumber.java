package fr.esgi.cleancode.card;

public enum CardNumber {
    One(1),
    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Seven(7),
    Eight(8),
    Nine(9),
    Ten(10),
    Valet(11),
    Queen(12),
    King(13),
    As(14);

    private final int value;

    CardNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
