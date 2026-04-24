package graph;

import java.util.*;

//通过这个例子，你可以清楚看出：DAG 算法依赖拓扑顺序，因而必须有向无环；而 Dijkstra 不要求无环，但要求无负权边。两者各自解决了一类最短路问题。
public class DAGSP<T> {
    private EdgeWeightedDigraph<T> G;
    private int s;//起点对应的序号
    private List<Integer> checkOrder; //拓扑顺序后 顶点顺序
    private boolean[] marked;//checkOrder是否进去
    private double[] disTo;
    private IEdge<T>[] edgeTo;// 改成 IEdge 数组

    public DAGSP(EdgeWeightedDigraph<T> G,T v){
        this.s = G.indexOf(v);
        this.G = G;
        checkOrder = new LinkedList<>();
        marked =new boolean[G.V()];
        disTo =new double[G.V()];
        edgeTo =new IEdge[G.V()];
        Arrays.fill(disTo,Double.POSITIVE_INFINITY);
        disTo[s] = 0;
        Arrays.fill(marked,Boolean.valueOf(false));

        //将G的顶点入checkOrder
        dfs(G,v);
        Collections.reverse(checkOrder);
        //按这个顺序，每次访问个顶点,
        for(int i:checkOrder){
            int TCorrespond = checkOrder.get(i);//按顺序对应的
            T correpondKey = G.getKey(TCorrespond);
            for(IEdge<T> item:G.adj(correpondKey)){
               relex(item,correpondKey);
            }
        }


    }
    private void relex(IEdge<T> item,T correpondKey){
        int TCorrespond = G.indexOf(correpondKey);
        T o = item.other(correpondKey);
        int ONum = G.indexOf(o);
        if(disTo[ONum] > disTo[TCorrespond] + item.weight()){
            edgeTo[ONum] = item;
            disTo[ONum] = disTo[TCorrespond] + item.weight();
        }
    }


    private void dfs(EdgeWeightedDigraph<T> G,T v ){
        marked[G.indexOf(v)] = true;
        for(IEdge<T> item:G.adj(v)){
            T o = item.other(v);
            int oNum = G.indexOf(o);
            if(!marked[oNum]) {
                dfs(G,o);
            }

        }
        checkOrder.add(G.indexOf(v));
    }

}
