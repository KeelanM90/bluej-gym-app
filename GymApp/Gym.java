import java.util.ArrayList;

/**
 * This class handles a collection of Member classes.<br>
 * <br>
 * The details stored for a gym include:<br>
 *      Gym name<br>
 *      Manager name<br>
 *      Phone number<br>
 *      An Arraylist collection of its Members<br>
 * <br>
 * Along with the standard constructors, getters, 
 * setters and toString methods listed below, there are specified methods that:<br>
 * <br>
 *          - List all the members that have an ideal starting weight.<br>
 *          - List all the members of a specified BMI category.<br>
 *          - List all the members' weight and height both imperically and metrically.
 * 
 * @author Keelan Murphy
 * @version 2017.02.13
 */
public class Gym
{
    String gymName;
    String managerName;
    String phoneNumber;
    ArrayList<Member> members;

    /**
     * Constructor for objects of class Gym. Within this constructor, the phone number instance field is set to unknown and the Arraylist is instantiated.
     * @param gymName The gym name must be no more than 30 characters. If the entered name exceeds 30 characters,the extra characters will be truncated and only the first 30 characters will be retained.
     * @param managerName No validation is performed on the manager name field.
     */
    public Gym(String gymName, String managerName)
    {
        if (gymName.length() <= 30)
        {
            this.gymName = gymName;
        }
        else
        {
            this.gymName = gymName.substring(0, 30);
        }

        this.managerName = managerName;
        phoneNumber = "Unknown";
        members = new ArrayList<Member>();
    }

    /**
     * Constructor for objects of class Gym. Within this constructor, the Arraylist is instantiated.
     * @param gymName The gym name must be no more than 30 characters. If the entered name exceeds 30 characters,the extra characters will be truncated and only the first 30 characters will be retained.
     * @param managerName No validation is performed on the manager name field.
     * @param phoneNumber A check is done on the phone number to ensure that it is a number. If the phone number is not a number, it is set to "unknown".
     */
    public Gym(String gymName, String managerName, String phoneNumber)
    {
        if (gymName.length() <= 30)
        {
            this.gymName = gymName;
        }
        else
        {
            this.gymName = gymName.substring(0, 30);
        }

        this.managerName = managerName;

        if (phoneNumber.matches("[-+]?\\d*\\.?\\d+"))
        {
            this.phoneNumber = phoneNumber;
        }
        else
        {
            this.phoneNumber = "unknown";
        }

        members = new ArrayList<Member>();
    }

    /**
     * Adds a member to the gym collection.
     * @param member The member object that will be added to the gym collection 
     */
    public void add(Member member)
    {
        members.add(member);
    }

    /**
     * Returns the name of the gym.
     * @return the gym name
     */
    public String getGymName()
    {
        return gymName;
    }

    /**
     * Returns the name of the manage.
     * @return the manager name
     */
    public String getManagerName()
    {
        return managerName;
    }

    /**
     * Returns the phone number of the gym.
     * @return the gym phone number
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    /**
     * List all the members of a specific BMI category.
     * @param category The category you wish to search members by.
     * <br>
     * The specific categories are:<br>
     *      "VERY SEVERELY UNDERWEIGHT"<br>
     *      "SEVERELY UNDERWEIGHT"<br>
     *      "UNDERWEIGHT"<br>
     *      "NORMAL"<br>
     *      "OVERWEIGHT"<br>
     *      "MODERATELY OBESE"<br>
     *      "SEVERELY OBESE"<br>
     *      "VERY SEVERELY OBESE"<br>
     *      <br>
     * This method also allows you to search by key words e.g. "OBESE" will return members in the following categories:<br>
     *      "MODERATELY OBESE"<br>
     *      "SEVERELY OBESE"<br>
     *      "VERY SEVERELY OBESE"<br> 
     * Note: In this situation, the members are NOT sorted by category, they are just diplayed as is.<br>
     * 
     * @return The list of members whose BMI falls into the category passed as a parameter
     * 
     * If there are no members in the BMI category, the message<br>
     *      "There are no members in the gym in this BMI category" should be returned.<br>
     *      <br>
     * If there are no members in the gym, the message<br>
     *      "There are no members in the gym" should be returned.<br>
     */
    public String listBySpecificBMICategory(String category)
    {
        if (members.size() > 0)
        {
            String specificBMIList = "";
            for (Member member : members)
            { 
                if (member.determineBMICategory().contains(category))
                {
                    specificBMIList = specificBMIList + member.toString() + "\n";
                }
            }
            if (specificBMIList.length() > 0)
            {
                return specificBMIList;
            }
            else
            {
                return "There are no members in the gym in this BMI category";
            }
        }
        else
        {
            return "There are no members in the gym";
        }
    }

