import java.time.LocalTime;

public class ChargeMoney {

    public static final double hoursPrice = 0.03;
    public static final double minutesPrice = 0.02;

    public static void main(String[] args) {
        ChargeMoney p = new ChargeMoney();
        double minutes = p.setMinutesTime();
        double hours = p.setHoursTime();
        LocalTime localTime = LocalTime.now();
        System.out.println("localTime = " + localTime);
        System.out.println("Hours = " +hours+ " Minutes = "+minutes);
    }
    public double setMinutesTime() {
        //Hours
        LocalTime localTime = LocalTime.now();
        String str = localTime.toString();
        int min1 = Character.getNumericValue(str.charAt(6));
        int min2 = Character.getNumericValue(str.charAt(7));
        String concatMinutes = Integer.toString(min1) + Integer.toString(min2);
        return Integer.parseInt(concatMinutes);
    }
    public double setHoursTime(){
        //Minutes here:
        LocalTime localTime = LocalTime.now();
        String str = localTime.toString();
        int hour1 = Character.getNumericValue(str.charAt(3));
        int hour2 = Character.getNumericValue(str.charAt(4));
        String concatHours = Integer.toString(hour1) + Integer.toString(hour2);
        //System.out.println("Hours concat = " + combinedHours);
        //System.out.println("Minutes concat = " + combinedMinutes);
        //System.out.println("Min 1 = " + min1 + " Min 2 = " +min2);
        //System.out.println("Current time: " + str);
        //FIXME Is it possible to set the time with millis?
        return Integer.parseInt(concatHours);
    }

    public double setCharge(){
        int result = 0;
        if (setHoursTime() == 0){
            ;
        }
        else{
            //FIXME pls halp :'v I have doubles.
            result = hoursPrice* setHoursTime() + minutesPrice * setMinutesTime();
        }
    }
}
