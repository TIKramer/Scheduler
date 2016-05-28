/***************************************************************************
 * Author: Thomas Kramer                                                   *
 * Purpose: Class that holds minutes                                       *
 * Date: 15/04/2016 3:23pm                                                 *
 ***************************************************************************/
public class Hours
{
    private int hours;
    
    /*****************************************************************************
    * Default Constructor: Purpose: To construct a default object of Hours       *
    * Date: 22/05/2016 9:31pm                                                    *
    * IMPORT: none                                                               *
    * EXPORT: address of new Hours object                                        *
    * ASSERTION: 0 hours is the default state for Hours.                         *
    *****************************************************************************/
    public Hours()
    {
        hours = 0;
    }
     /******************************************************************************
     * Alternate #1 Constructor:                                                   *
     * Purpose: To construct a object of Hours using a imported value(inHours)     *
     * Date: 22/05/2016 9:31pm                                                     *
     * IMPORT: inHours (int)                                                       *
     * EXPORT: address of new Hours object                                         *
     * ASSERTION:Creates the object if the imports are valid and FAILS otherwise   *
     ******************************************************************************/
    public Hours(int inHours)
    {
        if (validateHours(inHours))
        {
            hours = inHours;
        }
        else
        {
            throw new IllegalArgumentException("Invalid Import Values");
        }
    }
    
    /*****************************************************************************
    *Copy Constructor:                                                           *
    *Purpose: To create a new object with the same object state as the import    *
    *Date: 22/05/2016 9:31pm                                                     *
    *IMPORT: inMinutes (Minutes)                                                 *
    *EXPORT: address of new Minutes object                                       *
    *ASSERTION: Creates an object with an identical object state as the import.  *
    *****************************************************************************/
    public Hours(Hours inHours)
    {
        hours = inHours.getHours();
    }

 // MUTATORS
    /**********************************************************************
    * SUBMODULE: setHours                                                 *
    * Purpose: To change/set hours of the object to the value imported    *
    * Date: 22/05/2016 9:31pm                                             *
    * IMPORT: inHours (int)                                               *
    * EXPORT: none                                                        * 
    * ASSERTION: sets hours to inHours                                    *
    **********************************************************************/
   
    public void setHours(int inHours)
    {
        hours = inHours;
    }

 // ACCESSORS
    /************************************************************
    * SUBMODULE: getHours                                       *
    * Purpose: To return the value of hours from the object     *
    * Date: 22/05/2016 9:31pm                                   *
    * IMPORT: none                                              *
    * EXPORT: hours                                             *
    * ASSERTION: returns hours                                  *
    ************************************************************/
    public int getHours()
    {
        return hours;
    }

   
     /********************************************************************
     * SUBMODULE: toString                                               * 
     * Purpose: To return a string of the Hours object                   *
     * Date: 22/05/2016 9:31pm                                           *
     * IMPORT: none                                                      *
     * EXPORT: str                                                       *
     * ASSERTION:                                                        *
     ********************************************************************/
    public String toString()
    {

        return ("Hours: " + hours);
    }
    /********************************************************************
     * SUBMODULE: equals                                                 *
     * Purpose: To compare if two Hours objects are the same             *
     * Date: 22/05/2016 9:31pm                                           *
     * IMPORT: inObj (Object)                                            *
     * EXPORT: same                                                      *
     * ASSERTION:Two Hours objects are the same if they have the same    *
     *           hours.                                                  *
     ********************************************************************/
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
    
    //PRIVATE SUBMODULES:
    /************************************************************************
    *SUBMODULE: validateHours                                               *
    * Purpose: To check if inHours is a valid hour                          *
    * Date: 22/05/2016 9:31pm                                               *                            
    *IMPORT: inHours (int)                                                  *
    *EXPORT: valid (boolean)                                                *
    *ASSERTION: inHours must be between 0 and 23 (inexlusive)               *
    ************************************************************************/
    private static boolean validateHours(int inHours)
    {
        boolean valid = false;
        if (inHours >= 0 && inHours < 24)
        {
            valid = true;
        }
        return valid;
    }
}
