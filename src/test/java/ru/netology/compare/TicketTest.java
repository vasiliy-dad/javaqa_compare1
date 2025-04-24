package ru.netology.compare;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class TicketTest {

    @Test
    public void shouldSortFewTickets() {

        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("KAZ", "UFA", 200, 15, 16);
        Ticket ticket2 = new Ticket("KAZ", "UFA", 300, 11, 16);
        Ticket ticket3 = new Ticket("SPB", "MSK", 200, 12, 13);
        Ticket ticket4 = new Ticket("KAZ", "NOV", 150, 14, 17);
        Ticket ticket5 = new Ticket("KAZ", "UFA", 250, 9, 13);
        Ticket ticket6 = new Ticket("UFA", "KAZ", 250, 10, 12);
        Ticket ticket7 = new Ticket("NOV", "SPB", 350, 13, 17);
        Ticket ticket8 = new Ticket("KAZ", "UFA", 200, 18, 22);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket1, ticket8, ticket5, ticket2};
        Ticket[] actual = manager.search("KAZ", "UFA");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortFewTicketsNotConcid() {

        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("KAZ", "UFA", 200, 15, 16);
        Ticket ticket2 = new Ticket("KAZ", "UFA", 300, 11, 16);
        Ticket ticket3 = new Ticket("SPB", "MSK", 200, 12, 13);
        Ticket ticket4 = new Ticket("KAZ", "NOV", 150, 14, 17);
        Ticket ticket5 = new Ticket("KAZ", "UFA", 250, 9, 13);
        Ticket ticket6 = new Ticket("UFA", "KAZ", 250, 10, 12);
        Ticket ticket7 = new Ticket("NOV", "SPB", 350, 13, 17);
        Ticket ticket8 = new Ticket("KAZ", "UFA", 210, 18, 22);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("KAZ", "MSK");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortFewTicketsOneConcid() {

        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("KAZ", "UFA", 200, 15, 16);
        Ticket ticket2 = new Ticket("KAZ", "UFA", 300, 11, 16);
        Ticket ticket3 = new Ticket("SPB", "MSK", 200, 12, 13);
        Ticket ticket4 = new Ticket("KAZ", "NOV", 150, 14, 17);
        Ticket ticket5 = new Ticket("KAZ", "UFA", 250, 9, 13);
        Ticket ticket6 = new Ticket("UFA", "KAZ", 250, 10, 12);
        Ticket ticket7 = new Ticket("NOV", "SPB", 350, 13, 17);
        Ticket ticket8 = new Ticket("KAZ", "UFA", 210, 18, 22);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.search("SPB", "MSK");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortFewTicketsWithComparator() {

        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("KAZ", "UFA", 200, 15, 16); //1
        Ticket ticket2 = new Ticket("KAZ", "UFA", 300, 11, 16); //5
        Ticket ticket3 = new Ticket("SPB", "MSK", 200, 12, 13);
        Ticket ticket4 = new Ticket("KAZ", "NOV", 150, 14, 17);
        Ticket ticket5 = new Ticket("KAZ", "UFA", 250, 9, 13);  //4
        Ticket ticket6 = new Ticket("UFA", "KAZ", 250, 10, 12);
        Ticket ticket7 = new Ticket("NOV", "SPB", 350, 13, 17);
        Ticket ticket8 = new Ticket("KAZ", "UFA", 210, 18, 23); //5

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket1, ticket5, ticket2, ticket8};
        Ticket[] actual = manager.searchAndSortBy("KAZ", "UFA", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortFewTicketsNotConcidWithComparator() {

        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("KAZ", "UFA", 200, 15, 16);
        Ticket ticket2 = new Ticket("KAZ", "UFA", 300, 11, 16);
        Ticket ticket3 = new Ticket("SPB", "MSK", 200, 12, 13);
        Ticket ticket4 = new Ticket("KAZ", "NOV", 150, 14, 17);
        Ticket ticket5 = new Ticket("KAZ", "UFA", 250, 9, 13);
        Ticket ticket6 = new Ticket("UFA", "KAZ", 250, 10, 12);
        Ticket ticket7 = new Ticket("NOV", "SPB", 350, 13, 17);
        Ticket ticket8 = new Ticket("KAZ", "UFA", 210, 18, 22);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("KAZ", "MSK", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortFewTicketsOneConcidWithComparator() {

        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("KAZ", "UFA", 200, 15, 16);
        Ticket ticket2 = new Ticket("KAZ", "UFA", 300, 11, 16);
        Ticket ticket3 = new Ticket("SPB", "MSK", 200, 12, 13);
        Ticket ticket4 = new Ticket("KAZ", "NOV", 150, 14, 17);
        Ticket ticket5 = new Ticket("KAZ", "UFA", 250, 9, 13);
        Ticket ticket6 = new Ticket("UFA", "KAZ", 250, 10, 12);
        Ticket ticket7 = new Ticket("NOV", "SPB", 350, 13, 17);
        Ticket ticket8 = new Ticket("KAZ", "UFA", 210, 18, 22);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.searchAndSortBy("SPB", "MSK", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllTickets() {

        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("KAZ", "UFA", 200, 15, 16);
        Ticket ticket2 = new Ticket("KAZ", "UFA", 300, 11, 16);
        Ticket ticket3 = new Ticket("SPB", "MSK", 200, 12, 13);
        Ticket ticket4 = new Ticket("KAZ", "NOV", 150, 14, 17);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] actual = manager.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetTicketPrice() {

        Ticket manager = new Ticket("KAZ", "UFA", 200, 15, 16);

        int expected = 200;
        int actual = manager.getPrice();

        Assertions.assertEquals(expected, actual);
    }

}
