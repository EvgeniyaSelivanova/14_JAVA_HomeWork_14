package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.InfoTicket;
import ru.netology.repository.RepositoryTicket;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PrimitiveIterator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    private RepositoryTicket repository = new RepositoryTicket();
    private InfoTicket[] items = new InfoTicket[0];

    public void add(InfoTicket item) {
        repository.save(item);
    }

    public InfoTicket[] getAll() {
        InfoTicket[] tmp = repository.getAll();
        Arrays.sort(tmp);
        return tmp;
    }

    public InfoTicket[] removeByDeparture(String departure) {
        InfoTicket[] tmp = repository.removeByDeparture(departure);
        Arrays.sort(tmp);
        return tmp;
    }

    public InfoTicket[] findAll(String departure, String arrival) {
        items = repository.getAll();
        int length = 0;
        int index = 0;
        for (InfoTicket item : items) {
            if ((item.getDeparture() == departure) && (item.getArrival() == arrival)) {
                length++;
            }
        }
        InfoTicket[] tmp = new InfoTicket[length];
        for (InfoTicket item : items) {
            if ((item.getDeparture() == departure) && (item.getArrival() == arrival)) {
                tmp[index] = item;
                index++;
            }
        }
        Arrays.sort(tmp);
        return tmp;
    }
}
