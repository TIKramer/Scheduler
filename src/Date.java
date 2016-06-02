import java.util.Calendar;
import java.util.GregorianCalendar;

/****************************************************************
 * Author: Thomas Kramer                                        *
 * Purpose: Class that holds a date (year/month/day)            *
 * Date: 20/05/2016 6:10pm                                      *
 ***************************************************************/
public class Date
{
    private int year;
    private int month;
    private int day;

    /********************************************************************
     *Default Constructor:                                               *
     *Purpose: To construct a default object of Date                     *
     *Date: 20/05/2016 6:10pm                                            *
     *IMPORT: none                                                       *
     *EXPORT: address of new Date object                                 *
     *ASSERTION: the current year, month and day is default the state of *
     *           Date                                               *       
     ********************************************************************/
    public Date()
    {
        GregorianCalendar currentDate = new GregorianCalendar();
        year = currentDate.get(Calendar.YEAR);
        month = currentDate.get(Calendar.MONTH);
        day = currentDate.get(Calendar.DAY_OF_MONTH);
    }

    /****************************************************************************************
    * Alternate #1 Constructor:                                                             *
    * Purpose: To construct a object of Date using a imported values(inYear, inMonth, inDay)*
    * Date: 20/05/2016 6:10pm                                                              *
    * IMPORT: inYear (int), inMonth (int), inDay (int)                                      *
    * EXPORT: address of new Date object                                                    *
    * ASSERTION:Creates the object if the imports are valid and FAILS otherwise             *
    ****************************************************************************************/
    public Date(int inYear, int inMonth, int inDay)
    {
        if (validateYear(inYear) && validateMonth(inMonth) && validateDay(inYear, inMonth, inDay))
        {
            year = inYear;
            month = inMonth;
            day = inDay;
        }
        else
        {
            throw new IllegalArgumentException("Invalid Import Values");
        }

    }

    /*****************************************************************************
    *Copy Constructor:                                                           *
    *Purpose: To create a new object with the same object state as the import    *
    *Date: 20/05/2016 6:10pm                                                    *
    *IMPORT: inDate (Date)                                                       *
    *EXPORT: address of new Date object                                          *
    *ASSERTION: Creates an object with an identical object state as the import.  *
    *****************************************************************************/
    public Date(Date inDate)
    {
        year = inDate.getYear();
        month = inDate.getMonth();
        day = inDate.getDay();
    }

    // MUTATORS
    /**********************************************************************
    * SUBMODULE: setYear                                                  *
    * Purpose: To change/set year of the object to the value imported     *
    * Date: 20/05/2016 6:10pm                                             *
    * IMPORT: inYear (int)                                                *
    * EXPORT: none                                                        * 
    * ASSERTION: sets year to inYear if valid and FAILS otherwise         *
    **********************************************************************/
    public void setYear(int inYear)
    {
        if (validateYear(inYear))
        {
            year = inYear;
        }
        else
        {
            throw new IllegalArgumentException(
                    "Invalid year input(Year must be current year or above and in format YYYY)");
        }
    }

    /**********************************************************************
    * SUBMODULE: setMonth                                                 *
    * Purpose: To change/set month of the object to the value imported    *
    * Date: 20/05/2016 6:10pm                                               *
    * IMPORT: inMonth (int)                                               *
    * EXPORT: none                                                        * 
    * ASSERTION: sets month to inMonth if valid and FAILS otherwise       *
    **********************************************************************/
    public void setMonth(int inMonth)
    {
        if (validateMonth(inMonth))
        {
            month = inMonth;
        }
        else
        {
            throw new IllegalArgumentException(
                    "Invalid year input(Year must be current year or above(within 100 years) and in format YYYY)");
        }
    }

    /**********************************************************************
     * SUBMODULE: setDay                                                   *
     * Purpose: To change/set day of the object to the value imported      *
     * Date: 20/05/2016 6:10pm                                                *
     * IMPORT: inYear (int), inMonth (int), inDay (int)                    *
     * EXPORT: none                                                        * 
     * ASSERTION: sets day to inDay if valid and FAILS otherwise           *
     **********************************************************************/

    public void setDay(int inYear, int inMonth, int inDay)
    {
        if (validateDay(inYear, inMonth, inDay))
        {
            day = inDay;
        }
        else
        {
            throw new IllegalArgumentException(
                    "Invalid day input(Day must be a valid day for the month in the format DD or D)");
        }
    }

