import java.util.*;

/***************************************************************************
 * Author: Thomas Kramer                                                   *
 * Purpose: The MainMenu of the program allows the user to make choices and*
 *          interact with the program                                      *
 * Date: 22/05/2016 9:31pm                                                 *
 **************************************************************************/
public class MainMenu
{
    private EventList events;
    private UserInput input;

    /*****************************************************************************
    * Default Constructor: Purpose: To construct a default object of MainMenu    *
    * Date: 22/05/2016 9:31pm                                                    *
    * IMPORT: none                                                               *
    * EXPORT: address of new MainMenu object                                     *
    * ASSERTION: default EventList and default UserInput is the                  *
    *            default state for MainMenu                                      *
    *****************************************************************************/
    public MainMenu()
    {
        events = new EventList();
        input = new UserInput();
    }

 
    /************************************************************************
    *SUBMODULE: mainMenu                                                    *
    * Purpose: A Main Menu in console that displays options to the user     *
    * Date: 22/05/2016 9:31pm                                               *                            
    *IMPORT: none                                                           *
    *EXPORT: none                                                           *
    *ASSERTION:                                                             *
    ************************************************************************/
    public void mainMenu()
    {

        int selection = -1;
        int numOfSelectionsAboveZero = 3;
        while (!validateSelection(selection, numOfSelectionsAboveZero))
        {
            selection = input.readInt("Please enter: " + "\n\t 1: To Add an Event" + "\n\t 2: To Display Events"
                    + "\n\t 3: To Print Alert" + "\n\t 0: To Exit");
            if (!validateSelection(selection, numOfSelectionsAboveZero))
            {
                System.out.println("Invalid input, must enter a interger value between 0 and "
                        + numOfSelectionsAboveZero);
            }

        }
        switch (selection)
        {
            case 1:
                addEventMenu();
                mainMenu();
                break;
            case 2:
                events.displayEvents();
                mainMenu();
                break;
            case 3:
                events.printAlert();
                mainMenu();
                break;
            default:
                // exit;
                break;
        }
    }

    /************************************************************************
    *SUBMODULE: addEventMenu                                                *
    * Purpose: A Menu in console that display options to the user           *
    *          for adding a new event or returning to the main menu         *
    * Date: 22/05/2016 9:31pm                                               *                            
    *IMPORT: none                                                           *
    *EXPORT: none                                                           *
    *ASSERTION:                                                             *
    ************************************************************************/
    private void addEventMenu()
    {
        int selection = -1;
        int numOfSelectionsAboveZero = 2;
        while (!validateSelection(selection, numOfSelectionsAboveZero))
        {
            selection = input.readInt("Please enter: " + "\n\t 1: To Add a Lecture Event"
                    + "\n\t 2: To Add a Tutorial Event" + "\n\t 0: To Return To Main Menu");
            if (!validateSelection(selection, numOfSelectionsAboveZero))
            {
                System.out.println("Invalid input, must enter a interger value between 0 and "
                        + numOfSelectionsAboveZero);
            }

        }
        switch (selection)
        {
            case 1:
                createLectureEvent();
                break;
            case 2:
                createTutorialEvent();
                break;
            default:
                mainMenu();
                break;
        }
    }

    /************************************************************************
    *SUBMODULE: createLectureEvent                                          *
    * Purpose: creates a new LectureEvent object from user input and        *
    *          adds to the events array.                                    *
    * Date: 22/05/2016 9:31pm                                               *                            
    *IMPORT: none                                                           *
    *EXPORT: none                                                           *
    *ASSERTION:                                                             *
    ************************************************************************/
    private void createLectureEvent()
    {
        String unit = input.readString("Please enter the unit for this event:");
        String lectureHall = input.readString("Please enter the lecture hall:");
        GregorianCalendar date = generateDate();
        LectureEvent event = new LectureEvent(date, unit, lectureHall);
        events.addEvent(event);
    }

    /************************************************************************
    *SUBMODULE: createTutorialEvent                                         *
    * Purpose: creates a new TutorialEvent object from user input and       *
    *          adds to the events array.                                    *
    * Date: 22/05/2016 9:31pm                                               *                            
    *IMPORT: none                                                           *
    *EXPORT: none                                                           *
    *ASSERTION:                                                             *
    ************************************************************************/
    private void createTutorialEvent()
    {
        String unit = input.readString("Please enter the unit for this event:");
        int classroom = input.readInt("Please enter a Classroom number:");
        GregorianCalendar date = generateDate();
        TutorialEvent event = new TutorialEvent(date, unit, classroom);
        events.addEvent(event);
    }

