package ru.netology.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.oop.manager.AviaSouls;

public class AviaSoulsTest {
    AviaSouls souls = new AviaSouls();

    Ticket ticket1 = new Ticket("Город3", "Город1", 3_000, 20, 22);
    Ticket ticket2 = new Ticket("Город1", "Город2", 20_000, 12, 20);
    Ticket ticket3 = new Ticket("Город2", "Город3", 3_000, 14, 14);
    Ticket ticket4 = new Ticket("Город1", "Город2", 35_000, 14, 18);
    Ticket ticket5 = new Ticket("Город1", "Город2", 15_000, 12, 22);

    @BeforeEach
    public void setup() {
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
    }

    @Test
    public void testCompareToTicketLess() {

        int expected = -1;
        int actual = ticket1.compareTo(ticket4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCompareToTicketMore() {

        int expected = 1;
        int actual = ticket4.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCompareToTicketEqual() {

        int expected = 0;
        int actual = ticket1.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSearchSortPrice() {

        Ticket[] actual = souls.search("Город1","Город2");
        Ticket[] expected= {ticket5, ticket2, ticket4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchDesiredTicket() {

        Ticket[] actual = souls.search("Город2", "Город3");
        Ticket[] expected = {ticket3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchNotFoundTicket() {

        Ticket[] actual = souls.search("Город3", "Город2");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortByComparator() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] actual = souls.searchAndSortBy("Город1","Город2", timeComparator);
        Ticket[] expected = {ticket4, ticket2, ticket5};
    }
}
