package ro.teamnet.zth.web;

/**
 * Created by Andrei.Vasiliu on 7/18/2017.
 */
public class Person {

    public String firstname;
    public String lastname;
    public long age;
    public boolean married;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public long getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public Person(String firstname, String lastname, long age, boolean married) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.married = married;
    }
}