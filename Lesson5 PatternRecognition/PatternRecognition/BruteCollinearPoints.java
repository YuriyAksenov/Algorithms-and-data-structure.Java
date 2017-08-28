import java.lang.reflect.Array;
import java.util.ArrayList;

public class BruteCollinearPoints {

    private int[] checkedArray;
    private ArrayList<LineSegment> lineSegments;
    private int countSegments = 0;
    // найти все отрезки состоящие из 4 точек
    public BruteCollinearPoints(Point[] points){
        if(points==null) throw  new IllegalArgumentException("Argument is null");

        int n=points.length;

        for (int i=0;i<n;i++){
            if(points[i]==null) throw  new IllegalArgumentException("Argument is null");
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++){
                if(points[i].compareTo(points[j])==0 && i!=j) throw  new IllegalArgumentException("Argument is null");
            }
        }


        // p - 1 точка
        // q - 2 точка
        // r - 3 точка
        // s - 4 точка

        lineSegments = new ArrayList<>();

        countSegments = 0;
        for (int p=0;p<n;p++){
            Point pPoint = points[p];
            for(int q=p+1;q<n;q++){
                Point qPoint = points[q];
                for (int r=q+1;r<n;r++){
                    Point rPoint = points[r];
                    for(int s=r+1;s<n;s++){
                        Point sPoint = points[s];

                        if(pPoint.slopeTo(qPoint)==pPoint.slopeTo(rPoint) && pPoint.slopeTo(qPoint)==pPoint.slopeTo(sPoint)){

                            Point min1;
                            Point min2;
                            Point max1;
                            Point max2;

                            if(pPoint.compareTo(qPoint)<1){
                                min1=pPoint;
                                max1=qPoint;
                            }else {
                                min1=qPoint;
                                max1=pPoint;
                            }
                            if(rPoint.compareTo(sPoint)<1){
                                min2=rPoint;
                                max2=sPoint;
                            }else
                                {
                                    min2=sPoint;
                                    max2=rPoint;
                            }

                            Point min;
                            Point max;

                            if(min1.compareTo(min2)<0){
                                min=min1;
                            }
                            else {
                                min=min2;
                            }

                            if(max1.compareTo(max2)>0){
                                max=max1;
                            }
                            else {
                                max=max2;
                            }

                            lineSegments.add(new LineSegment(min,max));
                            countSegments++;

                        }

                    }
                }
            }
        }

    }
    // количество отрезков
    public int numberOfSegments(){
        return countSegments;
    }
    // отрезки
    public LineSegment[] segments() {
        return lineSegments.toArray(new LineSegment[countSegments]);
    }
}