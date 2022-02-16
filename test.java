import java.util.*;
public class test {
    public static void main(String args[]) {
        // creating object of ArrayList class  
        ArrayList < String > list = new ArrayList < String > ();
        // adding elements to the ArrayList   
        list.add("Volkswagen FFFFFFFFF");
        list.add("Volkswagen Apple");
        list.add("Volkswagen Dog");
        list.add("Volkswagen EEEEEE");
        list.add("Volkswagen Cookie");
        list.add("Volkswagen Banananna");
        // printing the unsorted ArrayList   
        System.out.println("Before Sorting: " + list);
        // Sorting ArrayList in ascending Order   
        Collections.sort(list);
        // printing the sorted ArrayList   
        System.out.println("After Sorting: " + list);
    }
}