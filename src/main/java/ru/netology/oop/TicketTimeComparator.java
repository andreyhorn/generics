package ru.netology.oop;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        if (t1.timeFlight() < t2.timeFlight()) {
            return -1;
        } else if (t1.timeFlight() > t2.timeFlight()) {
            return 1;
        } else {
            return 0;
        }
    }
}
