package ch.swth.lambda;

import java.util.Objects;

public class Person {
    private String firstname;
    private String lastname;
    private String placeOfBirth;

    public Person(String firstname, String lastname, String placeOfBirth) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.placeOfBirth = placeOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstname, person.firstname) &&
                Objects.equals(lastname, person.lastname) &&
                Objects.equals(placeOfBirth, person.placeOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, placeOfBirth);
    }
}
