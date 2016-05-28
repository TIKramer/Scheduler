import java.util.GregorianCalendar;
/****************************************************************
 * Author: Thomas Kramer                                        *
 * Purpose: Class that holds information about a LectureEvent   *
 * Date: 15/04/2016 3:23apm                                     *
 ***************************************************************/
public class LectureEvent extends UniEvent implements ISchedule
{
    private String lectureHall;
    /********************************************************************
    *Default Constructor:                                               *
    *Purpose: To construct a default object of LectureEvent             *
    *Date: 22/05/2016 9:31pm                                            *
    *IMPORT: none                                                       *
    *EXPORT: address of new LectureEvent  object                        *
    *ASSERTION: Default super constructor and lectureHall "Main hall"   * 
    *           is default state of a LectureEvent                      *       
    ********************************************************************/
    public LectureEvent()
    {
        super();
        lectureHall = "Main hall";
    }
    
    /*********************************************************************************
     *Alternate #1 Constructor:                                                      *
     *Purpose: To construct a object of LectureEvent using imported values           *
     *Date: 22/05/2016 9:31pm                                                        *
     *IMPORT: inDatetime (GregorianCalendar), inUnit (String), inLectureHall (String)*
     *EXPORT: address of new UniEvent object                                         *
     *ASSERTION: Creates the object if the imports are valid and FAILS otherwise     *
     ********************************************************************************/
    public LectureEvent(GregorianCalendar date, String unit, String inLectureHall)
    {
        super(date, unit);

        lectureHall = inLectureHall;
    }
    
    /*****************************************************************************
     *Copy Constructor:                                                           *
     *Purpose: To create a new object with the same object state as the import    *
     *Date: 22/05/2016 9:31pm                                                     *
     *IMPORT: inLectureEvent (LectureEvent)                                     *
     *EXPORT: address of new LectureEvent object                                 *
     *ASSERTION: Creates an object with an identical object state as the import.  *
     *****************************************************************************/
    public LectureEvent(LectureEvent inLectureEvent)
    {
        super(inLectureEvent.getDateTime(), inLectureEvent.getUnit());
        lectureHall = inLectureEvent.getLectureHall();
    }

  //MUTATORS
    /************************************************************************
    *SUBMODULE: setLectureHall                                              *
    *Purpose: To change/set lectureHall of the object to the value imported *
    *Date: 22/05/2016 9:31pm                                                *
    *IMPORT: inLectureHall (String)                                         *
    *EXPORT: none                                                           *
    *ASSERTION: sets lectureHall to inLectureHall.                          *
    ************************************************************************/
    
    public void setLectureHall(String inLectureHall)
    {
        lectureHall = inLectureHall;
    }
    
    //ACCESSORS
    /****************************************************************
    *SUBMODULE: getLectureHall                                      *
    *Purpose: To get return the value of lectureHall for the object *
    *Date: 22/05/2016 9:31pm                                        *
    *IMPORT: none                                                   *
    *EXPORT: lectureHall                                            *
    *ASSERTION: returns lectureHall                                 *
    ****************************************************************/
    public String getLectureHall()
    {
        return lectureHall;
    }

   
     /********************************************************************
     * SUBMODULE: toString                                               * 
     * Purpose: To return a string of the LectureEvent object            *
     * Date: 22/05/2016 9:31pm                                           *
     * IMPORT: none                                                      *
     * EXPORT: time (String)                                             *
     * ASSERTION:                                                        *
     ********************************************************************/
    public String toString()
    {
        return ("This Event is at: " + this.getDateTime().getTime() + "In Classroom: " + lectureHall + " For Unit: " + this
                .getUnit());

    }
    
    /********************************************************************
     * SUBMODULE: printAlert                                             * 
     * Purpose: To print out an alert of information of the LectureEvent *
     *          object and time till the event                           *
     * Date: 22/05/2016 9:31pm                                           *
     * IMPORT: none                                                      *
     * EXPORT: none                                                      *
     * ASSERTION:                                                        *
     ********************************************************************/
    public void printAlert()
    {
        GregorianCalendar currentTime = new GregorianCalendar();
        Time timeRemainding = new Time(this.getDateTime(), currentTime);
        System.out.println("You have a Lecture in: " + lectureHall + " for " + this.getUnit() + "Time Remaining: "
                + timeRemainding.toString());

    }
    
     /********************************************************************
     * SUBMODULE: equals                                                 *
     * Purpose: To compare if two LectureEvent objects are the same      *
     * Date: 22/05/2016 9:31pm                                           *
     * IMPORT: inObj (Object)                                            *
     * EXPORT: same                                                      *
     * ASSERTION:Two LectureEvent objects are the same if they have the  *
     *           same super and same lectureHall                         *
     ********************************************************************/
     public boolean equals(Object inObj)
     {
         boolean same = false;
         if (inObj instanceof LectureEvent)
         {
             LectureEvent inLectureEvent = (LectureEvent) inObj;
             same = (super.equals(inLectureEvent) && lectureHall.equals(inLectureEvent));

         }
         return same;
     }
    


}
