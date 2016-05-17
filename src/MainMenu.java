import java.util.*;

public class MainMenu
{
    public static void mainMenu()
    {
        
        Scanner sc = new Scanner(System.in);
        int selection = -1;
        int numOfSelectionsAboveZero = 3;
        while (!validateSelection(selection, numOfSelectionsAboveZero))
        {
            System.out.println("Please enter: " + "\n\t 1: To Add an Event" + "\n\t 2: To Display Events"
                    + "\n\t 3: To Print Alert" + "\n\t 0: To Exit");
            selection = retrieveIntFromUser();

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
                break;
            case 2:
                // displayEvents();
                break;
            case 3:
                // printAlert();
                break;
            default:
                // exit();
                break;
        }
    }

    public static void addEventMenu()
    {
        UniEvent[] events = new UniEvent[10];
        Scanner sc = new Scanner(System.in);
        int selection = -1;
        int numOfSelectionsAboveZero = 2;

        while (!validateSelection(selection, numOfSelectionsAboveZero))
        {
            System.out.println("Please enter: " + "\n\t 1: To Add a Lecture Event" + "\n\t 2: To Add a Tutorial Event"
                    + "\n\t 0: To Return To Main Menu");
            selection = retrieveIntFromUser();

            if (!validateSelection(selection, numOfSelectionsAboveZero))
            {
                System.out.println("Invalid input, must enter a interger value between 0 and "
                        + numOfSelectionsAboveZero);
            }

        }

        switch (selection)
        {

            case 1:
                boolean validDay = false;
                GregorianCalendar date = retriveDate();
                LectureEvent event = new LectureEvent("4th Hall", date);
                
                events[1] = event;
                System.out.println(events[1].toString());
                break;
            case 2:
                TutorialEvent event2 = new TutorialEvent();
                System.out.println(event2);
                break;
            default:
                mainMenu();
                break;
        }
    }

    public static GregorianCalendar retriveDate()
    {  
        Date getDate = new Date();
        Hours getHours = new Hours();
        Minutes getMinutes = new Minutes();
        boolean validYear = false;
        boolean validMonth = false;
        boolean validDay = false;
        boolean validTime = false;

        while (!validYear)
        {
            System.out.println("Please Enter a Year:");
            int inYear = retrieveIntFromUser();
            try
            {
                getDate.setYear(inYear);
                validYear = true;
            }
            catch (Exception e)
            {
                System.out.println("Invalid year input(Year must be current year or above and in format YYYY)");
                validYear = false;
            }
        }
        while (!validMonth)
        {
            System.out.println("Please Enter a Month:");
            int inMonth = retrieveIntFromUser();
            try
            {
                getDate.setMonth(inMonth);
                validMonth = true;
            }
            catch (Exception e)
            {
                System.out.println("Invalid Month input(Month must be between 1 to 12 and in format MM or M)");
                validMonth = false;
            }
        }
        while (!validDay)
        {
            System.out.println("Please Enter a Day:");
            int inDay = retrieveIntFromUser();
            try
            {
                getDate.setDay(getDate.getYear(), getDate.getMonth(), inDay);
                validDay = true;
            }
            catch (Exception e)
            {
                System.out.println("Invalid day input(Day must be a valid day for the month in the format DD or D)");
                validDay = false;
            }
        }
        while (!validTime)
        {
            boolean validHours = false;
            boolean validMinutes = false;
            while (!validHours)
            {
                System.out.println("Please Enter the Hours of Event Start Time:");
                int inHours = retrieveIntFromUser();
                try
                {
                    getHours.setHours(inHours);
                    validHours = true;
                }
                catch (Exception e)
                {
                    System.out
                            .println("Invalid day input(Day must be a valid day for the month in the format DD or D)");
                    validHours = false;
                }
            }
            while (!validMinutes)
            {
                System.out.println("Please Enter the Mintutes of Event Start Time:");
                int inMinutes = retrieveIntFromUser();
                try
                {
                    getMinutes.setMinutes(inMinutes);
                    validMinutes = true;
                }
                catch (Exception e)
                {
                    System.out
                            .println("Invalid day input(Day must be a valid day for the month in the format DD or D)");
                    validMinutes = false;
                }
            }
            validTime =(validHours && validMinutes);
        }

        // Month -1 as GregorianCaladar months start from 0 not 1
        GregorianCalendar date = new GregorianCalendar(getDate.getYear(), (getDate.getMonth() - 1), getDate.getDay(),
                getHours.getHours(), getMinutes.getMinutes());
        return date;

    }

    public static boolean validateHours(int inHours)
    {
        boolean valid = false;
        if (inHours >= 0 && inHours < 24)
        {
            valid = true;
        }
        return valid;
    }

    public static boolean validateMinutes(int inMinutes)
    {
        boolean valid = false;
        if (inMinutes >= 0 && inMinutes < 60)
        {
            valid = true;
        }
        return valid;
    }

    public static boolean validateSelection(int inSelection, int maxSelctionValue)
    {
        boolean valid = false;
        if (inSelection >= 0 && inSelection <= maxSelctionValue)
        {
            valid = true;
        }
        return valid;
    }

    public static int retrieveIntFromUser()
    {
        Scanner sc = new Scanner(System.in);
        int inSelection = -1;
        try
        {
            inSelection = sc.nextInt();
        }
        catch (Exception e)
        {
            System.out.println("Invalid value");
            sc.next();
        }
        return inSelection;
    }
}
