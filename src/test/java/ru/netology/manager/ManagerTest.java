package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.InfoTicket;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {
    Manager manager = new Manager();

    private InfoTicket first = new InfoTicket(1, 12196, "SVO", "ROV", 125);
    private InfoTicket second = new InfoTicket(2, 15405, "VKO", "ROV", 110);
    private InfoTicket third = new InfoTicket(3, 25663, "VKO", "ROV", 445);
    private InfoTicket forth = new InfoTicket(4, 26184, "DME", "ROV", 455);
    private InfoTicket fifth = new InfoTicket(5, 25664, "VKO", "ROV", 475);
    private InfoTicket sixth = new InfoTicket(6, 25216, "DME", "ROV", 560);
    private InfoTicket seventh = new InfoTicket(7, 25687, "SVO", "ROV", 575);
    private InfoTicket eighth = new InfoTicket(8, 18409, "DME", "ROV", 620);
    private InfoTicket ninth = new InfoTicket(9, 24732, "DME", "ROV", 650);
    private InfoTicket tenth = new InfoTicket(10, 17692, "DME", "ROV", 725);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
    }

    @Test
    public void shouldReturnAllVariantsOfFling() {
        InfoTicket[] expected = new InfoTicket[]{first, second, tenth, eighth, ninth, sixth, third, fifth, seventh, forth};
        InfoTicket[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnTicketsDMEtoROV() {
        InfoTicket[] expected = new InfoTicket[]{tenth, eighth, ninth, sixth, forth};
        InfoTicket[] actual = manager.findAll("DME", "ROV");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnTicketsSVOtoROV() {
        InfoTicket[] expected = new InfoTicket[]{first, seventh};
        InfoTicket[] actual = manager.findAll("SVO", "ROV");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnTicketsVKOtoROV() {
        InfoTicket[] expected = new InfoTicket[]{second, third, fifth};
        InfoTicket[] actual = manager.findAll("VKO", "ROV");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyInfoTicketNoneExistDeparture() {
        InfoTicket[] expected = new InfoTicket[]{};
        InfoTicket[] actual = manager.findAll("NONE", "ROV");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyInfoTicketNoneExistArrival() {
        InfoTicket[] expected = new InfoTicket[]{};
        InfoTicket[] actual = manager.findAll("VKO", "NONE");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByDepartureDME() {
        InfoTicket[] expected = new InfoTicket[]{first, second, third, fifth, seventh};
        InfoTicket[] actual = manager.removeByDeparture("DME");
        assertArrayEquals(expected, actual);
    }


}