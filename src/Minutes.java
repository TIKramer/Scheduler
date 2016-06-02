/***************************************************************************
 * Author: Thomas Kramer                                                   *
 * Purpose: Class that holds minutes                                       *
 * Date: 15/04/2016 3:23pm                                                 *
 ***************************************************************************/
public class Minutes
{
    private int minutes;

    /*****************************************************************************
    * Default Constructor: Purpose: To construct a default object of Minutes     *
    * Date: 22/05/2016 9:31pm                                                    *
    * IMPORT: none                                                               *
    * EXPORT: address of new Minutes object                                      *
    * ASSERTION: 0 minutes is the default state for Minutes.                     *
    *****************************************************************************/
    public Minutes()
    {
        minutes = 0;
    }

    /******************************************************************************
    * Alternate #1 Constructor:                                                   *
    * Purpose: To construct a object of Minutes using a imported value(inMinutes) *
    * Date: 22/05/2016 9:31pm                                                     *
    * IMPORT: inMinutes (int)                                                     *
    * EXPORT: address of new Minutes object                                       *
    * ASSERTION:Creates the object if the imports are valid and FAILS otherwise   *
    ******************************************************************************/
    public Minutes(int inMinutes)
    {
        if (validateMinutes(inMinutes))
        {
            minutes = inMinutes;
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
    public Minutes(Minutes inMinutes)
    {
        minutes = inMinutes.getMinutes();
    }

    // MUTATORS
    /**********************************************************************
    * SUBMODULE: setMinutes                                               *
    * Purpose: To change/set minutes of the object to the value imported  *
    * Date: 22/05/2016 9:31pm                                             *
    * IMPORT: inMinutes (int)                                             *
    * EXPORT: none                                                        * 
    * ASSERTION: sets minutes to inMinutes                                *
    **********************************************************************/
    public void setMinutes(int inMinutes)
    {
        minutes = inMinutes;
    }

    // ACCESSORS
    /************************************************************
    * SUBMODULE: getMinutes                                     *
    * Purpose: To return the value of minutes from the object   *
    * Date: 22/05/2016 9:31pm                                   *
    * IMPORT: none                                              *
    * EXPORT: minutes                                           *
    * ASSERTION: returns minutes                                *
    ************************************************************/

    public int getMinutes()
    {
        return minutes;
    }

    /*********************************************************************
     * SUBMODULE: toString                                               * 
     * Purpose: To return a string of the Minutes object                 *
     * Date: 22/05/2016 9:31pm                                           *
     * IMPORT: none                                                      *
     * EXPORT: str                                                       *
     * ASSERTION:                                                        *
     *********************************************************************/

    public String toString()
    {

        return ("Minutes: " + minutes);
    }

    /********************************************************************
    * SUBMODULE: equals                                                 *
    * Purpose: To compare if two Minutes objects are the same           *
    * Date: 22/05/2016 9:31pm                                           *
    * IMPORT: inObj (Object)                                            *
    * EXPORT: same                                                      *
    * ASSERTION:Two Minutes objects are the same if they have the same  *
    *           minutes.                                                *
    ********************************************************************/
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

    //PRIVATE SUBMODULES:
    /************************************************************************
    *SUBMODULE: validateMinutes                                             *
    * Purpose: To check if inMinutes is a valid minute                      *
    * Date: 22/05/2016 9:31pm                                               *                            
    *IMPORT: inMinutes (int)                                                *
    *EXPORT: valid (boolean)                                                *
    *ASSERTION: inMinutes must be between 0 and 59 (inclusive)              *
    ************************************************************************/
    private static boolean validateMinutes(int inMinutes)
    {
        return (inMinutes >= 0 && inMinutes < 60);
    }

}
