package exercise.exercise0;
import java.util.*;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Create a List (ArrayList or LinkedList), add elements to it and print all of them using ListIterator
 *             for loop and foreach loop.
 *
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughList(){

        // TODO Exercise #0 a) Create a list (ArrayList or LinkedList) and add elements to it
        ArrayList<Integer> pets = new ArrayList();
        pets.add(10);
        pets.add(20);
        pets.add(30);
        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)

        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements

        ListIterator<Integer> it = pets.listIterator();
        while(it.hasNext()) {
            System.out.println(it.next() + "(Iterator )," + it.nextIndex() + "," +it.previousIndex() +";");

        }
        // TODO Exercise #0 c) Iterate through the list using classic for loop and print all its elements

        for(int i =0; i<pets.size();i++){

            System.out.println("Numerele sunt (Classic method)" + pets.get(i));
        }
        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
        for(int array : pets){
            System.out.println("Numere (foreach method): " + array);

        }
    }

    public static void main(String[] args) {
        Exercise0 e0 = new Exercise0();
        e0.iterateThroughList();

        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
    }
}
