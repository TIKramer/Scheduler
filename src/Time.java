import java.util.GregorianCalendar;

/***************************************************************************
 * Author: Thomas Kramer                                                   *
 * Purpose: Class that holds time(weeks, days, hours,minutes and seconds)  *
 * Date: 15/04/2016 3:23pm                                                 *
 ***************************************************************************/

public class Time
{
    private int weeks;
    private int days;
    private Hours hours;
    private Minutes minutes;
    private double seconds;

    /*****************************************************************************
    * Default Constructor: Purpose: To construct a default object of Time        *
    * Date: 22/05/2016 9:31pm                                                    *
    * IMPORT: none                                                               *
    * EXPORT: address of new Time object                                         *
    * ASSERTION: Hours and Minutes default, weeks, days and seconds              *
    *            set to 0 is the default state for Time.                         *
    *****************************************************************************/
    public Time()
    {
        weeks = 0;
        days = 0;
        hours = new Hours();
        minutes = new Minutes();
        seconds = 0;
    }

    /******************************************************************************
    * Alternate #1 Constructor:                                                   *
    * Purpose: To construct a object of Time using a imported value(milliseconds) *
    * Date: 22/05/2016 9:31pm                                                     *
    * IMPORT: inMilliseconds (long)                                               *
    * EXPORT: address of new Time object                                          *
    * ASSERTION:Creates the object if the imports are valid and FAILS otherwise   *
    ******************************************************************************/
    public Time(long inMilliseconds)
    {
        weeks = millisecondsToWeeks(inMilliseconds);
        days = millisecondsToDays(inMilliseconds);
        hours = new Hours(millisecondsToHours(inMilliseconds));
        minutes = new Minutes(millisecondsToMinutes(inMilliseconds));
        seconds = millisecondsToSeconds(inMilliseconds);
    }
    
    
    /*******************************************************************************
     * Alternate #2 Constructor:                                                   *
     * Purpose: To construct a object of Time using the difference between         *
     *          two GreorianCalendars(milliseconds)                                *
     * Date: 22/05/2016 9:31pm                                                     *
     * IMPORT: inMilliseconds (long)                                               *
     * EXPORT: address of new Time object                                          *
     * ASSERTION:Creates the object if the imports are valid and FAILS otherwise   *
     ******************************************************************************/
    public Time(Time inTime, Time inTime2)
    {
        weeks = inTime.getWeeks() - inTime2.getWeeks();
        days = inTime.getDays() - inTime2.getDays();
        hours = new Hours (inTime.getHours().getHours() - inTime2.getHours().getHours());
        minutes = new Minutes (inTime.getMinutes().getMinutes() - inTime2.getMinutes().getMinutes());
        seconds = inTime.getSeconds() - inTime2.getSeconds();
        
    }
    
    /*******************************************************************************
     * Alternate #2 Constructor:                                                   *
     * Purpose: To construct a object of Time using the difference between         *
     *          two GreorianCalendars(milliseconds)                                *
     * Date: 22/05/2016 9:31pm                                                     *
     * IMPORT: inMilliseconds (long)                                               *
     * EXPORT: address of new Time object                                          *
     * ASSERTION:Creates the object if the imports are valid and FAILS otherwise   *
     ******************************************************************************/
    public Time(GregorianCalendar inTime, GregorianCalendar inTime2)
    {
        this(inTime.getTimeInMillis() - inTime2.getTimeInMillis());
        
    }

    /***************************************************************************
    * Copy Constructor:                                                        *
    * Purpose: To create a new object with the same object state as the import *
    * Date: 22/05/2016 9:31pm                                                  *
    * IMPORT: inTime (Time)                                                    *
    * EXPORT: address of new Time object ASSERTION: Creates an object with an  *
    *         identical object state as the import.                            *
    ***************************************************************************/
    public Time(Time inTime)
    {
        weeks = inTime.getWeeks();
        days = inTime.getDays();
        hours = new Hours(inTime.getHours());
        minutes = new Minutes(inTime.getMinutes());
        seconds = inTime.getSeconds();
    }

    // MUTATORS
    /********************************************************************
    * SUBMODULE: setWeeks                                               *
    * Purpose: To change/set weeks of the object to the value imported  *
    * Date: 22/05/2016 9:31pm                                           *
    * IMPORT: inWeeks (int)                                             *
    * EXPORT: none                                                      * 
    * ASSERTION: sets weeks to inWeeks                                  *
    ********************************************************************/

