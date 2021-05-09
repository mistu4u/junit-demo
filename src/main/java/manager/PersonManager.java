package manager;

import person.Person;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PersonManager {
  Map<String, Person> person = new ConcurrentHashMap<>();

  public Map<String, Person> getAllPersons() {
    return person;
  }

  public void addPerson(Person p) {
    boolean isValid = validatePerson(p);
    if (isValid && (!(person.containsKey(generateKey(p))))) {
      person.put(generateKey(p), p);
    }
  }

  private boolean validatePerson(Person p) {
    boolean vn = isNameValid(p.getFirstName(), p.getLastName());
    boolean vpn = isPhoneNumberValid(p.getPhoneNumber());
    return vn && vpn;
  }

  private boolean isPhoneNumberValid(String phoneNumber) {
    return phoneNumber.length() == 10;
  }

  private boolean isNameValid(String firstName, String lastName) {
    return !(firstName.isEmpty() || lastName.isEmpty() || firstName.trim().length() == 0
            || lastName.trim().length() == 0);
  }

  private String generateKey(Person p) {
    return String.format("%s-%s", p.getLastName(), p.getLastName());
  }
}
