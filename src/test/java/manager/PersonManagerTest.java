package manager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import person.Person;

import static org.junit.jupiter.api.Assertions.*;

class PersonManagerTest {
  PersonManager pm;

  @BeforeEach
  void setUp() {
    pm = new PersonManager();
  }

  @Test
  @DisplayName("A valid person should be added")
  void shouldCreatePerson() throws IllegalAccessException {
    Person p = new Person("Subir", "Adhikari", "9153077226");
    pm.addPerson(p);
    Assertions.assertTrue(pm.getAllPersons().size() > 0);
    assertNotEquals(0, pm.getAllPersons().size());
  }

  @Test
  @DisplayName("A person with invalid name should not be added")
  void shouldNotCreatePerson() throws IllegalAccessException {
    Person p = new Person("", "Adhikari", "9153077226");
    pm.addPerson(p);
    Assertions.assertFalse(pm.getAllPersons().size() > 0);
    assertEquals(0, pm.getAllPersons().size());
  }

  @ParameterizedTest
  @ValueSource(strings = {"123", "02122", ""})
  @DisplayName("A person with invalid phone number should not be added")
  void shouldNotCreatePersonWithInvalidNumber(String phNum) throws IllegalAccessException {
    Person p = new Person("", "Adhikari", phNum);
    pm.addPerson(p);
    Assertions.assertFalse(pm.getAllPersons().size() > 0);
    assertEquals(0, pm.getAllPersons().size());
  }

  @AfterEach
  void tearDown() {
    System.out.println("Test ended");
  }
}

