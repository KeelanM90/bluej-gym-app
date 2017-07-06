
/**
 * This class is the template for a single Member.<br>
 * <br>
 * The details stored for a member include:<br>
 *      Member ID<br>
 *      Member Name<br>
 *      Member Address<br>
 *      Height (in metres)<br>
 *      Starting Weight (in kgs)<br>
 * <br>
 * Along with the standard, constructors, getters, setters and toString methods listed below, there are specific methods that:<br>
 * <br>
 *      - Convert the weight from KGs to Pounds<br>
 *      - Convert the height from Metres to Inches<br>
 *      - Determines if a start weight is ideal (based on the devine method)<br>
 *      - Calculates the BMI for the member<br>
 *      - Determines the BMI category based on their calculated BMI<br>
 *  
 * @author Keelan Murphy
 * @version 2017.02.13
 */
public class Member
{
    private int memberID;
    private String memberName;
    private String memberAddress;
    private double height;
    private double startingWeight;
    private String gender;

    /**
     * Constructor for objects of class Member
     * @param memberID The member's id is 6 digits long i.e. between 100000 (exclusive) and 999999(inclusive). If an invalid member id is entered, set the member id to a default value of 100000.
     * @param memberName The member's name should be no more than 30 characters. If the entered name exceeds 30 characters, the extra characters will be truncated and only the first 30 characters will be retained.
     * @param memberAddress There is no validation on the member's address.
     * @param height The member's height is measured in Metres. A minimum height of one metre (inclusive) is allowed and a maximum height of 3 three metres (inclusive).
     * @param startingWeight The member's weight upon joining the gym (in kgs). A minimum weight of 35kg (inclusive) and a max of 250kg (inclusive) is permitted in the gym.
     * @param gender The member's gender i.e. can be either "M" of "F". If not specified default to "Unspecified".
     */
    public Member(int memberID, String memberName, String memberAddress, double height, double startingWeight, String gender)
    {
        if (memberID > 100000 && memberID <= 999999)
        {
            this.memberID = memberID;
        }
        else
        {
            this.memberID = 100000;
        }

        if (memberName.length() <= 30)
        {
            this.memberName = memberName;
        }
        else
        {
            this.memberName = memberName.substring(0, 30);
        }

        this.memberAddress = memberAddress;

        if (height >= 1 && height <= 3)
        {
            this.height = height;
        }

        if (startingWeight >= 35 && startingWeight <= 250)
        {
            this.startingWeight = startingWeight;
        }

        gender = gender.toUpperCase();
        if (gender.equals("M") || gender.equals("F"))
        {
            this.gender = gender;
        }
        else
        {
            this.gender = "Unspecified";
        }
    }

    /**
     * This method calculates the BMI for the member.
     * @return the BMI value for the member. The number returned is truncated to two decimal places.
     */
    public double calculateBMI()
    {
        return toTwoDecimalPlaces((startingWeight / height) / height);
    }

    /**
     * This method returns the member height converted from metres to inches.
     * @return member height converted from metres to inches using the formula: metres multipled by 39.37. The number returned is truncated to two decimal places.
     */
    public double convertHeightMetresToInches()
    {
        double heightInInches = toTwoDecimalPlaces(height * 39.37);
        return heightInInches;
    }

    /**
     * This method returns the member weight converted from KGs to pounds.
     * @return member weight converted from KGs to pounds. The number returned is truncated to two decimal places.
     */
    public double convertWeightKGtoPounds()
    {
        double weightInPounds = toTwoDecimalPlaces(startingWeight * 2.2);
        return weightInPounds;
    }

    /**
     * This method determines the BMI category that the member belongs to.<br>
     * <br>
     * The category is determined by the magnitude of the members BMI according to the following:<br>
     * <br>
     *  BMI less than    15   (exclusive)                      is "VERY SEVERELY UNDERWEIGHT"<br>
     *  BMI between      15   (inclusive) and 16   (exclusive) is "SEVERELY UNDERWEIGHT"<br>
     *  BMI between      16   (inclusive) and 18.5 (exclusive) is "UNDERWEIGHT"<br>
     *  BMI between      18.5 (inclusive) and 25   (exclusive) is "NORMAL"<br>
     *  BMI between      25   (inclusive) and 30   (exclusive) is "OVERWEIGHT"<br>
     *  BMI between      30   (inclusive) and 35   (exclusive) is "MODERATELY OBESE"<br>
     *  BMI between      35   (inclusive) and 40   (exclusive) is "SEVERELY OBESE"<br>
     *  BMI greater than 40   (inclusive)                      is "VERY SEVERELY OBESE"<br>
     *  
     *  @return the BMI category that the member belongs to. 
     */
    public String determineBMICategory()
    {
        double bmi = calculateBMI();
        if (bmi < 15)
        {
            return "VERY SEVERELY UNDERWEIGHT";
        }
        else if (bmi >= 15 && bmi < 16)
        {
            return "SEVERELY UNDERWEIGHT";
        }
        else if (bmi >= 16 && bmi < 18.5)
        {
            return "UNDERWEIGHT";
        }
        else if (bmi >= 18.5 && bmi < 25)
        {
            return "NORMAL";
        }
        else if (bmi >= 25 && bmi < 30)
        {
            return "OVERWEIGHT";
        }
        else if (bmi >= 30 && bmi < 35)
        {
            return "MODERATELY OBESE";
        }
        else if (bmi >= 35 && bmi < 40)
        {
            return "SEVERELY OBESE";
        }
        else if (bmi >= 40)
        {
            return "VERY SEVERELY OBESE";
        }

        return "Error in BMI Calculation";
    }

