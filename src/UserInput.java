import java.util.Scanner;
/****************************************************************
 * Author: Thomas Kramer                                        *
 * Purpose: Retrieve input from user                            *
 * Date: 15/04/2016 3:23apm                                     *
 ***************************************************************/
public class UserInput
{
    Scanner sc;
/*********************************************************************
*Default Constructor:                                                *
*Purpose: To construct a default object of Date                      *
*Date: 22/05/2016 9:31pm                                             *
*IMPORT: none                                                        *
*EXPORT: address of new UserInput object                             *    
*ASSERTION: default Scanner object is the default state for UserInput*                                              *       
*********************************************************************/
    public UserInput()
    {
        sc = new Scanner(System.in);
    }
     /*******************************************************************
     * SUBMODULE: readInt                                               * 
     * Purpose: To read an int from user and return it                  *
     * Date: 22/05/2016 9:31pm                                          *
     * IMPORT: message (String)                                         *
     * EXPORT: value (int)                                              *
     * ASSERTION:                                                       *
     *******************************************************************/
    
    public int readInt(String message)
    {
        System.out.println(message);
        int value = -1;
        try
        {
            value = sc.nextInt();
            sc.nextLine();
        }
        catch (IllegalArgumentException  e)
        {
            System.out.println("Invalid value");
            sc.next();
        }
        return value;
    }
    /*******************************************************************
     * SUBMODULE: readString                                              * 
     * Purpose: To read an String from user and return it                  *
     * Date: 22/05/2016 9:31pm                                          *
     * IMPORT: message (String)                                         *
     * EXPORT: value (String)                                              *
     * ASSERTION:                                                       *
     *******************************************************************/
    public String readString(String message)
    {
        System.out.println(message);
        String value = sc.nextLine();
        return value;
    }
  

}
