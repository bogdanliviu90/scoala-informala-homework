package ro.sci.bv.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Class Person defines the blueprint of a Person object, which holds the atributes of a real person (all as Strings):
 * - first name
 * - last name
 * - date of birth
 * Objects from this class will be instantiated when the program will do the file input/ lines reading
 * @author Bogdan Butuza
 */
public class Person {
    private String firstName;
    private String lastName;
    private String dateOfBirth;

    /**
     * This is the constructor for a Person object
     * @param firstName representing first name, as a String value
     * @param lastName representing first name, as a String value
     * @param dateOfBirth representing first name, as a String value
     */
    public Person(String firstName, String lastName, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * Method checkMonthOfBirth allows to verify if a person was born on a certain month
     * It takes the dateOfBirth from a Person, it converts it in a Date object and then compares it with the month to
     * be searched for - the one given as a parameter
     * It parses date as a String into a Date object, then it sets a Calendar object based on this date, in order to
     * extract month from it
     * @param month an integer value, representing the month to search for
     * @return true, if both values 'month form dateOfBirth' and 'month' corespond
     *         false, otherwise
     *         can also throw a ParseException, if a date is not written in a "yyyy-MM-dd" format or it is simply not
     *         available
     */
    public boolean checkMonthOfBirth(int month) {
        boolean checker = false;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(dateOfBirth);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int monthFromDate = calendar.get(Calendar.MONTH) + 1;
            if (month == monthFromDate) {
                checker = true;
            }
        } catch (ParseException e) {
            System.out.println("Error occured: Unavailable month found in the specified file. " + e);
        }
        return checker;
    }
}