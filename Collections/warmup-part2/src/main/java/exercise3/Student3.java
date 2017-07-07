package exercise3;

/**
 * Created by Andrei.Vasiliu on 7/7/2017.
 */
public class Student3 extends Student {
    public  Student3(String firstName, String lastName){
        super(firstName,lastName);

    }

    @Override
    public boolean equals(Object o) {
        if( o instanceof Object)
            return true;
        if (o == null)
            return false;
        if (o.getClass().equals(this.getClass()))
            return true;



        Student1 stud = (Student1) o;


        if(  getFirstName().equals(stud.getFirstName()))

            return true;

        return false;

    }
    public int hashCode() {
        int result ;
        result =  getFirstName().hashCode() +getLastName().hashCode();
        return result;


    }
    public String toString() {
        return "First Name "+ this.getFirstName() + " Last Name " + this.getLastName() + " Age ";
    }
}
