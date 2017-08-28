import java.util.*;

public class FastCollinearPoints {


    private ArrayList<LineSegment> lineSegments = new ArrayList<LineSegment>();
    private Point[] _points;
    private int countSegments;

    // находит все отрезки состоящие из 4
    // и более точек
    public FastCollinearPoints(Point[] points) {

        if (points == null) throw new IllegalArgumentException("Argument is null");

        for (int i = 0; i < points.length; i++) if (points[i] == null) throw new IllegalArgumentException("Argument is null");

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++)
                if (points[i].compareTo(points[j]) == 0 && i != j) throw new IllegalArgumentException("Argument is null");
        }

        int n = points.length;
        countSegments = 0;


        for (int i = 0; i < n; i++) {

            _points = new Point[n];
            int _n = _points.length;
            for (int p = 0; p < n; p++) {
                _points[p] = points[p];
            }

            /*
            _points = new Point[n-i];
            int _n = _points.length;
            for (int p = i; p < n; p++) {
                _points[p-i] = points[p];
            }
             */

            Point main = _points[i];
            Merge.sort(_points, main.slopeOrder());

            /*
            for (int p = 1; p < _points.length; p++) {
                System.out.println("point 0=" + _points[0] + " point" + p + "=" + _points[p] + "  k=" + _points[0].slopeTo(_points[p]));
            }*/

            int count = 1;
            for (int j = 0; j < _n - 1; j++) {
                if (main.slopeTo(_points[j]) == main.slopeTo(_points[j + 1])) count++;
                else {
                    if (count >= 3) {
                        countSegments++;
                        Point max = main;
                        Point min = main;
                        for (int k = 1; k <= count; k++) {
                            if (max.compareTo(_points[j - count + k]) < 0) max = _points[j - count + k];
                            if(min.compareTo(_points[j-count+k])>0) min=_points[j-count+k];
                        }
                        lineSegments.add(new LineSegment(min, max));

                    }
                    count = 1;
                }
            }
        }

    }

    // количество отрезков
    public int numberOfSegments() {
        return countSegments;
    }

    // отрезки
    public LineSegment[] segments() {
        return lineSegments.toArray(new LineSegment[countSegments]);
    }
}
