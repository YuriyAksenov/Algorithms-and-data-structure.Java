
//Сортировка вставками без перестановок.

//Сортировка вставками с маркером конца.

public class InsertionX {
    public static void sort(Comparable[] a){

        int N=a.length;

        // Сортировка вставками с маркером конца.
        int min=0;
        for(int i=0;i<N;i++){
            if(less(a[i],a[min])) min=i;
        }
        exch(a,min,0);


        for (int i=1;i<N;i++){
            Comparable arrow=a[i];
            for (int j=i;;j--){
                if(less(arrow,a[j-1])) {
                    a[j]=a[j-1];
                }
                else {
                    a[j]=arrow;
                    break;}
            }

        }
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

    //только для улучшения //Сортировка вставками с маркером конца.
    private static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i]=a[j];
        a[j]=swap;
    }
}