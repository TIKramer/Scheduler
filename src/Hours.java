public class Hours
{
    private int hours;

    public Hours()
    {
        hours = 0;
    }

    public Hours(int inHours)
    {
        if (validateHours(inHours))
        {
            hours = inHours;
        }
    }

    public Hours(Hours inHours)
    {
        hours = inHours.getHours();
    }

    public int getHours()
    {
        return hours;
    }

    public void setHours(int inHours)
    {
        hours = inHours;
    }

    public static boolean validateHours(int inHours)
    {
        boolean valid = false;
        if (inHours >= 0 && inHours < 24)
        {
            valid = true;
        }
        return valid;
    }

    public String toString()
    {

        return ("Hours: " + hours);
    }

    public boolean equals(Object inObj)
    {
        boolean same = false;
        if (inObj instanceof Hours)
        {
            Hours inHours = (Hours) inObj;
            same = (hours == inHours.getHours());
        }
        return same;
    }
}