    // ACCESSORS
    /************************************************************
    * SUBMODULE: getYear                                        *
    * Purpose: To return the value of year from the object      *
    * Date: 20/05/2016 6:10pm                                   *
    * IMPORT: none                                              *
    * EXPORT: year                                              *
    * ASSERTION: returns year                                   *
    ************************************************************/
    public int getYear()
    {
        return year;
    }

    /************************************************************
    * SUBMODULE: getMonth                                       *
    * Purpose: To return the value of month from the object     *
    * Date: 20/05/2016 6:10pm                                   *
    * IMPORT: none                                              *
    * EXPORT: month                                             *
    * ASSERTION: returns month                                  *
    ************************************************************/

    public int getMonth()
    {
        return month;
    }

    /************************************************************
    * SUBMODULE: getDay                                         *
    * Purpose: To return the value of day from the object       *
    * Date: 20/05/2016 6:10pm                                   *
    * IMPORT: none                                              *
    * EXPORT: month                                             *
    * ASSERTION: returns day                                    *
    ************************************************************/

    public int getDay()
    {
        return day;
    }

    //PRIVATE SUBMODULES:
    /************************************************************************
    *SUBMODULE: validateYear                                                *
    * Purpose: To check if inYear is a valid year                           *
    * Date: 20/05/2016 6:10pm                                               *                            
    *IMPORT: inYear (int)                                                   *
    *EXPORT: valid (boolean)                                                *
    *ASSERTION: inYear must be the current year or above(within 100 years)  *
    ************************************************************************/
    private static boolean validateYear(int inYear)
    {
        boolean valid = false;
        Date currentDate = new Date();
        if (inYear >= currentDate.getYear() && inYear <= (currentDate.getYear() + 100))
        {
            valid = true;
        }
        return valid;
    }
    //PRIVATE SUBMODULES:
    /************************************************************************
    *SUBMODULE: validateMonth                                               *
    * Purpose: To check if inMonth is a valid month                         *
    * Date: 20/05/2016 6:10pm                                               *                            
    *IMPORT: inMonth (int)                                                  *
    *EXPORT: valid (boolean)                                                *
    *ASSERTION: inMonth must be the current month or greater else fail      *
    ************************************************************************/
    private static boolean validateMonth(int inMonth)
    {
        boolean valid = false;
        if (inMonth >= 1 && inMonth <= 12)
        {
            valid = true;
        }
        return valid;
    }
    /************************************************************************
    *SUBMODULE: validateDay                                                 *
    * Purpose: To check if inDay is a valid day                             *
    * Date: 22/05/2016 9:31pm                                               *                            
    *IMPORT: inYear (int), inMonth (int), inYear (int)                      *
    *EXPORT: valid (boolean)                                                *
    *ASSERTION: inDay must be current day or greater else fail              *
    ************************************************************************/
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
                if (isLeapYear)
                {
                    numOfDaysInMonth = 29;
                }
                else
                {
                    numOfDaysInMonth = 28;
                }
            default:
                // exit;
                break;
        }

        if (inDay >= 1 && inDay <= numOfDaysInMonth)
        {
        
            valid = true;  
        }
        return valid;
    }
    /********************************************************************
     * SUBMODULE: toString                                              * 
     * Purpose: To return a string of the Date object                   *
     * Date: 20/05/2016 6:10pm                                          *
     * IMPORT: none                                                     *
     * EXPORT: str                                                      *
     * ASSERTION:                                                       *
     *******************************************************************/
    public String toString()
    {

        return (year + "/" + month + "/" + day);
    }
    
    /********************************************************************
     * SUBMODULE: equals                                                *
     * Purpose: To compare if two Hours objects are the same            *
     * Date: 20/05/2016 6:10pm                                          *
     * IMPORT: inObj (Object)                                           *
     * EXPORT: same                                                     *
     * ASSERTION:Two Date objects are the same if they have the same    *
     *           year, Month and day.                                   *
     ********************************************************************/
    public boolean equals(Object inObj)
    {
        boolean same = false;
        if (inObj instanceof Date)
        {
            Date inDate = (Date) inObj;
            same = (year == inDate.getYear() && month == inDate.getMonth() && day == inDate.getDay());
        }
        return same;
    }
 

}
