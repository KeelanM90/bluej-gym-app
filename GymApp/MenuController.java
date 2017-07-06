import java.util.Scanner;

/**
 * This class controls the Gym application. It displays the following
 * basic menu for the Gym and processes the user input.<br>
 *  <br>
 *  Gym Menu<br>
 *  _________<br>
 *  <br>
 *  1) Add a member<br>
 *  2) List all members<br>
 *  3) Remove a member (by index)<br>
 *  4) Number of members in the gym<br>
 *  _________<br>
 *  5) List gym details<br>
 *  6) List members with ideal starting weight<br>
 *  7) List members with a specific BMI category<br>
 *  8) List all members stats imperically and metrically<br>
 *  0) Exit<br>
 *  ==>><br>
 *  
 *
 * @author Keelan Murphy 
 * @version 2017.02.14
 */
public class MenuController
{
    private Scanner input;
    private Gym gym;
    
    /**
     * The default constructor. The constructor creates an instance of the scanner class. 
     * It also asks the user to enter the gym name, manager name and gym phone number. 
     * These details are used to create an instance of the gym. The final task in the 
     * constructor is to run the menu.
     */
    public MenuController()
    {
        input = new Scanner(System.in);
        
        System.out.println("\fPlease enter the Gym...");
        System.out.print("        Name: ");
        String gymName = input.nextLine();
        System.out.print("        Manager name: ");
        String managerName = input.nextLine();
        System.out.print("        Phone number: ");
        String phoneNumber = input.nextLine();
        
        gym = new Gym(gymName, managerName, phoneNumber);
        
        runMenu();
    }
    
    /**
     * mainMenu() - This method displays the menu for the application, 
     * reads the menu option that the user entered and returns it.
     * 
     * @return     the users menu choice
     */
    private int mainMenu()
    { 
        System.out.println("\fGym Menu");
        System.out.println("---------");     
        System.out.println("  1) Add a member");    
        System.out.println("  2) List all members");        
        System.out.println("  3) Remove a member (by index)");    
        System.out.println("  4) Number of members in the gym");        
        System.out.println("---------");     
        System.out.println("  5) List gym details"); 
        System.out.println("  6) List members with ideal starting weight"); 
        System.out.println("  7) List members with a specific BMI category"); 
        System.out.println("  8) List all members stats imperically and metrically"); 
        System.out.println("  0) Exit");
        System.out.print("==>> ");
        int option = input.nextInt();
        return option;
    }
    
    /**
     * This is the method that controls the loop 
     */
    private void runMenu()
    {
        int option = mainMenu();
        while (option != 0)
        {  
            switch (option)
            {
                case 1:    
                    addMember();
                    break;
                case 2:
                    if (gym.numberOfMembers() > 0)
                    {
                        System.out.println(gym.listMembers());
                    }
                    else 
                    {
                        System.out.println("There are no members in the gym");
                    }
                    break;
                case 3:
                    System.out.println(gym.listMembers());
                    System.out.print("Index of member to delete ==>  ");
                    int index = input.nextInt();
                    if (gym.numberOfMembers() > index)
                    {
                        gym.remove(index);
                        System.out.println("Member deleted.");
                    }
                    else
                    {
                        System.out.println("There is no member for this index number");
                    }
                    break;
                case 4:   
                    System.out.println("Number of members: " + gym.numberOfMembers());
                    break;
                case 5:
                    System.out.println(gym.toString());
                    break;
                case 6:
                    System.out.println(gym.listMembersWithIdealWeight());
                    break;
                case 7:
                    System.out.print("Please enter the category to search by: ");
                    input.nextLine();
                    String category = input.nextLine();
                    System.out.println(gym.listBySpecificBMICategory(category));
                    break;
                case 8:
                    System.out.println(gym.listMemberDetailsImperialAndMetric());
                    break;
                default:    
                    System.out.println("Invalid option entered: " + option);
                    break;
            }
            System.out.println("\nPress enter to continue...");
            input.nextLine();
            input.nextLine(); 
            option = mainMenu();
        }
        System.out.println("Exiting... bye");
        System.exit(0);
    }
    
    /**
     * gather the member data from the user and create a new member.
     */
    private void addMember()
    {  
        input.nextLine();
        System.out.println("Please enter the following member details...");
        System.out.print("\tId (between 100001 and 999999):  ");
        int memberID = input.nextInt();
        System.out.print("\tName (max 30 chars):  ");
        input.nextLine();
        String memberName = input.nextLine();
        System.out.print("\tAddress:  ");
        String memberAddress = input.nextLine();
        System.out.print("\tHeight (between 1 and 3 metres):  ");
        double height = input.nextDouble();
        System.out.print("\tStarting Weight (between 35kg and 250kg):  ");
        double startingWeight = input.nextDouble();
        System.out.print("\tGender (M/F):  ");
        input.nextLine();
        String gender = input.nextLine();
       
        gym.add(new Member(memberID, memberName, memberAddress, height, startingWeight, gender));
    }
}
