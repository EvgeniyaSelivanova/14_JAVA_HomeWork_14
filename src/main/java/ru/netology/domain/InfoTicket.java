package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoTicket implements Comparable<InfoTicket> {
    private int id;
    private int price;
    private String departure;
    private String arrival;
    private int duration;

    @Override
    public int compareTo(InfoTicket o) {
        return price - o.price;
    }
}
