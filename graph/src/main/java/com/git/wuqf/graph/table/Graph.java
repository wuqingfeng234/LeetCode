package com.git.wuqf.graph.table;

import java.util.*;


public class Graph {
    private Set<Integer> vertexes = new HashSet<Integer>();
    private List<int[]> edges = new ArrayList<int[]>();

    public Graph(int[][] edges) {

        for (int i = 0; i < edges.length; i++) {
            vertexes.add(edges[i][0]);
            vertexes.add(edges[i][1]);
            this.edges.add(edges[i]);
        }
    }


    public Set<Integer> getVertexes() {
        return vertexes;
    }

    public void setVertexes(Set<Integer> vertexes) {
        this.vertexes = vertexes;
    }

    public List<int[]> getEdges() {
        return edges;
    }

    public void setEdges(List<int[]> edges) {
        this.edges = edges;
    }

    public List<Integer> deleteStartVertex() {
        Set<Integer> vertexInDegree = new HashSet<Integer>();
        List<Integer> deletedVertex = new ArrayList<Integer>();

        for (int[] e : edges) {
            int startVertex = e[1];
            vertexInDegree.add(startVertex);

        }

        Iterator<int[]> ie = edges.iterator();

        while (ie.hasNext()) {
            int[] e = ie.next();
            Integer key = e[0];
            if (!vertexInDegree.contains(key)) {
                ie.remove();
                deletedVertex.add(key);
            }
        }
        return deletedVertex;
    }

}
