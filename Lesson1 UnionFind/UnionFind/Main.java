import javax.swing.text.html.parser.Parser;
import java.io.*;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//"E://Kronshtadt//Algorithms and data structure//Homework//UnionFind//tinyUF.txt"

public class Main {

    public static void main(String[] args) {

        int N= StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q=StdIn.readInt();
            if(!uf.connected(p,q)){
                uf.connected(p,q);
                StdOut.println(p+" "+q);
            }
        }
    }
}
