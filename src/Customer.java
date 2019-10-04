public class Customer {

    int entranceTime = 0 ;
    int exitTime = 0;

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
}
