
import java.util.ArrayList;

class TicketList {

    private final ArrayList<Ticket> _ticketList = new ArrayList<>();

    public void addTicket(Ticket ticket) {
        _ticketList.add(ticket);
        System.out.println("Ticket added successfully!\n");
    }

    public void delTicket(String ticketID) {
        for (int i = 0; i < _ticketList.size(); i++) {
            if (_ticketList.get(i).getTicketID().equalsIgnoreCase(ticketID)) {
                _ticketList.remove(i);
                System.out.println("Ticket deleted successfully!\n");
                return;
            }
        }
        System.out.println("Ticket not found!\n");
    }

    public void searchTicket(String ticketID) {
        for (Ticket t : _ticketList) {
            if (t.getTicketID().equalsIgnoreCase(ticketID)) {
                System.out.println("Ticket found:\n");
                t.displayInfo();
                return;

            }
        }
        System.out.println("Ticket not found!\n");

    }

    public void displayAllTickets() {
        if (_ticketList.isEmpty()) {
            System.out.println("No tickets available.\n");
            return;
        }

        System.out.println("===== All Tickets =====");
        for (Ticket t : _ticketList) {
            t.displayInfo();
        }
    }

    public double totalRevenue() {
        double sum = 0;
        for (Ticket t : _ticketList) {
            sum += t.calculatePrice();
        }
        return sum;
    }
}

public class TicketManager {

    public static void main(String[] args) {
        TicketList tl = new TicketList();

        Ticket t1 = new StandardTicket("T001", "Dhaka", "Sylhet", "2026-01-20", "A10", 500);
        Ticket t2 = new StandardTicket("T011", "Dhaka", "Rangpur", "2026-01-20", "A10", 800);
        Ticket t3 = new StandardTicket("T005", "Dhaka", "Cox's Bazar", "2026-01-20", "A10", 700);
        Ticket t4 = new FirstClassTicket("T102", "Khulna", "Rajshahi", "2026-01-21", "F01", 1000, 300);
        Ticket t5 = new FirstClassTicket("T302", "Khulna", "Dhaka", "2026-01-21", "F01", 900, 500);

        tl.addTicket(t1);
        tl.addTicket(t2);
        tl.addTicket(t3);
        tl.addTicket(t4);
        tl.addTicket(t5);

        tl.displayAllTickets();
        tl.searchTicket("t001");
        tl.delTicket("t302");
        System.out.println("Total Revenue = " + tl.totalRevenue());
    }
}