    public void setWeeks(int inWeeks)
    {
        weeks = inWeeks;
    }

    /******************************************************************
    * SUBMODULE: setDays                                              *
    * Purpose: To change/set days of the object to the value imported *
    * Date: 22/05/2016 9:31pm                                         *
    * IMPORT: inDays (int)                                            *
    * EXPORT: none                                                    *
    * ASSERTION: sets days to inDays.                                 *
    ******************************************************************/
    public void setDays(int inDays)
    {
        days = inDays;
    }

    /*******************************************************************
    * SUBMODULE: setHours                                              *
    * Purpose: To change/set hours of the object to the value imported * 
    * Date: 22/05/2016 9:31pm                                          *
    * IMPORT: inHours (Hours)                                          *
    * EXPORT: none                                                     *
    * ASSERTION: sets hours to inHours.                                *
    *******************************************************************/
    public void setHours(Hours inHours)
    {
        hours = new Hours(inHours);
    }

    /*******************************************************************
    * SUBMODULE: setMinutes                                            *
    * Purpose: To change/set hours of the object to the value imported * 
    * Date: 22/05/2016 9:31pm                                          *
    * IMPORT: inMinutes (Minutes)                                      *
    * EXPORT: none                                                     *
    * ASSERTION: sets minutes to inMinutes.                            *
    *******************************************************************/
    public void setMinutes(Minutes inMinutes)
    {

        minutes = new Minutes(inMinutes);
    }

    /*********************************************************************
    * SUBMODULE: setSeconds                                              *
    * Purpose: To change/set seconds of the object to the value imported *
    * Date: 22/05/2016 9:31pm                                            *
    * IMPORT: inSeconds (int)                                            *
    * EXPORT: none                                                       *
    * ASSERTION: sets seconds to inSeconds.                              *
    *********************************************************************/
    public void setSeconds(int inSeconds)
    {
        seconds = inSeconds;
    }

    // ACCESSORS
    /************************************************************
    * SUBMODULE: getWeeks                                       *
    * Purpose: To return the value of weeks from the object     *
    * Date: 22/05/2016 9:31pm                                   *
    * IMPORT: none                                              *
    * EXPORT: weeks                                             *
    * ASSERTION: returns weeks                                  *
    ************************************************************/
    private int getWeeks()
    {
        return weeks;
    }

    /***********************************************************
    * SUBMODULE: getDays                                       *
    * Purpose: To return the value of days from the object     *
    * Date: 22/05/2016 9:31pm                                  *
    * IMPORT: none                                             *
    * EXPORT: days                                             *
    * ASSERTION: returns days                                  *
    ***********************************************************/
    private int getDays()
    {
        return days;
    }

    /************************************************************
    * SUBMODULE: getHours                                       *
    * Purpose: To return the value of hours from the object     *
    * Date: 22/05/2016 9:31pm                                   *
    * IMPORT: none                                              *
    * EXPORT: copy of hours                                     *
    * ASSERTION: returns a copy of hours                        *
    ************************************************************/
    public Hours getHours()
    {
        return new Hours(hours);
    }

    /************************************************************
    * SUBMODULE: getMinutes                                     *
    * Purpose: To return the value of minutes from the object   *
    * Date: 22/05/2016 9:31pm                                   *
    * IMPORT: none                                              *
    * EXPORT: copy of minutes                                   *
    * ASSERTION: returns a copy of minutes                      *
    ************************************************************/
    public Minutes getMinutes()
    {
        return new Minutes(minutes);
    }

    /***********************************************************
    * SUBMODULE: getSeconds                                    *
    * Purpose: To return the value of seconds from the object  * 
    * Date: 22/05/2016 9:31pm                                  *
    * IMPORT: none                                             *
    * EXPORT: seconds                                          *
    * ASSERTION: returns seconds                               *
    ***********************************************************/
    public double getSeconds()
    {
        return seconds;

    }

