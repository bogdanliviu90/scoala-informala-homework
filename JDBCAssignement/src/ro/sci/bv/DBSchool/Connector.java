package ro.sci.bv.DBSchool;
import java.sql.*;

/**
 * This class holds the methods that realize to connection to the database and execute statements
 * This methods are used in the DBManager class, which is the main class
 *
 * @author Bogdan Butuza
 */
public class Connector {

    /**
     * This method realizes the connection to a certain database, based on the specified name, location, user and
     * password.
     * @param type a String variable, representing the database type: “mysql”, “db2”, “mssql”, “oracle”, ..
     * @param host a String variable, representing the physical device
     * @param port an int value, representing the access port
     * @param dbName a String value, meaning the title of the database we want to access
     * @param user a String value, standing for username
     * @param password a String value, representing the password for the current username
     * @return a Connection object, representing the open connection to the desired database, if it succeeds
     *         null, otherwise
     */
    public static Connection getConnection(String type, String host, int port, String dbName, String user,
                                           String password){
        DriverManager.setLoginTimeout(60);
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            String url = "jdbc:" + type + "://" + host + ":" + port + "/" + dbName + "?user=" + user + "&password=" +
                    password;
            return DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Cannot connect to the database: " + e.getMessage());
        }
        return null;
    }

    /**
     * This method is responsible for executing a certain query, formatting and printing the result to the console
     * After execution, it will close the actual connection
     * @param query a String value, representing the query to be executed in MySQL
     * @param connection a Connection object, meaning the actual connection which will be realized before this method
     */
    public static void executeQuery(String query, Connection connection) {
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result = statement.executeQuery(query);
            final String format = "%10s%10s%40s%50s%55s%20s%20s%15s%15s%20s%20s%20s%30s\n";
            boolean hasResult = result.next();
            if (hasResult) {
                System.out.format(format, "Class id", "Area", "Title", "Description", "Prerequisites", "Days",
                        "Start time", "End time", "Building", "Department", "Course number", "Room number",
                        "Professor name");
                do {
                    System.out.format(format,
                            result.getInt("classid"),
                            result.getString("area"),
                            result.getString("title"),
                            result.getString("descrip"),
                            result.getString("prereqs"),
                            result.getInt("days"),
                            result.getInt("starttime"),
                            result.getInt("endtime"),
                            result.getString("bldg"),
                            result.getString("dept"),
                            result.getInt("coursenum"),
                            result.getInt("roomnum"),
                            result.getString("profname"));

                } while (result.next());
            }
        } catch(SQLException e) {
            System.out.println("Cannot execute query: " + e.getMessage());
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    /**
     * This method is used only to inform the user regarding the available courses, in order to choose a desired course
     * It will be useful to be called before 'executeQuery' method, in the main method of DBManager
     * @param connection a Connection object, meaning the actual connection which will be realized before this method
     */
    public static void showCourses(Connection connection) {
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result = statement.executeQuery("SELECT courseid, title FROM courses;");
            final String format = "%10s%40s\n";
            boolean hasResult = result.next();
            if (hasResult) {
                System.out.format(format, "Course ID", "Title");
                do {
                    System.out.format(format,
                            result.getInt("courseid"),
                            result.getString("title"));
                } while (result.next());
            }
        } catch (SQLException e) {
            System.out.println("Cannot execute query: " + e.getMessage());
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
