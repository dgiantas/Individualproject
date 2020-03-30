package mypackage;

import java.util.Objects;

public class Trainer {

    private static int count = 0;
    String firstName;
    String lastName;
    String subject;
    private int id;

    public Trainer() {
        setId(++count);
    }

    public Trainer(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
        setId(++count);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String name) {
        if (name != null) {
            firstName = name;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String surname) {
        if (surname != null) {

            lastName = surname;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setSubject(String sub) {
        if (sub != null) {
            subject = sub;
        }
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "Trainer{" + "firstName=" + firstName + ", lastName=" + lastName + ", subject=" + subject + ", id=" + id + '}';
    }

  

}