    /**
     * List all the members' weight and height both imperically and metrically.
     * @return Each member in the gym with the weight and height listed both imperically and metrically.
     * 
     *  The format of the output is like so:<br>
     *  <br>
     *      Joe Soap:       xx kg (xxx lbs) x.x metres (xx inches)<br>
     *      Joan Soap:      xx kg (xxx lbs) x.x metres (xx inches)<br>
     *      <br>
     *  If there are no members in the gym, the message<br>
     *      "There are no members in the gym" should be returned
     */
    public String listMemberDetailsImperialAndMetric()
    {
        if (members.size() > 0)
        {
            String memberDetails = "";
            for (Member member : members)
            { 
                memberDetails = memberDetails + member.getMemberName() + "     " + member.getStartingWeight() + " kg  (" + member.convertWeightKGtoPounds() + "lbs) " + member.getHeight() + "metres (" + member.convertHeightMetresToInches() + " inches )\n";
            }
            return memberDetails;
        }
        else
        {
            return "There are no members in the gym";
        }
    }

    /**
     * Returns a String representing all the members stored in the gym collection.
     * @return String representing all the members stored in the gym collection. The String returned is similar to this structure, with the preceeding number representing the index number of the member within the collection:
     * 
     *      0: member's toString() format<br>
     *      1: member's toString() format<br>
     *      2: member's toString() format<br>
     */
    public String listMembers()
    {
        String listMembers = "";
        for (int i = 0; i < members.size(); i++)
        {
            listMembers = listMembers + i + ": " + members.get(i).toString() + "\n";
        }
        return listMembers;
    }

    /**
     * List all the members that have an ideal starting weight.
     * @return The list of members (i.e. use the toString method here) that have an ideal starting weight based on the devine method.
     * 
     * If there are no members with an ideal starting weight, the message<br>
     *      "There are no members in the gym with an ideal weight" should be returned.<br>
     * <br>
     * If there are no members in the gym, the message<br>
     *      "There are no members in the gym" should be returned
     */
    public String listMembersWithIdealWeight()
    {
        if (members.size() > 0)
        {
            String listMembersWithIdealWeight = "";
            for (Member member : members)
            { 
                if (member.isIdealBodyWeight())
                {
                    listMembersWithIdealWeight = listMembersWithIdealWeight + member.toString() + "\n";
                }
            }
            if (listMembersWithIdealWeight.length() > 0)
            {
                return listMembersWithIdealWeight;
            }
            else
            {
                return "There are no members in the gym with an ideal weight";
            }
        }
        else
        {
            return "There are no members in the gym";
        }
    }

    /**
     * Returns the number of members stored in the gym collection.
     * @return The number of the member object currently stored in the gym collection
     */
    public int numberOfMembers()
    {
        return members.size();
    }

    /**
     * Removes a member from the gym collection.
     * @param index The index number of the member object that will be removed from the gym collection
     */
    public void remove(int index)
    {
        members.remove(index);
    }

    /**
     * Updates the gym name.
     * @param gymName The gym name must be no more than 30 characters. If the entered name exceeds 30 characters,the extra characters will be truncated and only the first 30 characters will be retained.
     */
    public void setGymName(String gymName)
    {
        if (gymName.length() <= 30)
        {
            this.gymName = gymName;
        }
        else
        {
            this.gymName = gymName.substring(0, 30);
        }
    }

    /**
     * Updates the manager name field.
     * @param managerName No validation is performed on the manager name field.
     */
    public void setManagerName(String managerName)
    {
        this.managerName = managerName;
    }

    /**
     * Updates the gym phone number field.
     * @param phoneNumber A check is done on the phone number to ensure that it is a number. If the phone number is not a number, the field is not updated.
     */
    public void setPhoneNumber(String phoneNumber)
    {
        if (phoneNumber.matches("[-+]?\\d*\\.?\\d+"))
        {
            this.phoneNumber = phoneNumber;
        }
    }

    /**
     * Returns a human-readable String representation of the object state.
     * @return a String version of the Gym object. The String returned is similar to this structure:
     * 
     *      Gym name: High Flyer Gym, Manager: Eddie the Eagle, Phone Number: 0519665654343.<br>
     *      <br>
     *      List of members in the gym:<br>
     *      (List all of the members here)
     */
    public String toString()
    {
        String gymString = "Gym name: " + gymName + ", Manager:" + managerName + ", Phone Number: " + phoneNumber + "\n\n List of Members in the gym:\n";
        for (int i = 0; i < members.size(); i++)
        {
            gymString = gymString + members.get(i).toString() + "\n";
        }
        return gymString;
    }
}
