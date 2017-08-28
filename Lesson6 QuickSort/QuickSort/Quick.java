//Сигнальные ключи.

import edu.princeton.cs.algs4.StdRandom;

public class Quick {


    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi+1;
        Comparable v=a[lo];
        while (true) {

            while (less(a[++i], v)) {
                //if (i == hi) break;
            }
            while (less(v, a[--j])) {
                //if (j == lo) break;
            }

            if (i >= j) break;
            exch(a, i, j);
        }

        exch(a,lo,j);
        return j;
    }

    public static void sort(Comparable[]a){
        //StdRandom.shuffle(a);
        Comparable max=a[0];
        int iMax=0;
        for (int i =0;i<a.length;i++){
            if(max.compareTo(a[i])<0) {max=a[i]; iMax=i;}
        }

        exch(a, iMax,a.length-1);
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi<=lo) return;
        int j=partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
