public class Customer {

    int entranceTime = 0 ;
    int exitTime = 0;

    public int setEntrance(){
        ChargeMoney ch = new ChargeMoney();
        ch.setHoursTime();
        ch.setMinutesTime();
        this.entranceTime = ch.setHoursTime() + ch.setMinutesTime();
        return this.entranceTime ;
    }

    public int setExit(){
        ChargeMoney ch = new ChargeMoney();
        ch.setHoursTime();
        ch.setMinutesTime();
        this.exitTime = ch.setHoursTime() + ch.setMinutesTime();
        return this.exitTime;
    }
}
