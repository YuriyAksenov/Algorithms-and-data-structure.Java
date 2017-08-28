import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.Comparator;


public class Point implements Comparable<Point> {

    public int x,y;

    // конструктор точки (x, y)
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    // нарисовать точку
    public void draw(){
        StdDraw.point(x, y);
        //StdDraw.text(x+300,y+300, toString());
        StdDraw.setPenColor(Color.RED);
        StdDraw.circle(x,y,200);
        StdDraw.setPenColor(Color.black);
    }
    // нарисовать отрезок от данной точки
    public void drawTo(Point that) {
        StdDraw.line(x,y,that.x,that.y);
    }
    // до that

    // представление в виде строки
    public String toString(){
        return "("+x+","+y+")";
    }
    // сравнить две точки по y-координатам,
    //при равенстве, по x-координатам
    public int compareTo(Point that) {
        if(x<that.x) return -1;
        if(x==that.x && y<that.y) return -1;
        if(y==that.y && x==that.x) return 0;
        return 1;
    }
    // наклон между данной точкой и точкой that
    public double slopeTo(Point that){
        if(y==that.y && x==that.x) return Double.NEGATIVE_INFINITY;
        if(x==that.x) return Double.POSITIVE_INFINITY;
        if(y==that.y) return 0;
        return (((double)that.y-(double)y)/((double)that.x-(double)x));

    }

    // сравнить две точки по их наклону
// с данной точкой
    public Comparator<Point> slopeOrder(){
        return new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if(slopeTo(p1)<slopeTo(p2))return -1;
                return 1;
            }
        };
    }
}