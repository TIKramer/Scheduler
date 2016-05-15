
public class Time
{
    private Hours hours;
    private Minutes minutes;

    public Time(){
        hours = new Hours();
        minutes = new Minutes();
    }
    public Minutes getMinutes()
    {
        return minutes;
    }

    public void setMinutes(int inMinutes)
    { 
       
        minutes = new Minutes(inMinutes);
    }
    public void setMinutes(Minutes inMinutes)
    { 
       
        minutes = inMinutes;
    }


    public Hours getHours()
    {
        return hours;
    }

    public void setHours(int inHours)
    {
      hours = new Hours(inHours);
    }
    
    public void setHours(Hours inHours)
    { 
       
        hours = inHours;
    }
    public String toString()
    {

        return ("Minutes: " + minutes + "" );
    }

    public boolean equals(Object inObj)
    {
        boolean same = false;
        if (inObj instanceof Time)
        {
            Time inTime = (Time) inObj;
            same = (minutes == inTime.getMinutes() && hours == inTime.getHours());
        }
        return same;
    }
  

   
}
