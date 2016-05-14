import java.util.GregorianCalendar;
import java.util.Calendar;

public class UniEvent
{
    private GregorianCalendar datetime;
    private String unit;

    public UniEvent()
    {

        // datetime = (GregorianCalendar) GregorianCalendar.getInstance();
        datetime = new GregorianCalendar();
        unit = null;

    }
    
    public UniEvent(GregorianCalendar inDatetime, String inUnit)
    {

        // datetime = (GregorianCalendar) GregorianCalendar.getInstance();
        datetime = inDatetime;
        unit = inUnit;

    }

    public boolean equals(Object inObj)
    {
        boolean same = false;
        if (inObj instanceof UniEvent)
        {
            UniEvent inUniEvent = (UniEvent) inObj;
            same = datetime.equals(inUniEvent.getDateTime()) && unit.equals(inUniEvent.getUnit());
        }
        return same;
    }

    public GregorianCalendar getDateTime()
    {
        return datetime;
    }

    public String getUnit()
    {
        return unit;
    }

    public void setDateTime(GregorianCalendar inDateTime)
    {
        datetime = inDateTime;
    }

    public void setUnit(String inUnit)
    {
        unit = inUnit;
    }
    
    public String toString()
    {
   
        return ("This Event is at: " + datetime.getTime() + "For Unit: " + unit );
    }
}