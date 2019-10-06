import java.time.LocalTime;

public class ChargeMoney {
    //TODO PRICES CHANGED TO INT, EVERYTHING IS INT NOW
    public static final int hoursPrice = 2;
    public static final int minutesPrice = 1;

    public static void main(String[] args) {
        ChargeMoney p = new ChargeMoney();
        int minutes = p.setMinutesTime();
        int hours = p.setHoursTime();
        LocalTime localTime = LocalTime.now();
        int charged = p.setCharge();
        System.out.println("charged = " + charged);
        System.out.println("localTime = " + localTime);
        System.out.println("Hours = " +hours+ " Minutes = "+minutes);
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
        //System.out.println("Hours concat = " + combinedHours);
        //System.out.println("Minutes concat = " + combinedMinutes);
        //System.out.println("Min 1 = " + min1 + " Min 2 = " +min2);
        //System.out.println("Current time: " + str);
        //FIXME Is it possible to set the time with millis?
        return Integer.parseInt(concatHours);
    }

    //MAYBE THIS WON'T work anymore
    public int setCharge//(int entTime, int exitTime)
    () {
        int result = 0;
        //Customer cus = new Customer();
        //cus.setEntrance();
        //cus.setExit();
        // CUÁL ES LA MEJOR CABRONA FORMA DE HACER ESTO? D: AHHHH
        if (setHoursTime() == 0){
            ;
        }
        else{
            //TODO Fixed! :D now we can proceed, EVERYTHING IS A NICE INT
            result = (hoursPrice* setHoursTime() + minutesPrice * setMinutesTime());
        }
        return result;
    }
}
