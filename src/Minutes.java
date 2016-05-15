public class Minutes
{
    private int minutes;

    public Minutes()
    {
        minutes = 0;
    }

    public Minutes(int inMinutes)
    {
        if (validateMinutes(inMinutes))
        {
            minutes = inMinutes;
        }
    }

    public Minutes(Minutes inMinutes)
    {
        minutes = inMinutes.getMinutes();
    }

    public int getMinutes()
    {
        return minutes;
    }

    public void setMinutes(int inMinutes)
    {
        minutes = inMinutes;
    }

    public static boolean validateMinutes(int inMinutes)
    {
        boolean valid = false;
        if (inMinutes >= 0 && inMinutes < 60)
        {
            valid = true;
        }
        return valid;
    }

    public String toString()
    {

        return ("Minutes: " + minutes);
    }

    public boolean equals(Object inObj)
    {
        boolean same = false;
        if (inObj instanceof Minutes)
        {
            Minutes inMinutes = (Minutes) inObj;
            same = (minutes == inMinutes.getMinutes());
        }
        return same;
    }
}
