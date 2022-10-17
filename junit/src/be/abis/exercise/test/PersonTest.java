package be.abis.exercise.test;

import be.abis.exercise.exception.PersonShouldBeAdultException;
import be.abis.exercise.model.Person;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonTest {
    private Person person1;
    private Person person2;

    @BeforeEach
    void setUp(){
        person1 = new Person(1, "Jana", "Heitkemper", LocalDate.of(1980, 9, 3));
        person2 = new Person(2, "Jan", "Heitkemper", LocalDate.of(2006, 9, 3));
    }

    @Test
    @Order(2)
    public void person1ShouldBe42YearsOld() throws PersonShouldBeAdultException {
        assertThat(person1.calculateAge(), equalTo(42));
    }

    @Test
    @Order(1)
    public void toStringStartsWithPerson(){
        assertThat(person1.toString(), startsWith("Person"));
    }

    @Test
    @Order(3)
    public void throwsPersonShouldBeAdultException(){
        assertThrows(PersonShouldBeAdultException.class, () -> person2.calculateAge());
    }


}
