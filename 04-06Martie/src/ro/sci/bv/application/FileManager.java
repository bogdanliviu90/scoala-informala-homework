package ro.sci.bv.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * FileManager class holds the methods responsible for the Input/ Output from files
 * A FileManager instance is the one that can create Person objects - using Person class
 * It is used by Application class
 *
 * @author Bogdan Butuza
 */
public class FileManager {

    /**
     * Method readFile uses a try with resources block in order to read from a file, line by line, creating a list
     * of persons
     * Each line is splitted in three components, which will be hold in a String array temporary
     * With these components a new Person object is created for each line, from the begining of the file to the end of
     * it
     * @param fileName a String value, representing input file name
     * @return a list of Person objects, containing the persons read from the file
     */
    public List<Person> readFile(String fileName) {
        List<Person> myList = new ArrayList<>();

        Path file = Paths.get(fileName);
        Charset charset = Charset.forName("UTF8");

        try (BufferedReader input = Files.newBufferedReader(file, charset)) {
            String line;
            while ((line = input.readLine()) != null) {
                String[] word = line.split(", ");
                Person person = new Person(word[0], word[1], word[2]);
                myList.add(person);
            }
        } catch (IOException e) {
            System.out.println("Program was unable to open the file: " + e);
        }
        return myList;
    }

    /**
     * Method writeFile is used to write and store a given list of String in a new file, by using a try with resources
     * block
     *
     * @param myList a list of String objects, which represents the container of elements to be written in an output
     *               file
     * @param fileName a String value, representing output file name
     */
    public void writeFile(List<String> myList, String fileName) {
        Path file = Paths.get("04-06Martie\\Resources\\Ouput.txt");
        Charset charset = Charset.forName("UTF8");

        try (BufferedWriter output = Files.newBufferedWriter(file, charset)) {
            if (!myList.isEmpty()) {
                for (String line : myList) {
                    output.write(line);
                    output.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("The program was unable to write the file: " + e);
        }
    }
}