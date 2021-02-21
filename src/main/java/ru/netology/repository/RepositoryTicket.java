package ru.netology.repository;

import ru.netology.domain.InfoTicket;

public class RepositoryTicket {
    private InfoTicket[] items = new InfoTicket[0];

    public void save(InfoTicket item) {
        int length = items.length + 1;
        InfoTicket[] tmp = new InfoTicket[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public InfoTicket[] removeByDeparture(String departure) {
        int i = 0;
        for (InfoTicket item : items) {
            if (item.getDeparture() == departure) {
                i++;
            }
        }
        int length = items.length - i;
        InfoTicket[] tmp = new InfoTicket[length];
        int index = 0;
        for (InfoTicket item : items) {
            if (item.getDeparture() != departure) {
                tmp[index] = item;
                index++;
            }
        }
        return tmp;
    }

    public InfoTicket[] getAll() {
        return items;
    }
}
