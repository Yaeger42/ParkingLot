import java.awt.*;

public class Customer {

    int entranceTime = 0 ;
    int exitTime = 0;
    int payment = 0;

    public int setEntrance//(int hours, int minutes)
    () {
        ChargeMoney ch = new ChargeMoney();
        ch.setHoursTime();
        ch.setMinutesTime();
        this.entranceTime = ch.setHoursTime() + ch.setMinutesTime();
        return this.entranceTime ;
    }

    public int setExit//(int exithours, int exitminutes)
    () {
        ChargeMoney ch = new ChargeMoney();
        ch.setHoursTime();
        ch.setMinutesTime();
        this.exitTime = ch.setHoursTime() + ch.setMinutesTime();
        return this.exitTime;
    }

    public int payExit(int ticketId){
        ChargeMoney ch = new ChargeMoney();
        Ticket tk = new Ticket();
        Greedy gr = new Greedy();
        //Trying to assign a ticket to a customer, is it done like this (?)
        tk.ticketID = ticketId;
        int result = 0;
        this.payment = setExit() - setEntrance();
        //FIXME  new function added, is it okay? D: PANIC
        gr.findMin(payment);
        return payment;
        //Push
    }
}
