import java.util.Scanner;

public class UserInput
{
    Scanner sc;

    public UserInput()
    {
        sc = new Scanner(System.in);
    }

    public int readInt(String message)
    {
        System.out.println(message);
        int value = -1;
        try
        {
            value = sc.nextInt();
            sc.nextLine();
        }
        catch (Exception e)
        {
            System.out.println("Invalid value");
            sc.next();
        }
        return value;
    }
    
    public String readString(String message)
    {
        System.out.println(message);
        String value = sc.nextLine();
        return value;
    }
  

}
