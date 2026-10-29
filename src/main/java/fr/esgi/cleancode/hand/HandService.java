package fr.esgi.cleancode.hand;

import fr.esgi.cleancode.card.Card;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HandService {

    public List<Integer> ForEachHandReturnPoint(List<Hand> hands) {
        return hands.stream()
                .map(hand -> evaluate(hand).getPoints())
                .toList();
    }

    HandCombination evaluate(Hand hand) {
        var counts = hand.cards().stream()
                .collect(Collectors.groupingBy(Card::cardNumber, Collectors.counting()))
                .values();
        var flush = hand.cards().stream().map(Card::type).distinct().count() == 1;

        if (counts.contains(3L) && counts.contains(2L)) return HandCombination.FULL_HOUSE;
        if (flush) return HandCombination.FLUSH;
        return HandCombination.HIGH_CARD;
    }
}
