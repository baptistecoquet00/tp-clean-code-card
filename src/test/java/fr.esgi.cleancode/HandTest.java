package fr.esgi.cleancode;

import fr.esgi.cleancode.card.Card;
import fr.esgi.cleancode.card.CardNumber;
import fr.esgi.cleancode.card.CardType;
import fr.esgi.cleancode.hand.Hand;
import fr.esgi.cleancode.hand.HandService;
import fr.esgi.cleancode.hand.exception.HandMaxRangeException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HandTest {

    @Nested
    class ListHand {
        @Test
        void shouldReturnPoint() {
            var handService = new HandService();
            var hands = List.of(
                    new Hand(
                            List.of(
                                    new Card(CardNumber.Two, CardType.Hearth),
                                    new Card(CardNumber.Two,CardType.Tile),
                                    new Card(CardNumber.Two,CardType.Clover),
                                    new Card(CardNumber.Nine,CardType.Spades),
                                    new Card(CardNumber.Nine,CardType.Tile)
                                    )
                    ),
                    new Hand(
                            List.of(
                                    new Card(CardNumber.Two,CardType.Hearth),
                                    new Card(CardNumber.Two,CardType.Hearth),
                                    new Card(CardNumber.King,CardType.Hearth),
                                    new Card(CardNumber.Queen,CardType.Hearth),
                                    new Card(CardNumber.Queen,CardType.Hearth)
                            )
                    ),
                    new Hand(
                            List.of(
                                    new Card(CardNumber.Three,CardType.Clover),
                                    new Card(CardNumber.Eight,CardType.Tile),
                                    new Card(CardNumber.Ten,CardType.Hearth),
                                    new Card(CardNumber.Queen,CardType.Tile),
                                    new Card(CardNumber.King,CardType.Spades)
                            )
                    )


            );

            var result = handService.ForEachHandReturnPoint(hands);
            var expected = List.of(
                    50,
                    40,
                    45
            );

            assertEquals(
                   expected, result
            );
        }

        @Test
        void listHandShouldThrowHandMaxRangeException() {


            assertThrows(HandMaxRangeException.class, () -> {
                var hand = new Hand(List.of(
                        new Card(CardNumber.Three,CardType.Clover),
                        new Card(CardNumber.Eight,CardType.Tile),
                        new Card(CardNumber.Ten,CardType.Hearth),
                        new Card(CardNumber.Queen,CardType.Tile),
                        new Card(CardNumber.King,CardType.Spades),
                        new Card(CardNumber.King,CardType.Spades)
                    )
                );
            });


        }
    }
}
