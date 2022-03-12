import java.io.*;
import java.util.*;
class Main {
    private int V;
    private ArrayList < ArrayList < Integer > > adj;
    Main(int v) {
        V = v;
        adj = new ArrayList < ArrayList < Integer > > (v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList < Integer > ());
    }
    void addAresta(int v, int w) {
        adj.get(v).add(w);
    }
    void ordemLinearProfund(int v, boolean visitado[],
        Stack < Integer > st) {
        visitado[v] = true;
        Integer i;
        Iterator < Integer > it = adj.get(v).iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visitado[i])
                ordemLinearProfund(i, visitado, st);
        }
        st.push(new Integer(v));
    }
    void ordemLinear() {
        Stack < Integer > st = new Stack < Integer > ();
        boolean visitado[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visitado[i] = false;
        for (int i = 0; i < V; i++)
            if (visitado[i] == false)
                ordemLinearProfund(i, visitado, st);
        while (st.empty() == false)
            System.out.print(st.pop() + " ");
    }
    public static void main(String args[]) {
        Main g = new Main(7);
        g.addAresta(1, 5);
        g.addAresta(1, 2);
        g.addAresta(2, 3);
        g.addAresta(5, 3);
        g.addAresta(5, 4);
        g.addAresta(6, 5);
        g.addAresta(6, 1);
        g.addAresta(0, 1);
        g.addAresta(0, 2);
        System.out.println("Ordem Linear 1: ");
        g.ordemLinear();

        System.out.println();

        Main g2 = new Main(8);
        g2.addAresta(0, 2);
        g2.addAresta(1, 3);
        g2.addAresta(2, 3);
        g2.addAresta(2, 4);
        g2.addAresta(2, 5);
        g2.addAresta(3, 6);
        g2.addAresta(4, 7);
        g2.addAresta(5, 7);
        System.out.println("Ordem Linear 2: ");
        g2.ordemLinear();

        System.out.println();

        Main g3 = new Main(4);
        g3.addAresta(0, 1);
        g3.addAresta(0, 2);
        g3.addAresta(1, 2);
        g3.addAresta(1, 3);
        g3.addAresta(2, 3);
        System.out.println("Ordem Linear 3: ");
        g3.ordemLinear();
    }
}