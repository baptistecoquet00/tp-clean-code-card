package fr.esgi.cleancode.hand;

import fr.esgi.cleancode.card.Card;
import fr.esgi.cleancode.hand.exception.HandMaxRangeException;
import fr.esgi.cleancode.hand.exception.NotMinSizeHandException;

import java.util.List;
import java.util.Objects;

public record Hand(
        List<Card> cards
) {
    private static final int MIN_SIZE = 5;
    private static final int MAX_SIZE = 5;

    public Hand {
        Objects.requireNonNull(cards, "La main ne peut pas être null");

        if (cards.size() < MIN_SIZE) {
            throw new NotMinSizeHandException(
                    "Une main doit contenir au moins " + MIN_SIZE + " cartes, reçu : " + cards.size());
        }
        if (cards.size() > MAX_SIZE) {
            throw new HandMaxRangeException(
                    "Une main ne peut pas contenir plus de " + MAX_SIZE + " cartes, reçu : " + cards.size());
        }

        cards = List.copyOf(cards);
    }
}
