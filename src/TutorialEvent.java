import java.util.Date;
import java.util.GregorianCalendar;

public class TutorialEvent extends UniEvent implements ISchedule
{
    private int classroom;

    public TutorialEvent()
    {
        super();
        classroom = 22;
    }

    public TutorialEvent(int inClassroom, GregorianCalendar date)
    {
        super(date, "OOPD");

        classroom = inClassroom;
    }

    public int getClassroom()
    {
        return classroom;
    }

    public void setClassroom(int inClassroom)
    {
        classroom = inClassroom;
    }

    public String toString()
    {

        return ("This Event is at: " + this.getDateTime().getTime() + "In Classroom: " + classroom + " For Unit: " + this
                .getUnit());
    }

    public void printAlert()
    {
        boolean loop = true;
    
        while(loop == true){
        GregorianCalendar currentTime = new GregorianCalendar();
        long timeRemaing = (this.getDateTime().getTimeInMillis() - currentTime.getTimeInMillis());
        // long timeRemaing =(int)( (this.getDateTime().getTime() -
        // currentTime.getTime()) );

        //int days = (int) ((timeRemaing / (1000 * 60 * 60 * 24)) % 7);
        int weeks = (int) (timeRemaing / (1000 * 60 * 60 * 24 * 7));

        long seconds = timeRemaing / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;
        String time = days + ":" + hours % 24 + ":" + minutes % 60 + ":" + seconds % 60; 
        System.out.println("You have a Tutorial in: " + classroom + " for: " + this.getUnit() + "Time Remaining: "
                + time);
        System.out.println("You have a Tutorial in: " + classroom + " for: " + this.getUnit() + "Time Remaining: "
                + time);
        System.out.print("\033[H\033[2J");

        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
       
    }

    public boolean equals(Object inObj)
    {
        // TODO Auto-generated method stub
        return false;
    }
}
