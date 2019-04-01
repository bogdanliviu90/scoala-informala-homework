package ro.sci.bv.DBSchool;
import java.sql.Connection;
import java.util.Scanner;

/**
 * Class DBManager represents the main class of this application
 * It realizes the connections to the specified database, by calling the methods defined in Connector class
 * The user has to choose an option between 0 and 4, depending on his needs:
 * 1 - Display data for all classes
 * 2 - Display data for a course with specified id
 * 3 - Display data for all classes whose title (when converted to all lowercase letters) " +
 *                 "begins with 'intro'
 * 4 - Display data for all classes whose dept (when converted to all lowercase letters) is" +
 *                 " 'cos' and whose coursenum begins with '3'
 * 0 - Exit
 * Every task between 1 and 4 will be executed by calling the 'executeQuery' method of the Connector class, taking
 * as arguments a certain query and the current connection
 *
 * @author Bogdan Butuza
 */
public class DBManager {

    /**
     * This method prints the available options to the user, in order to optain a choice
     * @return an int value, representing users choice
     */
    private static int chooseOption() {
        System.out.println("Choose one option:");
        System.out.println("1 - Display data for all classes");
        System.out.println("2 - Display data for a course with specified id");
        System.out.println("3 - Display data for all classes whose title (when converted to all lowercase letters) " +
                "begins with 'intro'");
        System.out.println("4 - Display data for all classes whose dept (when converted to all lowercase letters) is" +
                " 'cos' and whose coursenum begins with '3'");
        System.out.println("0 - Exit \n");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Your option is: ");
        return keyboard.nextInt();
    }

    public static void main(String[] args) {
        Connection connection = Connector.getConnection("mysql", "localhost", 3306,
                "school", "root", "Bbogdi28LIV");
        if (connection != null) {
            int opt = chooseOption();
            while (opt != 0) {
                switch (opt) {
                    case 1:
                        Connector.executeQuery("SELECT classid, area, title, descrip, prereqs, days, starttime, " +
                                "endtime, bldg, roomnum, dept, coursenum, profname \n" +
                                "FROM courses, classes, crosslistings, coursesprofs, profs\n" +
                                "WHERE courses.courseid = classes.courseid " +
                                "AND courses.courseid = crosslistings.courseid \n" +
                                "AND courses.courseid = coursesprofs.courseid " +
                                "AND coursesprofs.profid = profs.profid\n" +
                                "ORDER BY classid;", connection);
                        break;
                    case 2:
                        // First showing the available courses, to let the user choose one of them
                        Connector.showCourses(connection);
                        Scanner input = new Scanner(System.in);
                        System.out.println("For more information, please choose a course id from above: ");
                        int id = input.nextInt();
                        Connector.executeQuery("SELECT classid, area, title, descrip, prereqs, days, " +
                                "starttime, endtime, bldg, roomnum, dept, coursenum, profname \n" +
                                "FROM courses, classes, crosslistings, coursesprofs, profs\n" +
                                "WHERE courses.courseid = " + id + " " +
                                "AND courses.courseid = classes.courseid " +
                                "AND courses.courseid = crosslistings.courseid \n" +
                                "AND courses.courseid = coursesprofs.courseid " +
                                "AND coursesprofs.profid = profs.profid\n" +
                                "ORDER BY classid;", connection);
                        break;
                    case 3:
                        Connector.executeQuery("SELECT classid, area, title, descrip, prereqs, days, " +
                                "starttime, endtime, bldg, roomnum, dept, coursenum, profname \n" +
                                "FROM courses, classes, crosslistings, coursesprofs, profs\n" +
                                "WHERE LOWER(title) LIKE 'intro%' " +
                                "AND courses.courseid = classes.courseid " +
                                "AND courses.courseid = crosslistings.courseid \n" +
                                "AND courses.courseid = coursesprofs.courseid " +
                                "AND coursesprofs.profid = profs.profid\n" +
                                "ORDER BY classid;", connection);
                        break;
                    case 4:
                        Connector.executeQuery(
                                "SELECT classid, area, title, descrip, prereqs, days, starttime, endtime, \n" +
                                "bldg, roomnum, dept, coursenum, profname \n" +
                                "FROM courses, classes, crosslistings, coursesprofs, profs\n" +
                                "WHERE LOWER(dept) = 'cos' AND coursenum LIKE '3%' " +
                                        "AND courses.courseid = classes.courseid " +
                                "AND courses.courseid = crosslistings.courseid " +
                                        "AND courses.courseid = coursesprofs.courseid " +
                                "AND coursesprofs.profid = profs.profid \n" +
                                        "ORDER BY classid;", connection);
                    default:
                        System.out.println("Please choose an option between 0-4!");
                }
                opt = chooseOption();
            }
        }
    }
}
