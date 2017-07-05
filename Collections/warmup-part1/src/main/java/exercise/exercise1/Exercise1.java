package exercise.exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 1: Compute the sum, the minimum and the maximum element from a given list (givenList) using three
 *             different ways to iterate over a List:
 *             a) ListIterator (implement it in the iterateUsingListIterator() method)
 *             b) for loop (implement it in the iterateUsingForLoop() method)
 *             c) foreach loop (implement it in the iterateUsingForEachLoop() method)
 *
 *             In order to test your implementations you need to run the Exercise1Test from the test/java package
 *             (right-click on Exercise1Test class then click Run 'Exercise1Test' )
 */
public class Exercise1{

    // The list that contains some Integer values
    private List<Integer> givenList;

    public Exercise1(List<Integer> l) {
       this.givenList = l;
    }

    // TODO Exercise #1 a) Compute sum and get the min and the max from givenList, iterating through it using ListIterator
   public  int suma1() {
        int sum=0;
       ListIterator<Integer> it = givenList.listIterator();
       while (it.hasNext()) {
           sum+=it.next();

       }
       return sum;
   }

   public int max1(){

       ListIterator<Integer> it = givenList.listIterator();
       int max=givenList.get(0);
        while(it.hasNext()){
            int a= it.next();
            if(max <a){
                max = a;
            }

        }
        return max;
   }
    public int min1(){

        ListIterator<Integer> it = givenList.listIterator();
        int min=givenList.get(0);
        while(it.hasNext()){
            int a= it.next();
            if(min > a){
                min = a;
            }

        }
        return min;
    }


    public List<Integer> iterateUsingListIterator(){

        // This List is used only for testing so you don't have to modify it
        List<Integer> testValues = new ArrayList<Integer>();
        int sum ,max,min;
        sum= suma1();
        max= max1();
        min = min1();


        // TODO Exercise #1 a1) In order to pass the tests, you need to name your variables sum, min and max or if
        // TODO Exercise #1 a1) you want to name them differently you need to modify them when you add them to testValues



        // TODO Exercise #1 a2) Uncomment the following three lines in order to check your computed values using tests
          testValues.add(sum);
          testValues.add(min);
          testValues.add(max);

        return testValues;
    }

    // TODO Exercise #1 b) Compute the sum and get the min and the max from the even (RO: pare) positions in the list,

    // TODO Exercise #1 b) iterating through it using classic for loop


    public  int suma2() {

        int sum=0;
        for(int i=0; i<givenList.size();i++)
         {
             if(i%2==0)
            sum+=givenList.get(i);

        }
        return sum;
    }

    public int max2(){
        int max=Integer.MIN_VALUE;

        for(int i=0; i<givenList.size();i++)
        {
            if((i%2==0)&& max <givenList.get(i))
                max= givenList.get(i);

        }
        return max;
    }
    public int min2(){
        int min=Integer.MAX_VALUE;
        for(int i=0; i<givenList.size();i++)
        {
            if((i%2==0 && min >givenList.get(i)))
                min= givenList.get(i);

        }
        return min;
    }
    public List<Integer> iterateUsingForLoop(){

        // This List is used only for testing so you don't need to modify it
        List<Integer> testValues = new ArrayList<Integer>();
        int sum,min,max;
        sum=suma2();
        min=min2();
        max=max2();

        // TODO Exercise #1 b1) In order to pass the tests, you need to name your variables sum, min and max or if
        // TODO Exercise #1 b1) you want to name them differently you need to modify them when you add them to testValues



        // TODO Exercise #1 b2) Uncomment the following three lines in order to check your computed values using tests
        testValues.add(sum);
       testValues.add(min);
        testValues.add(max);

        return testValues;
    }

    // TODO Exercise #1 c) Compute the sum and get the min and the max from the odd (RO: impare) elements of the list
    // TODO Exercise #1 c) iterating through it using foreach loop

    public  int suma3() {

        int sum=0;
        for(int i : givenList)
        {
            if(i %2==1)
                sum+=i;

        }
        return sum;
    }
    public int max3(){
        int max=Integer.MIN_VALUE;

        for(int i : givenList)
        {
            if((i%2==1)&& max <i)
                max= i;

        }
        return max;
    }
    public int min3(){
        int min=Integer.MAX_VALUE;
        for(int i : givenList)
        {
            if((i%2==1)&& min >i)
                min= i;

        }
        return min;
    }



    public List<Integer> iterateUsingForEachLoop(){

        // This List is used only for testing so you don't need to modify it
        List<Integer> testValues = new ArrayList<Integer>();
        int sum,min,max;
        sum= suma3();
        min=min3();
        max=max3();

        // TODO Exercise #1 c1) In order to pass the tests, you need to name your variables sum, min and max or if
        // TODO Exercise #1 c1) you want to name them differently you need to modify them when you add them to testValues



        // TODO Exercise #1 c2) Uncomment the following three lines in order to check your computed values using tests
        testValues.add(sum);
        testValues.add(min);
        testValues.add(max);

        return testValues;
    }
}
