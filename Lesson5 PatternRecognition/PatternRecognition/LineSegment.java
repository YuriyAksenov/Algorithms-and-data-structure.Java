import edu.princeton.cs.algs4.StdDraw;

public class LineSegment {
    private Point p,q;
    // конструктор отрезка между p и q
    public LineSegment(Point p, Point q) {
        if(p==null || q==null) throw new NullPointerException("Trasmitted null argument");
        this.p=p;
        this.q=q;
    }
    // нарисовать отрезок
    public void draw() {
       p.drawTo(q);
    }
    // представление в виде строки
    public String toString(){
        return p+"->"+q;
    }
}