import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args){

        int k = 8;//Integer.parseInt(args[0]);


        RandomizedQueue<String> rq = new RandomizedQueue();

        In in =  new In("E:\\Kronshtadt\\Algorithms and data structure\\Homework\\Lesson3\\StacksAndQueues\\src\\queues\\duplicates.txt");

        for (int i=0;i<k;i++){
            rq.enqueue(in.readString());
        }

        for (String item:rq
             ) {
            System.out.println(item);
        }
    }
}