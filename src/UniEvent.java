/****************************************************************
 * Author: Thomas Kramer                                        *
 * Purpose: Class that holds information about a UniEvent       * 
 * Date: 15/04/2016 3:23apm                                     *
 ***************************************************************/
import java.util.GregorianCalendar;

public class UniEvent
{
    private GregorianCalendar datetime;
    private String unit;

    /********************************************************************
    *Default Constructor:                                               *
    *Purpose: To construct a default object of UniEvent                 *
    *Date: 22/05/2016 9:31pm                                            *
    *IMPORT: none                                                       *
    *EXPORT: address of new UniEvent object                             *
    *ASSERTION: Current time and null unit is default state of UniEvent *       
    ********************************************************************/
    public UniEvent()
    {
        datetime = new GregorianCalendar();
        unit = null;
    }

    /******************************************************************************
    *Alternate #1 Constructor:                                                    *
    *Purpose: To construct a object of UniEvent using imported values             *
    *Date: 22/05/2016 9:31pm                                                      *
    *IMPORT: inDatetime (GregorianCalendar), inUnit (String)                      *
    *EXPORT: address of new UniEvent object                                       *
    *ASSERTION: Creates the object if the imports are valid and FAILS otherwise   *
    ******************************************************************************/
    public UniEvent(GregorianCalendar inDatetime, String inUnit)
    {
        datetime = (GregorianCalendar) inDatetime.clone();
        unit = inUnit;
    }

    /*****************************************************************************
    *Copy Constructor:                                                           *
    *Purpose: To create a new object with the same object state as the import    *
    *Date: 22/05/2016 9:31pm                                                     *
    *IMPORT: inUniEvent (UniEvent)                                               *
    *EXPORT: address of new UniEvent object                                      *
    *ASSERTION: Creates an object with an identical object state as the import.  *
    *****************************************************************************/

    public UniEvent(UniEvent inUniEvent)
    {
        datetime = (GregorianCalendar) inUniEvent.getDateTime().clone();
        unit = inUniEvent.getUnit();
    }

    //MUTATORS
    /**********************************************************************
    *SUBMODULE: setDateTime                                               *
    *Purpose: To change/set dateTime of the object to the value imported  *
    *Date: 22/05/2016 9:31pm                                              *
    *IMPORT: inDateTime (GregorianCalendar)                               *
    *EXPORT: none                                                         *
    *ASSERTION: sets datetime to inDateTime.                              *
    **********************************************************************/
    public void setDateTime(GregorianCalendar inDateTime)
    {
        datetime = inDateTime;
    }

    /******************************************************************
    *SUBMODULE: setUnit                                               *
    *Purpose: To change/set unit of the object to the value imported  *
    *Date: 22/05/2016 9:31pm                                          *
    *IMPORT: inUnit (String)                                          *
    *EXPORT: none                                                     *
    *ASSERTION: sets inUnit to setUnit.                               *
    ******************************************************************/
    public void setUnit(String inUnit)
    {
        unit = inUnit;
    }

    //ACCESSORS
    /************************************************************
    *SUBMODULE: getDateTime                                     *
    *Purpose: To get the value of dateTime from the object      *
    *Date: 22/05/2016 9:31pm                                    *
    *IMPORT: none                                               *
    *EXPORT: datetime                                           *
    *ASSERTION: returns datetime                                *
    ************************************************************/

    public GregorianCalendar getDateTime()
    {
        return (GregorianCalendar) datetime.clone();
    }

    /************************************************************
    *SUBMODULE: getUnit                                         *
    *Purpose: To get the value of unit from the object          *
    *Date: 22/05/2016 9:31pm                                    *
    *IMPORT: none                                               *
    *EXPORT: unit                                               *
    *ASSERTION: returns unit                                    *
    ************************************************************/
    public String getUnit()
    {
        return unit;
    }

    /********************************************************************
    * SUBMODULE: toString                                               * 
    * Purpose: To return a string of the UniEvent object                *
    * Date: 22/05/2016 9:31pm                                           *
    * IMPORT: none                                                      *
    * EXPORT: time (String)                                             *
    * ASSERTION:                                                        *
    ********************************************************************/
    public String toString()
    {
        return ("This Event is at: " + datetime.getTime() + "For Unit: " + unit);
    }
    
    /********************************************************************
    * SUBMODULE: equals                                                 *
    * Purpose: To compare if two UniEvent objects are the same          *
    * Date: 22/05/2016 9:31pm                                           *
    * IMPORT: inObj (Object)                                            *
    * EXPORT: same                                                      *
    * ASSERTION:Two UniEvent objects are the same if they have the same *
    *           datetime and unit                                       *
    ********************************************************************/
    public boolean equals(Object inObj)
    {
        boolean same = false;
        if (inObj instanceof UniEvent)
        {
            UniEvent inUniEvent = (UniEvent) inObj;
            same = ( datetime.equals(inUniEvent.getDateTime()) && unit.equals(inUniEvent.getUnit()));

        }
        return same;
    }

}
