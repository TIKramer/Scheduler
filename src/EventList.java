/****************************************************************
 * Author: Thomas Kramer                                        *
 * Purpose: Class that holds array of UniEvents and handles     *
 *          the adding to and displaying of the UniEvents array *
 * Date: 15/04/2016 3:23apm                                     *
 ***************************************************************/
public class EventList
{
    private UniEvent events[];
    /********************************************************************
    *Default Constructor:                                               *
    *Purpose: To construct a default object of EventList                *
    *Date: 22/05/2016 9:31pm                                            *
    *IMPORT: none                                                       *
    *EXPORT: address of new EventList object                            *
    *ASSERTION: events size of 10 is default the state of EventList     *       
    ********************************************************************/
    public EventList()
    {
        events = new UniEvent[10];
    }
    /************************************************************************
     *SUBMODULE: addEvent                                                    *
     * Purpose: To add an event to the events array                          *
     * Date: 22/05/2016 9:31pm                                               *                            
     *IMPORT: inEvent(UniEvent)                                                          *
     *EXPORT: none                                                           *
     *ASSERTION:                                                             *
     ************************************************************************/
    public void addEvent(UniEvent inEvent)
    {
        
        int counter = 0;
        boolean eventAdded = false;
        boolean eventListFull = false;
        while (counter < events.length && !eventAdded)
        {
            if (events[counter] == null)
            {
                events[counter] = inEvent;
                eventListFull = false;
                eventAdded = true;
            }
            counter++;
        }
        if (eventListFull)
        {
            System.out.println("Sorry the event list is full!");
        }
        else
        {
            System.out.println("Event added Sucessfully!");
        }
    }
    /************************************************************************
     *SUBMODULE: displayEvents                                                    *
     * Purpose: To display all items in the event array                      *
     * Date: 22/05/2016 9:31pm                                               *                            
     *IMPORT: none                                                           *
     *EXPORT: none                                                           *
     *ASSERTION: loops through all items in the array if it is not null      *
     *           it will display that item to console.                       *
     ************************************************************************/
    public void displayEvents()
    {

        for (int i = 0; i < events.length; i++)
        {
            if (events[i] != null)
            {
                System.out.println(events[i]);
            }
        }
    }
     /************************************************************************
     *SUBMODULE: addEvent                                                    *
     * Purpose: Display the print alert for all items in the event array     *
     * Date: 22/05/2016 9:31pm                                               *                            
     *IMPORT: none                                                           *
     *EXPORT: none                                                           *
     *ASSERTION: loops through all items in the array if it is not null      *
     *           it will determine which class the object is and             *
     *           call the printAlert method for that class                   *
     ************************************************************************/
    public void printAlert()
    {
        for (int i = 0; i < events.length; i++)
        {
            if (events[i] != null)
            {
                if (events[i] instanceof LectureEvent)
                {

                    LectureEvent event = (LectureEvent) events[i];
                    System.out.println(event.printAlert());
                }
                else if (events[i] instanceof TutorialEvent)
                {
                    TutorialEvent event = (TutorialEvent) events[i];
                    System.out.println(event.printAlert());
                }
            }
        }
    }

}