    /********************************************************************
    * SUBMODULE: equals                                                 *
    * Purpose: To compare if two Time objects are the same              *
    * Date: 22/05/2016 9:31pm                                           *
    * IMPORT: inObj (Object)                                            *
    * EXPORT: same                                                      *
    * ASSERTION:Two time objects are the same if they have the same     *
    *           weeks,hours, minutes and seconds.                       *
    ********************************************************************/
    public boolean equals(Object inObj)
    {
        boolean same = false;
        if (inObj instanceof Time)
        {
            Time inTime = (Time) inObj;
            same = (weeks == inTime.getWeeks() && hours == inTime.getHours() && minutes == inTime.getMinutes() && seconds == inTime
                    .getSeconds());

        }
        return same;
    }

    /********************************************************************
    * SUBMODULE: toString                                               * 
    * Purpose: To return a string of the Time object                    *
    * Date: 22/05/2016 9:31pm                                           *
    * IMPORT: none                                                      *
    * EXPORT: time (String)                                             *
    * ASSERTION:                                                        *
    *********************************************************************/

    public String toString()
    {

        String time = "";
        if (weeks > 0)
        {
            time = time + " " + weeks + " weeks";
        }
        if (days > 0)
        {
            time = time + " " + days + " days";
        }
        if (hours.getHours() > 0)
        {
            time = time + " " + hours + " hours";
        }
        if (minutes.getMinutes() > 0)
        {
            time = time + " " + minutes + " minutes";
        }
        if (seconds > 0)
        {
            time = time + " " + seconds + " seconds";
        }

        return time;
    }

    /************************************************************
    * SUBMODULE: millisecondsToWeeks                            *
    * Purpose: To get the number of weeks from inMilliseconds   *
    * Date: 22/05/2016 9:31pm                                   *
    * IMPORT: none                                              *
    * EXPORT: weeks                                             *
    * ASSERTION: returns weeks                                  *
    ************************************************************/
    private int millisecondsToWeeks(long inMilliseconds)
    {
        int weeks = 0;
        if (inMilliseconds > 0)
        {
            weeks = (int) (inMilliseconds / (1000 * 60 * 60 * 24 * 7));
        }

        return weeks;
    }

    /***********************************************************
    * SUBMODULE: millisecondsToDays                            *
    * Purpose: To get the number of days from inMilliseconds   * 
    * Date: 22/05/2016 9:31pm                                  *
    * IMPORT: none                                             *
    * EXPORT: days                                             *
    * ASSERTION: returns days                                  *
    ***********************************************************/
    private int millisecondsToDays(long inMilliseconds)
    {
        int days = 0;
        if (inMilliseconds > 0)
        {
            days = (int) ((inMilliseconds / (1000 * 60 * 60 * 24)) % 7);
        }

        return days;
    }

    /************************************************************
    * SUBMODULE: millisecondsToHours                            *
    * Purpose: To get the number of hours from inMilliseconds   *
    * Date: 22/05/2016 9:31pm                                   *
    * IMPORT: none                                              *
    * EXPORT: weeks                                             *
    * ASSERTION: returns hour                                   *
    ************************************************************/
    private Hours millisecondsToHours(long inMilliseconds)
    {
        Hours hour = new Hours();
        if (inMilliseconds > 0)
        {
            hour.setHours((int) (inMilliseconds / (1000 * 60) % 24));
        }

        return hour;
    }

    /************************************************************
    * SUBMODULE: millisecondsToMinutes                          *
    * Purpose: To get the number of minutes from inMilliseconds * 
    * Date: 22/05/2016 9:31pm                                   *
    * IMPORT: none                                              *
    * EXPORT: minutes                                           *
    * ASSERTION: returns minutes                                *
    ************************************************************/
    private Minutes millisecondsToMinutes(long inMilliseconds)
    {
        Minutes minutes = new Minutes();
        if (inMilliseconds > 0)
        {
            minutes.setMinutes((int) ((inMilliseconds / (1000 * 60 * 60)) % 24));
        }
        return minutes;
    }

    /************************************************************
    * SUBMODULE: millisecondsToSeconds                          *
    * Purpose: To get the number of seconds from inMilliseconds * 
    * Date: 22/05/2016 9:31pm                                   *
    * IMPORT: none                                              *
    * EXPORT: seconds                                           *
    * ASSERTION: returns seconds                                *
    ************************************************************/
    private double millisecondsToSeconds(long inMilliseconds)
    {
        double seconds = 0;
        if (inMilliseconds > 0)
        {
            seconds = ((inMilliseconds / (1000 % 60)) % 24);
        }
        return seconds;
    }
    
    


}
