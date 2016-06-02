
import java.util.GregorianCalendar;

/****************************************************************
 * Author: Thomas Kramer                                        *
 * Purpose: Class that holds information about a TutorialEvent  *
 * Date: 15/04/2016 3:23apm                                     *
 ***************************************************************/
public class TutorialEvent extends UniEvent implements ISchedule
{
    private int classroom;

    /********************************************************************
    *Default Constructor:                                               *
    *Purpose: To construct a default object of TutorialEvent            *
    *Date: 22/05/2016 9:31pm                                            *
    *IMPORT: none                                                       *
    *EXPORT: address of new TutorialEvent object                        *
    *ASSERTION: Default super constructor and classroom 22 is default   *
    *           state of a TutorialEvent                                *       
    ********************************************************************/
    public TutorialEvent()
    {
        super();
        classroom = 22;
    }

    /*******************************************************************************
    *Alternate #1 Constructor:                                                     *
    *Purpose: To construct a object of TutorialEvent using imported values         *
    *Date: 22/05/2016 9:31pm                                                       *
    *IMPORT: inDatetime (GregorianCalendar), inUnit (String), inClassroom (String) *
    *EXPORT: address of new UniEvent object                                        *
    *ASSERTION: Creates the object if the imports are valid and FAILS otherwise    *
    *******************************************************************************/
    public TutorialEvent(GregorianCalendar date, String inUnit, int inClassroom)
    {
        super(date, inUnit);
        if(validateClassroom(inClassroom))
        {
        classroom = inClassroom;
        }
        else
        {
            throw new IllegalArgumentException("Invalid values classroom must be between 1 and 400");
        }
    }

    /*****************************************************************************
    *Copy Constructor:                                                           *
    *Purpose: To create a new object with the same object state as the import    *
    *Date: 22/05/2016 9:31pm                                                     *
    *IMPORT: inTutorialEvent (TutorialEvent)                                     *
    *EXPORT: address of new TutorialEvent object                                 *
    *ASSERTION: Creates an object with an identical object state as the import.  *
    *****************************************************************************/
    public TutorialEvent(TutorialEvent inTutorialEvent)
    {
        super(inTutorialEvent.getDateTime(), inTutorialEvent.getUnit());
        classroom = inTutorialEvent.getClassroom();
    }

    //MUTATORS
    /**********************************************************************
    *SUBMODULE: setClassroom                                              *
    *Purpose: To change/set classroom of the object to the value imported *
    *Date: 22/05/2016 9:31pm                                              *
    *IMPORT: inClassroom (String)                                         *
    *EXPORT: none                                                         *
    *ASSERTION: sets classroom to inClassroom.                            *
    **********************************************************************/

    public void setClassroom(int inClassroom)
    {
        if(validateClassroom(inClassroom))
        {
        classroom = inClassroom;
        }
        else
        {
            throw new IllegalArgumentException("Invalid values classroom must be between 1 and 400");
        }
    }

    //ACCESSORS
    /**************************************************************
    *SUBMODULE: getClassroom                                      *
    *Purpose: To get return the value of classroom for the object *
    *Date: 22/05/2016 9:31pm                                      *
    *IMPORT: none                                                 *
    *EXPORT: classroom                                            *
    *ASSERTION: returns classroom                                 *
    **************************************************************/

    public int getClassroom()
    {
        return classroom;
    }

    /********************************************************************
    * SUBMODULE: toString                                               * 
    * Purpose: To return a string of the TutorialEvent object           *
    * Date: 22/05/2016 9:31pm                                           *
    * IMPORT: none                                                      *
    * EXPORT: time (String)                                             *
    * ASSERTION:                                                        *
    ********************************************************************/

    public String toString()
    {

        return ("This Event is at: " + this.getDateTime().getTime() + " In Classroom: " + classroom + " For Unit: " + this
                .getUnit());
    }

    /********************************************************************
    * SUBMODULE: printAlert                                             * 
    * Purpose: To print out an alert of information of the TutorialEvent*
    *          object and time till the event                           *
    * Date: 22/05/2016 9:31pm                                           *
    * IMPORT: none                                                      *
    * EXPORT: time (String)                                             *
    * ASSERTION:                                                        *
    ********************************************************************/

    public String printAlert()
    {
        GregorianCalendar currentTime = new GregorianCalendar();
        Time timeRemainding = new Time(this.getDateTime(), currentTime);
        String str = ("You have a Tutorial in: " + classroom + " for: " + this.getUnit() + " Time Remaining: "
                + timeRemainding.toString());
        return str;
    }

    /********************************************************************
    * SUBMODULE: equals                                                 *
    * Purpose: To compare if two TutorialEvent objects are the same     *
    * Date: 22/05/2016 9:31pm                                           *
    * IMPORT: inObj (Object)                                            *
    * EXPORT: same                                                      *
    * ASSERTION:Two TutorialEvent objects are the same if they have the *
    *           same super and same classroom                           *
    ********************************************************************/
    public boolean equals(Object inObj)
    {
        boolean same = false;
        if (inObj instanceof TutorialEvent)
        {
            TutorialEvent inTutorialEvent = (TutorialEvent) inObj;
            same = (super.equals(inTutorialEvent) && classroom == inTutorialEvent.getClassroom());

        }
        return same;
    }
    //PRIVATE SUBMODULES:
    /************************************************************************
    *SUBMODULE: validateClassroom                                           *
    * Purpose: To check if inClassroom is a valid classroom                 *
    * Date: 22/05/2016 9:31pm                                               *                            
    *IMPORT: inClassroom (int)                                              *
    *EXPORT: valid (boolean)                                                *
    *ASSERTION: inClassroom must be between 1 and 400 (inclusive)           *
    ************************************************************************/   
    private boolean validateClassroom(int inClassroom)
    {
        return (inClassroom >= 1 && inClassroom <= 400);
        
    }
}