    /**
     * Returns the member's height.
     * @return the member's height
     */
    public double getHeight()
    {
        return height;
    }

    /**
     * Returns the member's address.
     * @return the member's address
     */
    public String getMemberAddress()
    {
        return memberAddress;
    }

    /**
     * Returns the member's gender.
     * @return the member's gender
     */
    public String getMemberGender()
    {
        return gender;
    }

    /**
     * Returns the id for the member.
     * @return the member's id
     */
    public int getMemberId()
    {
        return memberID;
    }

    /**
     * Returns the member's name.
     * @return the member's name
     */
    public String getMemberName()
    {
        return memberName;
    }

    /**
     * Returns the member's starting weight.
     * @return the member's starting weight
     */
    public double getStartingWeight()
    {
        return startingWeight;
    }

    /**
     * This method returns a boolean to indicate if the member has an ideal body weight based on the Devine formula.<br>
     *  For males, an ideal body weight is:     50 kg + 2.3 kg for each inch over 5 feet.<br>
     *  For females, an ideal body weight is:   45.5 kg + 2.3 kg for each inch over 5 feet.<br>
     *  <br>
     *  Note: if no gender is specified, return the result of the female calculation
     *  
     *  @return Returns true if the result of the devine formula is within 2 kgs (inclusive) of the starting weight; false if it is outside this range.
     */
    public boolean isIdealBodyWeight()
    {
        double genderWeight = 0;

        double heightInInches = convertHeightMetresToInches();
        if (heightInInches < 60) 
        {
            heightInInches = 60;
        }

        if (gender.equals("M"))
        {
            genderWeight = 50;
        }
        else
        {
            genderWeight = 45.5;
        }

        double idealBodyWeight = genderWeight + ((heightInInches - 60) * 2.3);
        return (startingWeight >= (idealBodyWeight - 2) && startingWeight <= (idealBodyWeight + 2));
    }

    /**
     * Updates the member's gender field.
     * @param gender The member's gender i.e. can be either "M" of "F". All other values are ignored.
     */
    public void setGender(String gender)
    {
        gender = gender.toUpperCase();
        if (gender.equals("M") || gender.equals("F"))
        {
            this.gender = gender;
        }
    }

    /**
     * Updates the member's height field.
     * @param height The member's height is measured in Metres. A minimum height of one metre is allowed and a maximum height of three metres.
     */
    public void setHeight(double height)
    {
        if (height >= 1 && height <= 3)
        {
            this.height = height;
        }
    }

    /**
     * Updates the member's address field.
     * @param memberAddress There is no validation on the member's address.
     */
    public void setMemberAddress(String memberAddress)
    {
        this.memberAddress = memberAddress;
    }

    /**
     * Updates the member's id field.
     * @param id The member's id is 6 digits long i.e. between 100000 (exclusive) and 999999 (inclusive).
     */
    public void setMemberId(int id)
    {
        if (id > 100000 && id <= 999999)
        {
            this.memberID = id;
        }
    }

    /**
     * Updates the member's name field.
     * @param memberName The member's name should be no more than 30 characters. If the entered name exceeds 30 characters, the extra characters will be truncated and only the first 30 characters will be retained.
     */
    public void setMemberName(String memberName)
    {
        if (memberName.length() <= 30)
        {
            this.memberName = memberName;
        }
        else
        {
            this.memberName = memberName.substring(0, 30);
        }
    }

    /**
     * Updates the member's starting weight field.
     * @param startingWeight The member's weight upon joining the gym (in kgs). A minimum weight of 35kg (inclusive) and a max of 250kg (inclusive) is permitted in the gym. 
     */
    public void setStartingWeight(double startingWeight)
    {
        if (startingWeight >= 35 && startingWeight <= 250)
        {
            this.startingWeight = startingWeight;
        }
    }

    /**
     * Returns a human-readable String representation of the object state.<br>
     * @return a string version of the Member object. The string returned is similar to this structure:<br>
     * <br>
     * Member id: 123456, Name: Joe Soap, Address: 12 High Street, Waterford.<br>
     * Height: 2 metres, Starting Weight: 74kgs, BMI of 18.5 (NORMAL).<br>
     */
    public String toString()
    {
        return "Member id: " + memberID + ", Name: " + memberName + ", Address: " + memberAddress + ".\nHeight: " + height + " metres, Starting Weight: " + startingWeight + "kgs, BMI of " + calculateBMI() + " (" + determineBMICategory() + ").";
    }

    /**
     * Returns the double sent as an argument truncated to two decimal places.
     * @param num the number to be truncated to two decimal places
     * @return the input truncated to two decimal places
     */
    private double toTwoDecimalPlaces(double num)
    {
        return (int) (num * 100 ) / 100.0; 
    } 
}
