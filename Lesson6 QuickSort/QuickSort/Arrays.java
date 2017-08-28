//Системная сортировка в Java.

public class Arrays {

    private static int CUTOFF=10;

    private static int partition(Comparable[] a, int lo, int hi){
        int i=lo;
        int j=hi+1;
        Comparable v=a[lo];

        while (true){
            while (less(a[++i],v));
            while (less(v,a[--j]));

            if(i>=j) break;
            exch(a,i,j);
        }

        exch(a,lo,j);
        return j;
    }

    public static void sort(Comparable[] a){
        int iMax=0;
        for (int i =0;i<a.length;i++){
            if(a[iMax].compareTo(a[i])<0) iMax=i;
        }
        exch(a,iMax,a.length-1);
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi<=lo)return;
        if(hi<=lo+CUTOFF-1) {
            Insertion.sort(a,lo,hi);
            return;
        }

        int pos = (hi-lo)/9;

        int m1 = medianaOf3(a,lo+pos*1,lo+pos*2,lo+pos*3);
        int m2 = medianaOf3(a,lo+pos*4,lo+pos*5,lo+pos*6);
        int m3 = medianaOf3(a,(lo+pos*7),(lo+pos*8),(lo+pos*9));

        int m = medianaOf3(a,m1,m2,m3);
        exch(a,lo,m);

        int j = partition(a,lo,hi);


        sort(a,lo,j-1);
        sort(a,j+1,hi);

    }

    private static int medianaOf3(Comparable[] a, int lo, int mid, int hi){
        int min=lo;
        if(!less(a[lo],a[mid])) min=mid;
        if(!less(a[min],a[hi])) min = hi;
        return min;
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
