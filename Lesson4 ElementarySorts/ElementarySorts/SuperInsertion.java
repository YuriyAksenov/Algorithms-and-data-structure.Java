//Супералгоритм сортировки вставками.

public class SuperInsertion {

    public static void sort(Comparable[] a){

        int N=a.length;

        if(N<=50){
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
        else {
            for (int i=0;i<N;i++){
                Comparable arrow=a[i];
                int insertJ=find(a,0,i,arrow);
                for (int j=i;j>insertJ;j--){
                    a[j]=a[j-1];
                }
                a[insertJ]=arrow;

            }
        }

        // Сортировка вставками с маркером конца.
       /* int min=0;
        for(int i=0;i<N;i++){
            if(less(a[i],a[min])) min=i;
        }
        exch(a,min,0);*/



    }

    private static int find(Comparable[] a,int lo,int hi, Comparable arrow){
        if(lo==hi) return lo;
        int midI = lo+(hi-lo)/2;
        if(less(arrow,a[midI])){
            return find(a,lo,midI,arrow);
        }else {
            return find(a,midI+1,hi,arrow);
        }
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
