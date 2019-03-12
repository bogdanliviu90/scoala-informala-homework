package ro.sci.bv.applicationTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ro.sci.bv.application.Person;



class PersonTest {

    private Person person1 = new Person("Peter", "Robinson", "1992-04-20");
    private Person person2 = new Person("Ana", "Jenkins",  "20/01/1990");

    @Test
    void checkMonthOfBirthEqualsGivenMonth() {
        boolean actual = person1.checkMonthOfBirth(4);
        Assertions.assertTrue(actual);
    }

    @Test
    void checkMonthOfBirthNotEqualsGivenMonth() {
        boolean actual = person2.checkMonthOfBirth(2);
        Assertions.assertFalse(actual);
    }

}