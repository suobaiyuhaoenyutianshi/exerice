package graph;

import java.util.TreeMap;

public interface Graph<T> {
    int V();
    void addEdge(T v,T w);
    Iterable<T> adj(T v);
    TreeMap<T,Integer> correspond();
    T getVertex(int index);
    public int findCorrspondence(T v);
}
