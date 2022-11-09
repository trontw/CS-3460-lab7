import java.lang.Math;
import java.util.*;

public class PriorityDriver {
    private static Interval [] heap; // An array that encodes a max-heap data structure.
    /* 
     * First must build a heap to practice with.
     * The heap's elements will be interval objects.
     * 
     */
    public static void main(String[] args){
    //private Interval [] heap; // An array that encodes a max-heap data structure.
	//private int size;	// The size of allocated buffer for the heap.
	//private int numElements;	// The number of elements currently stored. 
    double i = 1.0;
    double j = 0.0;
    int s = 100;
    //int numElements = 15;
    PriorityQueue x = new PriorityQueue(s);
    //for (j = 2; j < s; j+=2)
    //    x.insert(new Interval(i, j));
    x.insert(new Interval(1, 2));
    x.insert(new Interval(2, 4));
    x.insert(new Interval(3, 8));
    x.insert(new Interval(4, 12));
    x.insert(new Interval(5, 16));
    x.insert(new Interval(6, 20));
    x.insert(new Interval(7, 24));
    x.insert(new Interval(8, 28));
    x.insert(new Interval(9, 32));
    x.insert(new Interval(10, 36));
    //System.out.println("The entire heap is");
    //x.print();
    Interval max = x.remove_max();
    System.out.println("The max is "+max);
    max = x.remove_max();
    System.out.println("The max is "+max);
    //max = x.remove_max();
    //System.out.println("The max is "+max);
    x.print();
    }
}

