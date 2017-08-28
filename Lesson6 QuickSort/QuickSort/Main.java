import edu.princeton.cs.algs4.Stopwatch;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int N=10;
        Comparable[] a = new Comparable[N];
        Comparable[] checked = new Comparable[N];
        Random r = new Random();
        for (int i=0;i<a.length;i++){
            checked[i]=a[i]= r.nextInt(10);
        }

        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }


        Quick.sort(checked);

        Stopwatch sw = new Stopwatch();
        double start = sw.elapsedTime();

        Arrays.sort(a);


        //assert isSorted(a);
        if( isSorted(a)) System.out.println("OK!!!!"); else System.out.println("NOT!!!");
        if( isOk(a,checked)) System.out.println("SORT OK !!!!"); else System.out.println("SORT NOT!!!");

        double stop=sw.elapsedTime();
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }

        System.out.println(start+" "+stop+"");

    }

    public static boolean isOk(Comparable[]a, Comparable[] checked){
        for (int i=1;i<a.length;i++){
            if(a[i].compareTo(checked[i])!=0)return false;
        }
        return true;
    }

    public static boolean isSorted(Comparable[] a){
        for (int i=1;i<a.length;i++){
            if(less(a[i],a[i-1]))return false;
        }
        return true;
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }
}
