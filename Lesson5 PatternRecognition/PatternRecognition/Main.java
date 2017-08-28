import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Main {

    public static void main(String[] args) {
        //In in = new In(args[0]);
        In in = new In("E:\\Kronshtadt\\Algorithms and data structure\\Homework\\Lesson5\\PatternRecognition\\src\\collinear\\input400.txt");

        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        //рисуем точки
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();

            /*try {
                StdDraw.show();
                Thread.sleep(100);
            }catch (Exception e){

            }*/
        }
        StdDraw.show();

        //печатаем и рисуем отрезки
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();

            /*
            try {
                StdDraw.show();
                Thread.sleep(100);
            }catch (Exception e){

            }*/
        }
        StdDraw.show();
    }
}
