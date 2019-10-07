package manager;

import Model.Ticket;
import view.ManagerListener;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ParkingManager {
    private ManagerListener listener;
    public static final int MINS_PRICE = 1;
    public static final int HOURS_PRICE = 2;

    private Ticket ticket;
    private int ticketId = 0;
    private List <Ticket> ticketList = new ArrayList();
    public ParkingManager(ManagerListener listener){
        this.listener = listener;
    }

    public int setMinutesTime() {
        //Hours
        LocalTime localTime = LocalTime.now();
        String str = localTime.toString();
        int min1 = Character.getNumericValue(str.charAt(6));
        int min2 = Character.getNumericValue(str.charAt(7));
        String concatMinutes = Integer.toString(min1) + Integer.toString(min2);
        return Integer.parseInt(concatMinutes);
    }
    public int setHoursTime(){
        //Minutes here:
        LocalTime localTime = LocalTime.now();
        String str = localTime.toString();
        int hour1 = Character.getNumericValue(str.charAt(3));
        int hour2 = Character.getNumericValue(str.charAt(4));
        String concatHours = Integer.toString(hour1) + Integer.toString(hour2);
        return Integer.parseInt(concatHours);
    }
    public void createTicket(){
        ticket = new Ticket(ticketId, setHoursTime(), setMinutesTime());
        ticketId ++;
        ticketList.add(ticket);
        listener.updateTicketList(ticketList);
    }

    public void setExitTicket(int ticketId){
        Ticket ticket = getTicket(ticketId);
    }

    public Vector payTicket(int money, int ticketId){
        Ticket ticket = getTicket(ticketId);
        ticket.setExitHrs(setHoursTime());
        ticket.setExitMnts(setMinutesTime());
        ticket.setPrice(calcParking(ticket.getEntranceHrs(), ticket.getEntranceMnts(), ticket.getExitHrs(), ticket.getExitMnts()));
        if (money < ticket.getPrice()){
            throw new RuntimeException("Not enough money to pay");
        }
        listener.updateTicketList(ticketList);
        return Greedy.findMin(money);
    }

    public int calcParking(int entranceHours, int entranceMinutes, int exitHours, int exitMinutes){
        // (horas de entrada) - (horas de salida) -----   (minutosDeSalida) - (minutos de entrada)
        int resultHours = Math.abs(entranceHours - exitHours);
        int resultMinutes = Math.abs(entranceMinutes - exitMinutes);
        int result = (resultHours * HOURS_PRICE) +  (resultMinutes * MINS_PRICE);
        return result;
    }

    public Ticket getTicket(int ticketId){
        Ticket savedTicket = null;
        for(Ticket ticket: ticketList){
            if(ticketId == ticket.getTicketID()){
                 savedTicket =ticket;
            }
        }
        return savedTicket;
    }

}

