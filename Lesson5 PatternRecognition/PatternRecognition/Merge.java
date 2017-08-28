import java.util.Comparator;

public class Merge {

    private static Comparable[] aux;

    private static void merge(Comparator comparator, Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        for (int i=lo;i<=hi;i++){
            aux[i]=a[i];
        }

        int i=lo;
        int j=mid+1;
        for (int k=lo;k<=hi;k++){
            if(i>mid) a[k]=aux[j++];
            else if(j>hi) a[k]=aux[i++];
            else if(less(comparator,aux[j],aux[i])) a[k]=aux[j++];
            else a[k]=aux[i++];


        }
    }

    private static void sort(Comparator comparator, Comparable[] a, Comparable[] aux, int lo, int hi){
        if(hi<=lo) return;
        int mid=lo+(hi-lo)/2;
        sort(comparator,a,aux,lo,mid);
        sort(comparator,a,aux,mid+1,hi);
        if(!less(comparator,a[mid+1], a[mid])) return;
        merge(comparator, a,aux,lo,mid,hi);
    }

    public static void sort(Comparable[] a, Comparator comparator){
        aux=new Comparable[a.length];
        sort(comparator,a,aux,0,a.length-1);
    }

    private static boolean less(Comparator c,Comparable v, Comparable w ){
        return c.compare(v,w)<0;
    }
}
