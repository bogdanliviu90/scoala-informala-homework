package ro.sci.bv.application;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This program inputs a list of persons and outputs another list, based on the month criteria
 * The outputted list must contain the names of the persons born in a certain month, which will be given by the user
 * <p>
 * The Application class represents the main class of the program
 * It simply calls the other classes - Person and FileManager, in order to compute the final result:
 * a list containing a structure like "first name, last name" for the persons born in the given month.
 * The month will be read from keyboard
 *
 * @author Bogdan Butuza
 */
public class Application {

    /**
     * Method getNamesList simply takes a list of persons and creates another list, based on the month criteria
     * (month from date of birth should equal the inputted month)
     *
     * @param persons a list of Person objects, representing the list to be processed
     * @param month   an integer value (between 1 and 12), meaning the given month
     * @return a new list of Person objects, representing the desired result
     */
    public static List<String> getNamesList(List<Person> persons, int month) {
        return persons.stream()
                .filter(s -> s.checkMonthOfBirth(month))
                .map(p -> p.getFirstName() + ", " + p.getLastName())
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Method validateMonth checks if the inputted month is valid
     * It should contain a value between 1 and 12
     *
     * @param month an integer value, representing the month
     * @return true, if the month is valid
     *         throws IllegalArgumentException - handled in main method, otherwise
     */
    public static boolean validateMonth(int month) {
        if (month >= 1 && month <= 12) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Method runApplication puts together the most important methods of the program
     * It does the following steps:
     * - creates a FileManager object, to set the begining of the IO process
     * - creates a list of persons(Person objects) by realizing the input process and creating Person objects
     * - works with the list of persons and stores the result in another list
     * - the newly created list (if it's not empty) is written in a new file
     * In the final, it prints a message to the console in order to inform the user that operation succeded
     * If it doesn't succed, it informs the user that the file may be empty or no match was found
     *
     * @param month the month to look for, as an integer value
     */
    public static void runApplication(int month) {
        FileManager manager = new FileManager();
        List<Person> persons = manager.readFile("04-06Martie\\Resources\\Input.txt");
        List<String> names = getNamesList(persons, month);
        if (!names.isEmpty()) {
            manager.writeFile(names, "04-06Martie\\Resources\\Output.txt");
            System.out.println("The file was successfully created!");
        } else {
            System.out.println("No persons matching month " + month + " were found or the file is empty!");
        }
    }

    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(System.in);
            boolean isDone = false;

            do {
                System.out.print("Please insert a value for month (1-12): ");
                int month = keyboard.nextInt();

                if (validateMonth(month)) {
                    runApplication(month);
                    isDone = true;
                }
            } while (!isDone);
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("Month should be an integer value between 1 and 12! Please try again");
        }
    }
}