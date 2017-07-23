package com.git.wuqf.graph.table;

import java.util.*;


public class Graph {
    private Set<Integer> vertexes;
    private List<int[]> adjacencyTable;

    public Graph(int numCourses, int[][] edges) {
        vertexes = new HashSet<Integer>(numCourses*2);
        adjacencyTable = new ArrayList<int[]>(numCourses*2);

        for (int i = 0; i < numCourses; i++) {
            this.vertexes.add(i);
        }
        for (int i = 0; i < edges.length; i++) {
            this.adjacencyTable.add(edges[i]);
        }
    }

    public Set<Integer> getVertexes() {
        return vertexes;
    }

    public void setVertexes(Set<Integer> vertexes) {
        this.vertexes = vertexes;
    }

    public void setAdjacencyTable(List<int[]> adjacencyTable) {
        this.adjacencyTable = adjacencyTable;
    }

    public List<int[]> getAdjacencyTable() {
        return adjacencyTable;
    }


    public List<Integer> deleteStartVertex() {
        Set<Integer> vertexInDegree = new HashSet<Integer>();
        List<Integer> deletedVertex = new ArrayList<Integer>();

        for (int[] e : adjacencyTable) {
            int startVertex = e[1];
            vertexInDegree.add(startVertex);

        }

        Iterator<int[]> ie = adjacencyTable.iterator();

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