    /************************************************************************
    *SUBMODULE: generateDate                                                *
    * Purpose: creates a valid date from user input if and fields are       *
    *          invalid the program will keep looping until valid input      *
    *          is entered.                                                  *
    * Date: 22/05/2016 9:31pm                                               *                            
    *IMPORT: none                                                           *
    *EXPORT: date (GregorianCalendar)                                       *
    *ASSERTION:                                                             *
    ************************************************************************/
    private GregorianCalendar generateDate()
    {
        Date getDate = new Date();
        getDate = retriveValidYear(getDate);
        getDate = retriveValidMonth(getDate);
        getDate = retriveValidDay(getDate);

        Hours getHours = new Hours(retriveValidHours());
        Minutes getMinutes = new Minutes(retriveValidMinutes());

        // Month -1 as GregorianCaladar months start from 0 not 1
        GregorianCalendar date = new GregorianCalendar(getDate.getYear(), (getDate.getMonth() - 1), getDate.getDay(),
                getHours.getHours(), getMinutes.getMinutes());
        return date;

    }

    /************************************************************************
    *SUBMODULE: validateSelection                                           *
    * Purpose: validates if the user selection is within the max value      *
    * Date: 22/05/2016 9:31pm                                               *                            
    *IMPORT: inSelection (int), maxSelctionValue (int)                      *
    *EXPORT: valid (boolean)                                                *
    *ASSERTION:                                                             *
    ************************************************************************/
    private boolean validateSelection(int inSelection, int maxSelctionValue)
    {
        boolean valid = false;
        if (inSelection >= 0 && inSelection <= maxSelctionValue)
        {
            valid = true;
        }
        return valid;
    }

    /*********************************************************************************************
    *SUBMODULE: retriveValidYear                                                                 *
    * Purpose: validates if input is a valid year else repeats until valid year is entered       *
    * Date: 22/05/2016 9:31pm                                                                    *                            
    *IMPORT: getDate (Date)                                                                      *
    *EXPORT: getDate (Date)                                                                      *
    *ASSERTION:                                                                                  *
    *********************************************************************************************/
    private Date retriveValidYear(Date getDate)
    {

        boolean validYear = false;
        while (!validYear)
        {
            int inYear = input.readInt("Please Enter a Year:");
            try
            {
                getDate.setYear(inYear);
                validYear = true;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
        }
        return getDate;

    }

    /*********************************************************************************************
    *SUBMODULE: retriveValidMonth                                                                *
    * Purpose: validates if input is a valid month else repeats until valid month is entered     *
    * Date: 22/05/2016 9:31pm                                                                    *                            
    *IMPORT: getDate (Date)                                                                      *
    *EXPORT: getDate (Date)                                                                      *
    *ASSERTION:                                                                                  *
    *********************************************************************************************/
    private Date retriveValidMonth(Date getDate)
    {

        boolean validMonth = false;
        while (!validMonth)
        {
            int inMonth = input.readInt("Please Enter a Month:");
            try
            {
                getDate.setMonth(inMonth);
                validMonth = true;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
        }
        return getDate;

    }

    /**********************************************************************************************
     *SUBMODULE: retriveValidDay                                                                  *
     * Purpose: validates if input is a valid day else repeats until valid day is entered         *
     * Date: 22/05/2016 9:31pm                                                                    *                            
     *IMPORT: getDate (Date)                                                                      *
     *EXPORT: getDate (Date)                                                                      *
     *ASSERTION:                                                                                  *
     *********************************************************************************************/
    private Date retriveValidDay(Date getDate)
    {

        boolean validDay = false;
        while (!validDay)
        {
            int inDay = input.readInt("Please Enter a Day:");
            try
            {
                getDate.setDay(getDate.getYear(), getDate.getMonth(), inDay);
                validDay = true;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
        }
        return getDate;

    }

    /**********************************************************************************************
     *SUBMODULE: retriveValidHours                                                                *
     * Purpose: validates if input is a valid hour else repeats until valid hour is entered       *
     * Date: 22/05/2016 9:31pm                                                                    *                            
     *IMPORT: none                                                                     *
     *EXPORT: getHours (Hours)                                                                      *
     *ASSERTION:                                                                                  *
     *********************************************************************************************/
    private Hours retriveValidHours()
    {
        Hours getHours = new Hours();
        boolean validHours = false;
        while (!validHours)
        {
            int inHours = input.readInt("Please Enter the Hours of Event Start Time:");
            try
            {
                getHours.setHours(inHours);
                validHours = true;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
        }
        return new Hours(getHours);

    }

    /***************************************************************************************************
    *SUBMODULE: retriveValidMinutes                                                                    *
    * Purpose: validates if input is a valid minutes else repeats until valid minutes is entered       *
    * Date: 22/05/2016 9:31pm                                                                          *                            
    *IMPORT: getDate (Date)                                                                            *
    *EXPORT: getDate (Date)                                                                            *
    *ASSERTION:                                                                                        *
    ***************************************************************************************************/
    private Minutes retriveValidMinutes()
    {
        Minutes getMinutes = new Minutes();
        boolean validMinutes = false;
        while (!validMinutes)
        {
            int inMinutes = input.readInt("Please Enter the Mintutes of Event Start Time:");
            try
            {
                getMinutes.setMinutes(inMinutes);
                validMinutes = true;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
        }
        return new Minutes(getMinutes);

    }

}
