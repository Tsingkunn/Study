package ticket;

public class Ticket {
    private static final Ticket instance = new Ticket();

    private static int count = 1000;

    private Ticket() {
    }

    public static Ticket getInstance() {
        return instance;
    }

    public synchronized int send() {
        if (Ticket.count > 0) {
            return --Ticket.count;
        } else {
            return -1;
        }
    }

}
