
abstract class Ticket {

    protected String ticketID;
    protected String origin;
    protected String destination;
    protected String date;

    public Ticket(String ticketID, String origin, String destination, String date) {
        this.ticketID = ticketID;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
    }

    abstract double calculatePrice();

    abstract void displayInfo();

    protected double distanceBasedFee() {
        int diff = Math.abs(origin.length() - destination.length());
        return diff * 100;
    }
}

class StandardTicket extends Ticket {

    private final String seatNum;
    private final double basePrice;

    public StandardTicket(String ticketID, String origin, String destination, String date,
            String seatNum, double basePrice) {
        super(ticketID, origin, destination, date);
        this.seatNum = seatNum;
        this.basePrice = basePrice;
    }

    @Override
    double calculatePrice() {
        return basePrice + distanceBasedFee();
    }

    @Override
    void displayInfo() {
        System.out.println("----- Standard Ticket -----");
        System.out.println("Ticket ID: " + ticketID);
        System.out.println("Origin: " + origin);
        System.out.println("Destination: " + destination);
        System.out.println("Date: " + date);
        System.out.println("Seat Number: " + seatNum);
        System.out.println("Total Price: " + calculatePrice());
        System.out.println();
    }

}

class FirstClassTicket extends Ticket {

    private final String seatNum;
    private final double basePrice;
    private final double surCharge;

    public FirstClassTicket(String ticketID, String origin, String destination, String date,
            String seatNum, double basePrice, double surCharge) {
        super(ticketID, origin, destination, date);

        this.seatNum = seatNum;
        this.basePrice = basePrice;
        this.surCharge = surCharge;
    }

    @Override
    double calculatePrice() {
        return basePrice + distanceBasedFee() + surCharge;
    }

    @Override
    void displayInfo() {
        System.out.println("----- First Class Ticket -----");
        System.out.println("Ticket ID: " + ticketID);
        System.out.println("Origin: " + origin);
        System.out.println("Destination: " + destination);
        System.out.println("Date: " + date);
        System.out.println("Seat Number: " + seatNum);
        System.out.println("First Class Surcharge: " + surCharge);
        System.out.println("Total Price: " + calculatePrice());
        System.out.println();
    }

}

public class TicketApp {

    public static void main(String[] args) {

        StandardTicket standard = new StandardTicket("T001", "Dhaka", "Rangpur", "2026-01-20",
                "A12", 500);
        FirstClassTicket firstClass = new FirstClassTicket("T002", "Rangpur", "Dhaka", "2026-01-24",
                "F02", 800, 300);

        standard.displayInfo();
        firstClass.displayInfo();

    }
}
