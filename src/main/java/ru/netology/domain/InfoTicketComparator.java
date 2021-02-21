package ru.netology.domain;

import java.util.Comparator;

public class InfoTicketComparator implements Comparator<InfoTicket> {
    public int compare(InfoTicket o1, InfoTicket o2) {
        return o1.getDuration() - o2.getDuration();
    }
}
