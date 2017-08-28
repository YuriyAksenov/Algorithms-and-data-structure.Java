public class Insertion {
    public static void sort(Comparable[] a, int lo, int hi){

        int N=hi+1;
        for (int i=lo;i<N;i++){
            Comparable arrow=a[i];
            int insertJ=find(a,lo,i,arrow);
            for (int j=i;j>insertJ;j--){
                a[j]=a[j-1];
            }
            a[insertJ]=arrow;

        }
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

}
