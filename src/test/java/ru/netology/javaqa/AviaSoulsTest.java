package ru.netology.javaqa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class AviaSoulsTest {

    AviaSouls souls = new AviaSouls();
    TicketTimeComparator flightTimeComparator = new TicketTimeComparator();

    Ticket ticket1 = new Ticket(
            "Moscow",
            "Berlin",
            5_000,
            9,
            13
    );
    Ticket ticket2 = new Ticket(
            "Moscow",
            "Berlin",
            2_000,
            12,
            14
    );
    Ticket ticket3 = new Ticket(
            "Moscow",
            "Paris",
            5_000,
            10,
            13
    );

    Ticket ticket4 = new Ticket(
            "Moscow",
            "Berlin",
            3_000,
            10,
            13
    );

    Ticket ticket5 = new Ticket(
            "Moscow",
            "Berlin",
            900,
            10,
            15
    );

    //тесты для compareTo
    @Test
    public void shouldEqualCompareTo() {
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);

        Assertions.assertEquals(0, ticket1.compareTo(ticket3));
    }

    @Test
    public void shouldMaxCompareTo() {
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);

        Assertions.assertEquals(1, ticket3.compareTo(ticket2));
    }

    @Test
    public void shouldMinCompareTo() {
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);

        Assertions.assertEquals(-1, ticket2.compareTo(ticket1));
    }

    //тесты для TicketTimeComparator
    @Test
    public void shouldFlightTimeComparatorEqual() {
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);

        Assertions.assertEquals(0, flightTimeComparator.compare(ticket3, ticket4));
    }

    @Test
    public void shouldFlightTimeComparatorMax() {

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);

        Assertions.assertEquals(-1, flightTimeComparator.compare(ticket2, ticket1));
    }

    @Test
    public void shouldFlightTimeComparatorMin() {

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);

        Assertions.assertEquals(1, flightTimeComparator.compare(ticket3, ticket2));
    }

    //тесты для search
    @Test
    public void shouldSearchTicketSortPrice() {

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);

        Ticket[] expected = {ticket2, ticket4, ticket1};
        Ticket[] actual = souls.search("Moscow", "Berlin");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTicketSortPriceOneTicket() {

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);

        Ticket[] expected = {ticket3};
        Ticket[] actual = souls.search("Moscow", "Paris");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTicketSortPriceNotTicket() {

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);

        Ticket[] expected = {};
        Ticket[] actual = souls.search("Moscow", "London");

        Assertions.assertArrayEquals(expected, actual);
    }

    //тесты для searchAndSortBy c учетом логики TicketTimeComparator
    @Test
    public void shouldSearchAndSortByTicketTimeComparatorSomeArrays() {

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);

        Ticket[] expected = {ticket2, ticket4, ticket1, ticket5};
        Ticket[] actual = souls.searchAndSortBy("Moscow", "Berlin", flightTimeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByTicketSortPriceOneArray() {

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);

        Ticket[] expected = {ticket3};
        Ticket[] actual = souls.search("Moscow", "Paris");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByTicketSortPriceNotTicket() {

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = souls.search("Moscow", "London");

        Assertions.assertArrayEquals(expected, actual);
    }
}
