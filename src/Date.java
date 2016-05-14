import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date
{
    private int year;
    private int month;
    private int day;

    
public Date(){
    GregorianCalendar currentDate = new GregorianCalendar();
    year = currentDate.get(Calendar.YEAR);
    month = currentDate.get(Calendar.MONTH);
    day = currentDate.get(Calendar.DAY_OF_MONTH);
}

public Date(int inYear, int inMonth, int inDay){
    if(validateYear(inYear) && validateMonth(inMonth) && validateDay(inYear, inMonth, inDay)){
        year = inYear;
        month = inMonth;
        day = inDay;
    }
    
}
    public int getYear()
    {
        return year;
    }

    public void setYear(int inYear)
    {
        if(validateYear(inYear)){
        year = inYear;
        }
        else
        {
            throw new IllegalArgumentException("Invalid year input(Year must be current year or above and in format YYYY)");
        }
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int inMonth)
    {
        if(validateMonth(inMonth)){
            month = inMonth;
            }
            else
            {
                throw new IllegalArgumentException("Invalid year input(Year must be current year or above and in format YYYY)");
            }
    }

    public int getDay()
    {
        return day;
    }

    public void setDay(int inYear, int inMonth, int inDay)
    {
        if (validateDay(inYear, inMonth, inDay))
        {
            day = inDay;
        }
        else
        {
            throw new IllegalArgumentException("Invalid day input(Day must be a valid day for the month in the format DD or D)");
        }
    }

    private static boolean validateYear(int inYear)
    {
        boolean valid = false;
        GregorianCalendar currentDate = new GregorianCalendar();
        if (inYear >= currentDate.get(Calendar.YEAR))
        {
            valid = true;
        }
        return valid;
    }

    // Will have to formate month to add extra 0
    private static boolean validateMonth(int inMonth)
    {
        boolean valid = false;
        if (inMonth >= 1 && inMonth <= 12)
        {
            valid = true;
        }
        return valid;
    }

    private static boolean validateDay(int inYear, int inMonth, int inDay)
    {
        boolean valid = false;
        int numOfDaysInMonth = -1;
        switch (inMonth)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numOfDaysInMonth = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numOfDaysInMonth = 30;
                break;
            case 2:
                GregorianCalendar validationCalandar = new GregorianCalendar();
                boolean isLeapYear = validationCalandar.isLeapYear(inYear);
                if (isLeapYear == true)
                {
                    numOfDaysInMonth = 29;
                }
                else
                {
                    numOfDaysInMonth = 28;
                }
            default:
                // exit();
                break;
        }

        if (inDay >= 1 && inDay <= numOfDaysInMonth)
        {
            valid = true;
        }
        return valid;
    }
    
    public String toString()
    {
   
        return (year + "/" + month + "/" + day);
    }

}
