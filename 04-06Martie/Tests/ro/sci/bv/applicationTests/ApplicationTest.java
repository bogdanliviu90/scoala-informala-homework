package ro.sci.bv.applicationTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ro.sci.bv.application.Application;
import ro.sci.bv.application.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ApplicationTest {
    @Test
    void getNamesListEquals() {
        List<String> expectedList = Arrays.asList("Anne, Hopkins", "Peter, Jenkins");
        List<Person> actualList = new ArrayList<>();
        actualList.add(new Person("Peter","Jenkins","1992-02-09"));
        actualList.add(new Person("Anne","Hopkins","1990-02-19"));
        actualList.add(new Person("John", "Lennon", "1967-09-10"));
        Assertions.assertEquals(Application.getNamesList(actualList,2),expectedList);
    }

    @Test
    void validateMonthIsTrue() {
        boolean actual = Application.validateMonth(9);
        Assertions.assertTrue(actual);
    }

    @Test
    void validateMonthThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Application.validateMonth(14));
    }
}