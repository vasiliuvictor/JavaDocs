package exercise3;

/**
 * Created by Andrei.Vasiliu on 7/7/2017.
 */
public class Student {


    private  String firstName;
    private  String lastName;

    public Student(){

    }



    public Student( String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;



    }



    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String toString() {
        return "First Name "+ this.firstName + " Last Name " + this.lastName +" Age ";
    }



}
