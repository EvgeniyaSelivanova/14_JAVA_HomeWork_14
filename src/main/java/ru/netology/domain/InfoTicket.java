package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoTicket implements Comparable {
    private int id;
    private int price;
    private String departure;
    private String arrival;
    private int duration;

    @Override
    public int compareTo(Object o) {
        InfoTicket p = (InfoTicket) o;
        return price - p.price;
    }

}
