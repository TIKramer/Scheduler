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
                System.out.println(event);
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
       
        int inHours = -1;
        int inMinutes = -1;
        String inDate = "";

      /*  while (!validateYear(inYear))
        {
            System.out.println("Please Enter a Year:");
            inYear = retrieveIntFromUser();
            if (!validateYear(inYear))
            {
                System.out.println("Invalid year input(Year must be current year or above and in format YYYY)");
            }
        }

        while (!validateMonth(inMonth))
        {
            System.out.println("Please Enter a Month:");
            inMonth = retrieveIntFromUser();
            if (!validateMonth(inMonth))
            {
                System.out.println("Invalid Month input(Month must be between 1 to 12 and in format MM or M)");
            }
        }

        while (!validateDay(inYear, inMonth, inDay))
        {
            System.out.println("Please Enter a Day:");
            inDay = retrieveIntFromUser();
            if (!validateDay(inYear, inMonth, inDay))
            {
                System.out.println("Invalid day input(Day must be a valid day for the month in the format DD or D)");
            }
        }*/
        Date getDate = new Date();
        boolean validYear = false;
        boolean validMonth = false;
        boolean validDay = false;

        while(!validYear){
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
        while(!validMonth){
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
        while(!validDay){
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

        // Month -1 as GregorianCaladar months start from 0 not 1
        GregorianCalendar date = new GregorianCalendar(getDate.getYear(), (getDate.getMonth() - 1), getDate.getDay());
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

    public static boolean validateYear(int inYear)
    {
        boolean valid = false;
        GregorianCalendar currentDate = new GregorianCalendar();
        if (inYear >= currentDate.get(Calendar.YEAR))
        {
            valid = true;
        }
        return valid;
    }

    // Will have to formate month to add extra 0
    public static boolean validateMonth(int inMonth)
    {
        boolean valid = false;
        if (inMonth >= 1 && inMonth <= 12)
        {
            valid = true;
        }
        return valid;
    }

    public static boolean validateDay(int inYear, int inMonth, int inDay)
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
                if (isLeapYear == true)
                {
                    numOfDaysInMonth = 29;
                }
                else
                {
                    numOfDaysInMonth = 28;
                }
            default:
                // exit();
                break;
        }

        if (inDay >= 1 && inDay <= numOfDaysInMonth)
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

    public static String retrieveTimeFromUser()
    {
        Scanner sc = new Scanner(System.in);
        int inHours = -1;
        int inMinutes = -1;
        String inTime = "";
        boolean valid = false;
        while (!valid)
        {
            System.out.println("Please enter a time in the format hh:mm");
            try
            {
                inTime = sc.next();
            }
            catch (Exception e)
            {
                System.out.println("Invalid value");
                sc.next();
            }

            if (inTime.length() == 5)
            {
                char[] charArrayOfInTime = inTime.toCharArray();
                if (charArrayOfInTime[2] == ':')
                {
                    try
                    {
                        inHours = (Character.getNumericValue(charArrayOfInTime[0]) * 10)
                                + (Character.getNumericValue(charArrayOfInTime[1]));
                        inMinutes = (Character.getNumericValue(charArrayOfInTime[3]) * 10)
                                + (Character.getNumericValue(charArrayOfInTime[4]));
                    }
                    catch (Exception e)
                    {
                        System.out.println("Invalid value");

                    }
                    inTime = "" + charArrayOfInTime[0] + charArrayOfInTime[1] + charArrayOfInTime[3]
                            + charArrayOfInTime[4];
                }
            }
            if (validateHours(inHours) && validateMinutes(inMinutes))
            {
                valid = true;
            }
        }
        return inTime;
    }
}
