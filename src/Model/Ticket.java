package Model;

public class Ticket {

    private int ticketID = 0;
    private int entranceHrs = 0;
    private int entranceMnts = 0;
    private int exitHrs = 0;
    private int exitMnts = 0;
    private int price = 0;

    public Ticket(int ticketID, int entranceHrs, int entranceMnts) {

        this.ticketID = ticketID;
        this.entranceHrs = entranceHrs;
        this.entranceMnts = entranceMnts;

    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public int getEntranceHrs() {
        return entranceHrs;
    }

    public void setEntranceHrs(int entranceHrs) {
        this.entranceHrs = entranceHrs;
    }

    public int getEntranceMnts() {
        return entranceMnts;
    }

    public void setEntranceMnts(int entranceMnts) {
        this.entranceMnts = entranceMnts;
    }

    public int getExitHrs() {
        return exitHrs;
    }

    public void setExitHrs(int exitHrs) {
        this.exitHrs = exitHrs;
    }

    public int getExitMnts() {
        return exitMnts;
    }

    public void setExitMnts(int exitMnts) {
        this.exitMnts = exitMnts;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID=" + ticketID +
                ", entranceHrs=" + entranceHrs +
                ", entranceMnts=" + entranceMnts +
                ", exitHrs=" + exitHrs +
                ", exitMnts=" + exitMnts +
                ", price=" + price +
                '}';
    }
}
