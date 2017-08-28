//Быстрое трехчастное разбиение (Дж. Бентли и Д. МакИлрой).

import edu.princeton.cs.algs4.StdRandom;

public class QuickX {

    private static int partition(Comparable[] a, int lo, int hi){
        int i=lo+1;
        int p=lo;
        int j=hi;
        int q=hi;

        Comparable v=a[lo];

        while (true) {
            while (less(a[i], v)){
                if(a[i].compareTo(v)==0){
                    p++;
                }

                System.out.println("i "+i);

                i++;
            }

            while (less(v, a[j])) {
                if(a[j].compareTo(v)==0){

                    q--;
                }
                System.out.println("j "+j);
                j--;
            }

            if (i >= j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }

    public static void sort(Comparable[] a){
        //StdRandom.shuffle(a);
        int iMax=0;
        for(int i=0;i<a.length;i++){
            if(a[iMax].compareTo(a[i])<0) {
                iMax=i;
            }
        }
        exch(a,iMax,a.length-1);
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if (hi<=lo) return;

        int j=partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i]=a[j];
        a[j]=swap;
    }
}
