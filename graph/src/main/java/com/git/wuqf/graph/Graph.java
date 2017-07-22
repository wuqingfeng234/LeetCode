package com.git.wuqf.graph;

import java.util.*;


public class Graph {
    private Set<Integer> vertexes=new HashSet<Integer>();
    private List<int[]> edges=new ArrayList<int[]>();

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
        Map<Integer, Integer> vertexDegree = new HashMap<Integer, Integer>();
        List<Integer> deletedVertex=new ArrayList<Integer>();

        Iterator<int[]> ie = edges.iterator();

        while (ie.hasNext()) {
            int[] e = ie.next();
            if(!vertexDegree.containsKey(e[0])){
                vertexDegree.put(e[0],1);
            }
            else {
                vertexDegree.put(e[0],vertexDegree.get(e[0])+1);
            }
        }

        for(Map.Entry<Integer,Integer> entry:vertexDegree.entrySet()){
            if(entry.getValue()==0){
                Integer key=entry.getKey();
                deleteEdgeByStartVetex(key);
                Integer v= vertexDegree.remove(key);

                deletedVertex.add(v);
            }

        }
        return deletedVertex;
    }
    public void deleteEdgeByStartVetex(int startVetex){
        Iterator<int[]> ie = edges.iterator();
        while (ie.hasNext()){
            int[] e=ie.next();
            if(e[1]==startVetex){
                ie.remove();
            }
        }
    }

}
